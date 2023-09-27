package com.example.quizappproject.fragment.onboard

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext context:Context){

    private val sharedPref: SharedPreferences = context.getSharedPreferences(
        "shared", Context.MODE_PRIVATE
    )

    fun isShow():Boolean {
        return sharedPref.getBoolean("show", false)
    }

    fun setShow(isShow:Boolean) {
        sharedPref.edit().putBoolean("show", isShow).apply()
    }
}