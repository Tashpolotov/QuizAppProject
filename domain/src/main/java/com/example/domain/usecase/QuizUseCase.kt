package com.example.domain.usecase

import com.example.domain.repository.QuizRepository

class QuizUseCase(private val repository: QuizRepository) {

    operator fun invoke(){
        repository.getHome1()
        repository.getExplore()
        repository.getQuestions()
    }
}