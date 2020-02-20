package com.example.beer_app_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.beer_app_android.databinding.BeerViewBinding

class BeerActivity : AppCompatActivity() {

    private lateinit var beerViewModel: BeerViewModel
    private lateinit var binding : BeerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_view)
       binding = DataBindingUtil.setContentView(this, R.layout.beer_view)

        beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)

        beerViewModel.getBeer()

        beerViewModel.beerLiveData.observe(this, Observer {
            if(it != null) {
                binding.beer = it
            }
        })
    }
}
