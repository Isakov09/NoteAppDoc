package com.example.noteappdoc.utils

import android.content.Context
import android.content.SharedPreferences
   open class PreferenceHelper() {
        private lateinit var sharedPreference: SharedPreferences

        fun unit(context: Context){
            sharedPreference = context.getSharedPreferences("shared" , Context.MODE_PRIVATE)
        }

        var text: String?
            get() = sharedPreference.getString("text", "")
            set(value) = sharedPreference.edit().putString("text", value)!!.apply()

        var isOnBoarShow:Boolean
            get() = sharedPreference.getBoolean("board",false)
            set(value) = sharedPreference.edit().putBoolean("board", value).apply()

        var saveBoolean
            set(value) = sharedPreference?.edit()?.putBoolean("Bool", value!!)?.apply()!!
            get() = sharedPreference?.getBoolean("Bool", false)
    }