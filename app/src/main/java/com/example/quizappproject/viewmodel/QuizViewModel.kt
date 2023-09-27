package com.example.quizappproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.repository.QuizRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val repository: QuizRepository):ViewModel() {

    private val _quiz = MutableStateFlow(QuizState())
    val quiz : StateFlow<QuizState> = _quiz.asStateFlow()

    fun loadHome1(){
        val home1 = repository.getHome1()
        _quiz.value = _quiz.value.copy(home1 =  home1)
    }

    fun loadExplore(){
        val explore = repository.getExplore()
        _quiz.value = _quiz.value.copy(explore = explore)
    }

    fun loadQuestions(){
        val questions = repository.getQuestions()
        _quiz.value = _quiz.value.copy(questions = questions)
    }

}