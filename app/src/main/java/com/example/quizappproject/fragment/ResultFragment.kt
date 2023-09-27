package com.example.quizappproject.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizappproject.R
import com.example.quizappproject.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private lateinit var binding:FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val correctAnswersCount = arguments?.getInt("correctAnswersCount", 0) ?: 0
        val totalQuestions = arguments?.getInt("totalQuestions", 0) ?: 0

        Log.d("ResultFragment", "Correct Answers: $correctAnswersCount, Total Questions: $totalQuestions")

        val resultText = "$correctAnswersCount/$totalQuestions"
        binding.tvScore.text = resultText

        binding.btnMenu.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fr_container, HoeScreenFragment())
                .addToBackStack(null)
                .commit()
        }



        binding.btnRestart.setOnClickListener {

            parentFragmentManager.beginTransaction()
                .replace(R.id.fr_container, ExploreQuizFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}