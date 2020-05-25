package com.pessoadev.radicalizeapp.presentation.onboarding.presenatation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.android.material.tabs.TabLayoutMediator
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.main.presentation.MainActivity
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.adapter.FragmentAdapter
import com.pessoadev.radicalizeapp.commons.Const
import kotlinx.android.synthetic.main.activity_onboarding.*


class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)


        pager.offscreenPageLimit = 1
        pager.adapter = FragmentAdapter(this)
        pager.isUserInputEnabled = false

        TabLayoutMediator(tabs, pager) { tab, position ->

        }.attach()
    }

    companion object {

    }

    fun onButtonNextClicked() {
        pager.currentItem = pager.currentItem + 1
    }

    fun onFinishOnboarding() {
        PreferenceManager.getDefaultSharedPreferences(this).edit().apply {
            putBoolean(Const.ONBOARDING, true)
            apply()
        }
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}

