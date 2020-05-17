package com.pessoadev.radicalizeapp.presentation.onboarding.presenatation

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.onboarding.util.Typewriter
import kotlinx.android.synthetic.main.fragment_onboarding.*
import kotlinx.android.synthetic.main.fragment_onboarding.view.*


private const val TEXT_PARAM = "text"
private const val LAST_PAGE_PARAM = "lastPage"

class OnboardingFragment : Fragment() {

    private var text: String? = ""
    private var lastPage: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(TEXT_PARAM)
            lastPage = it.getBoolean(LAST_PAGE_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Typewriter(view.textViewAnimate).apply {
            animateText(text)
            setOnFinishListener {
                askPermission()
            }
        }

        if (lastPage) {
            buttonNext.text = getString(R.string.start)
        }

        buttonNext.setOnClickListener {
            (activity as OnboardingActivity).onButtonNextClicked()
        }
    }



    private fun askPermission() {
        Dexter.withContext(activity)
            .withPermissions(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    //todo mostrar msg que ja foi dada a permissao
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) {
                }
            }).check()
    }

    companion object {
        @JvmStatic
        fun newInstance(text: String, lastPage: Boolean) =
            OnboardingFragment().apply {
                arguments = Bundle().apply {
                    putString(TEXT_PARAM, text)
                    putBoolean(LAST_PAGE_PARAM, lastPage)
                }
            }
    }
}