package com.example.quizappproject.fragment.onboard

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.quizappproject.R
import dagger.hilt.android.qualifiers.ApplicationContext

class Adapter(@ApplicationContext fragment: FragmentActivity):FragmentStateAdapter(fragment) {

    private val listBoarding = arrayOf(
        OnBoardModel(
         R.drawable.unions, 0,""
        ),
        OnBoardModel(   0, R.drawable.img,
            "Test your knowledge of the arts with our app")
    )

    override fun getItemCount(): Int = listBoarding.size

    override fun createFragment(position: Int): Fragment {
        val data = bundleOf("board" to listBoarding[position])
        val fragment = OnBoardFragment()
        fragment.arguments = data
        return fragment
    }


}