package com.pessoadev.radicalizeapp


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.pessoadev.radicalizeapp.presentation.main.MainActivity
import com.pessoadev.radicalizeapp.R



class SplashActivity : AppCompatActivity() {
    var splashTime: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}