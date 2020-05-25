package com.pessoadev.radicalizeapp.presentation.splash


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.pessoadev.radicalizeapp.presentation.main.presentation.MainActivity
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.OnboardingActivity
import com.pessoadev.radicalizeapp.commons.Const


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val intent: Intent = if (getBoolean(Const.ONBOARDING, false)) {
                Intent(this@SplashActivity, MainActivity::class.java)
            } else {
                Intent(this@SplashActivity, OnboardingActivity::class.java)
            }

            startActivity(intent)
            finish()
        }


    }
}