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
import com.example.domain.model.ExploreModel
import com.example.quizappproject.R
import com.example.quizappproject.adapter.ExploreAdapter
import com.example.quizappproject.databinding.FragmentExploreQuizBinding
import com.example.quizappproject.viewmodel.QuizViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExploreQuizFragment : Fragment() {

    private lateinit var binding:FragmentExploreQuizBinding
    private val viewModel by viewModels<QuizViewModel>()
    private val adapter = ExploreAdapter(this::onClick)
    private lateinit var sharedPref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentExploreQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPref = requireContext().getSharedPreferences("my_pref", Context.MODE_PRIVATE)
        initBtn()
        initAdapter()
    }

    private fun initAdapter() {
        binding.rv1.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.quiz.collect{
                adapter.submitList(it.explore)
            }
        }
        viewModel.loadExplore()
    }

    private fun initBtn() {
        binding.card1.setOnClickListener {
            val fragment = HoeScreenFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun onClick(model:ExploreModel) {
        binding.btnStart.setOnClickListener {
            val editor = sharedPref.edit()
            // Обновите данные в SharedPreferences с новой категорией
            editor.putString("category", model.category)
            // Сохраните обновления
            editor.apply()
            val fragment = HoeScreenFragment()
            val bundle = Bundle()
            bundle.putString("category", model.category)
            fragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}