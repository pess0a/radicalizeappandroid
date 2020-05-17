package com.pessoadev.radicalizeapp.presentation.main

import `in`.codeshuffle.typewriterview.TypeWriterView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pessoadev.radicalizeapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create Object and refer to layout view
        var tv = textView as TypeWriterView
        tv.setDelay(1000)
        tv.animateText("Surf, skate, montain bike, tirolesa ou bungee jumping? \\n\\nAqui no Radicalize você encontra os lugares mais radicais próximos a você. \\n\\nÉ Só procurar na lista ou no mapa!")

    }


}
