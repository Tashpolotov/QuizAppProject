package com.example.quizappproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizappproject.R
import com.example.quizappproject.databinding.FragmentIntroductionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroductionFragment : Fragment() {

    private lateinit var binding:FragmentIntroductionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentIntroductionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = arguments?.getString("name")
        binding.tvNameCategory.text = name
        initBtn()
    }

    private fun initBtn() {
        binding.btnNext.setOnClickListener {
            val name = arguments?.getString("name")
            val img = arguments?.getInt("img")
            val fragment = QuestionsFragment()
            val bundle = Bundle()
            bundle.putString("name", name)
            if (img != null) {
                bundle.putInt("img", img)
            }
            fragment.arguments = bundle
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fr_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}