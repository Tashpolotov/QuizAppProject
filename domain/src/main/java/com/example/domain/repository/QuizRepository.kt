package com.example.domain.repository

import com.example.domain.model.ExploreModel
import com.example.domain.model.Home1Model
import com.example.domain.model.QuestionsModel

interface QuizRepository {

    fun getHome1():List<Home1Model>

    fun getExplore():List<ExploreModel>

    fun getQuestions():List<QuestionsModel>
}