package com.example.beer_app_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var beerViewModel: BeerViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        beerViewModel.getListOfBeers()
        beerViewModel.beers.observe(this, Observer {beers ->
            recycler_view_beers.also {
                it.layoutManager = LinearLayoutManager(this)
                it.adapter = BeersAdapter(beers)
            }

        })
    }
}
