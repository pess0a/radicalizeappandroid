package com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.onboarding.presenatation.OnboardingFragment

class FragmentAdapter(var fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment.newInstance(
                fa.resources.getString(R.string.first_text_onboarding),
                false
            )
            1 -> OnboardingFragment.newInstance(
                fa.resources.getString(R.string.second_text_onboarding),
                false
            )
            else -> OnboardingFragment.newInstance(
                fa.resources.getString(R.string.third_text_onboarding),
                true
            )
        }
    }

}