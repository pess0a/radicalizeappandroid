package com.pessoadev.radicalizeapp.presentation.onboarding.presenatation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import com.google.android.material.tabs.TabLayoutMediator
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.adapter.FragmentAdapter
import kotlinx.android.synthetic.main.activity_onboarding.*


class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        pager.adapter =
            FragmentAdapter(
                this
            )

        TabLayoutMediator(tabs, pager) { tab, position ->

        }.attach()

    }

    fun onButtonNextClicked() {
        pager.currentItem = pager.currentItem +1
        if (pager.currentItem == pager.size) {
            //todo open proxima tela depois do onboarding
        }
    }

}

