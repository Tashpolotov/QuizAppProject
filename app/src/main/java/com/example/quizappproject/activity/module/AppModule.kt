package com.example.quizappproject.activity.module

import android.app.Application
import android.content.Context
import com.example.data.QuizRepositoryMock
import com.example.domain.repository.QuizRepository
import com.example.domain.usecase.QuizUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideRepository(context: Context):QuizRepository{
        return QuizRepositoryMock(context)
    }

    @Provides
    @Singleton
    fun provideUseCase(repositoryMock: QuizRepositoryMock):QuizUseCase{
        return QuizUseCase(repositoryMock)
    }

}