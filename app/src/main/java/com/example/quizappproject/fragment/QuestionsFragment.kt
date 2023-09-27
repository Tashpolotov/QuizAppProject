package com.example.quizappproject.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.domain.model.QuestionsModel
import com.example.quizappproject.R
import com.example.quizappproject.adapter.QuestionsAdapter
import com.example.quizappproject.databinding.FragmentQuestionsBinding
import com.example.quizappproject.viewmodel.QuizViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuestionsFragment : Fragment() {

    private lateinit var binding:FragmentQuestionsBinding
    private val viewModel  by viewModels<QuizViewModel>()
    private val adapter = QuestionsAdapter()
    private var isCurrentQuestionAnswered = false
    private var currentQuestionIndex = 0
    private var correctAnswersCount = 0
    private var questions: List<QuestionsModel>? = null
    private val selectedAnswers = mutableMapOf<Int, Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString("name")
        val img = arguments?.getInt("img")
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.quiz.collect {
                questions = it.questions.filter { it.nameTest == name }
                adapter.submitList(listOf(questions?.get(currentQuestionIndex)))
                if(img != null) {
                    binding.imgRecycler.setImageResource(img)
                }
                updateQuestionCountText()
            }
        }
        viewModel.loadQuestions()

        initAdapter()

    }

    private fun initAdapter() {
        binding.rv.adapter = adapter

        adapter.setOnAnswerClickListener(object : QuestionsAdapter.OnAnswerClickListener {
            override fun onAnswerClick(selectedIndex: Int) {
                isCurrentQuestionAnswered = true

                val currentQuestion = questions?.get(currentQuestionIndex)
                if (currentQuestion != null && currentQuestion.currentAnswer.toInt() == selectedIndex) {
                    correctAnswersCount++
                }
            }
        })
        adapter.clearAnsweredQuestions()

        binding.btnNext.setOnClickListener {
            if (currentQuestionIndex < questions?.size ?: 0 && isCurrentQuestionAnswered) {
                currentQuestionIndex++
                isCurrentQuestionAnswered = false
                adapter.clearAnsweredQuestions()
                updateQuestionCountText()
                if (currentQuestionIndex < questions?.size ?: 0) {
                    adapter.submitList(listOf(questions?.get(currentQuestionIndex)))
                }

                if (currentQuestionIndex == questions?.size ?: 0) {
                    Log.d("QuestionFragment", "Quiz completed. Correct answers: $correctAnswersCount")


                    val fragment = ResultFragment()
                    val args = Bundle()
                    args.putInt("correctAnswersCount", correctAnswersCount)
                    args.putInt("totalQuestions", questions?.size ?: 0)
                    fragment.arguments = args

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fr_container, fragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }
    private fun updateQuestionCountText() {
        val currentQuestionNumber = currentQuestionIndex + 1
        val totalQuestions = questions?.size ?: 0
        val questionCountText = "$currentQuestionNumber/$totalQuestions"
        binding.tvScoreQuestions.text = questionCountText
    }

}
