package com.example.beer_app_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_beer.*

class BeerActivity : AppCompatActivity() {

    private lateinit var beerViewModel: BeerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beer)

        beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)

        beerViewModel.getBeer()

        beerViewModel.beerLiveData.observe(this, Observer {
            if(it != null) {
                beerName.text = it.name
                beerType.text = it.beer_type
                beerDescription.text = it.description
            }
        })
    }
}
