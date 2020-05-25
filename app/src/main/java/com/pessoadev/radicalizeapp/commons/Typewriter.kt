package com.pessoadev.radicalizeapp.commons

import android.os.Handler
import android.widget.TextView

class Typewriter(private val textView: TextView) {
    private var sText = ""
    private var index = 0
    private val mDelay: Long = 30
    lateinit var onFinishListener: OnFinishListener

    fun animateText(string: String?) {
        sText = string!!
        index = 0
        textView.text = ""
        Handler().removeCallbacks(characterAdder)
        Handler().postDelayed(characterAdder, mDelay)
    }

    private val characterAdder: Runnable = object : Runnable {
        override fun run() {
            textView.text = sText.subSequence(0, index++)
            if (index <= sText.length) {
                Handler().postDelayed(this, mDelay)
            } else {
                onFinishListener.onFinish()
            }
        }
    }

    inline fun setOnFinishListener(crossinline listener: () -> Unit) {
        this.onFinishListener = object :
            OnFinishListener {
            override fun onFinish() = listener()
        }
    }


    interface OnFinishListener {
        fun onFinish() = Unit
    }

}