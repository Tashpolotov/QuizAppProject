package com.example.quizappproject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizappproject.R
import com.example.quizappproject.databinding.ActivityMainBinding
import com.example.quizappproject.fragment.ExploreQuizFragment
import com.example.quizappproject.fragment.HoeScreenFragment
import com.example.quizappproject.fragment.onboard.Preferences
import com.example.quizappproject.fragment.onboard.ViewPagerFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    @Inject
    lateinit var preferences: Preferences
    private lateinit var onBoardingCompletedKey: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onBoardingCompletedKey = "onBoardingCompleted"


        if (savedInstanceState == null) {
            if (!preferences.isShow()) {
                supportFragmentManager.beginTransaction().replace(R.id.fr_container, ViewPagerFragment())
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fr_container, ExploreQuizFragment()).commit()
            }
        }

    }

    override fun onBackPressed() {
        finish()
    }
}