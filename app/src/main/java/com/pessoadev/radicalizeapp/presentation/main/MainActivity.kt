package com.pessoadev.radicalizeapp.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.OnboardingActivity
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.OnboardingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        PreferenceManager.getDefaultSharedPreferences(this).apply {

            if (!getBoolean(OnboardingActivity.completed_onboarding, false)) {
                startActivity(Intent(this@MainActivity, OnboardingActivity::class.java))
            }
        }
    }


}



