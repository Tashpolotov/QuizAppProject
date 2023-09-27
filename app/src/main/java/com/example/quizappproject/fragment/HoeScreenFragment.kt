package com.example.quizappproject.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.Home1Model
import com.example.quizappproject.R
import com.example.quizappproject.adapter.Home1Adapter
import com.example.quizappproject.databinding.FragmentHoeScreenBinding
import com.example.quizappproject.viewmodel.QuizViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoeScreenFragment : Fragment() {

    private lateinit var binding: FragmentHoeScreenBinding
    private val viewModel by viewModels<QuizViewModel>()
    private val adapter = Home1Adapter(this::onClick)
    private lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHoeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("my_pref", Context.MODE_PRIVATE)

        initAdapter()
        initBtn()

    }

    private fun initBtn() {
        binding.card2.setOnClickListener {
            val fragment = ExploreQuizFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun initAdapter() {
        val category = arguments?.getString("category") ?: loadCategoryFromSharedPreferences()

        binding.rv1.adapter = adapter

        // Загрузите данные для сохраненной или выбранной категории
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.quiz.collect {
                val categoryBundle = it.home1.filter { it.category == category }
                adapter.submitList(categoryBundle)

                // Сохраняем данные в SharedPreferences после загрузки
                saveCategoryToSharedPreferences(category)
            }
        }
        viewModel.loadHome1()
    }

    private fun loadCategoryFromSharedPreferences(): String {
        return sharedPref.getString("category", "") ?: ""
    }

    private fun saveCategoryToSharedPreferences(category: String) {
        val editor = sharedPref.edit()
        editor.putString("category", category)
        editor.apply()
    }

    private fun onClick(model: Home1Model) {
        val fragment = IntroductionFragment()
        val bundle = Bundle()
        bundle.putString("category", model.category)
        bundle.putString("name", model.name)
        bundle.putInt("img", model.img)
        fragment.arguments = bundle
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}






