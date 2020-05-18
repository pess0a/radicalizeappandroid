package com.pessoadev.radicalizeapp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.pessoadev.radicalizeapp.presentation.main.MainActivity
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.OnboardingActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        var intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()

    }
}