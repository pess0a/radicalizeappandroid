package com.pessoadev.radicalizeapp.presentation.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pessoadev.radicalizeapp.R
import com.pessoadev.radicalizeapp.presentation.base.ActivitiesAdapter
import kotlinx.android.synthetic.main.activity_main.*

import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActivitiesByState()

        setupObservers()
    }

    private fun setupActivitiesByState() {
        //TODO APENAS FAZER ISTO QUANDO TIVERMOS O ESTADO DO CELULAR NO SHAREDPREFERENCES
        vm.getActivitiesByState("são paulo")

    }

    private fun setupObservers() {
        vm.activities.observe(this, Observer { activitiesList ->
            var a = activitiesList[0]
            activitiesList.add(a)
            activitiesList.add(a)
            activitiesList.add(a)
            activitiesList.add(a)

            recyclerViewCloserPlaces.apply {
                adapter = ActivitiesAdapter(activitiesList)
                setHasFixedSize(true)
                this.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            }

            recyclerViewCategories.apply {
                adapter = ActivitiesAdapter(activitiesList)
                setHasFixedSize(true)
                this.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            }
        })

    }


}



