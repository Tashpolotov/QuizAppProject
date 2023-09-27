package com.example.quizappproject.viewmodel

import com.example.domain.model.ExploreModel
import com.example.domain.model.Home1Model
import com.example.domain.model.QuestionsModel

data class QuizState (
    val home1 : List<Home1Model> = emptyList(),
    val explore : List<ExploreModel> = emptyList(),
    val questions : List<QuestionsModel> = emptyList(),

        )