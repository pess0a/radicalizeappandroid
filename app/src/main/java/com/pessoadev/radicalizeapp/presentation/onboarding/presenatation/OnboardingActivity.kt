package com.pessoadev.radicalizeapp.presentation.onboarding.presenatation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.android.material.tabs.TabLayoutMediator
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.main.MainActivity
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.adapter.FragmentAdapter
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
        val completed_onboarding: String = "Onboarding complete"
    }

    fun onButtonNextClicked() {
        pager.currentItem = pager.currentItem + 1

        if (pager.currentItem == 3) {
            startActivity(Intent(this, MainActivity::class.java))
            PreferenceManager.getDefaultSharedPreferences(this).edit().apply {
                putBoolean(completed_onboarding, true)
                apply()


            }
            //todo everton - aqui ficará o inserir boleano para o sharedpreference
            finish()
        }
    }

}

