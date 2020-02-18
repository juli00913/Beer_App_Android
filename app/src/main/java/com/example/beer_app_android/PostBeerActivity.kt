package com.example.beer_app_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.beer_app_android.databinding.ActivityPostBeerBinding

class PostBeerActivity : AppCompatActivity() {

    private lateinit var beerViewModel: BeerViewModel
    private lateinit var binding : ActivityPostBeerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_beer)
        beerViewModel = ViewModelProvider(this).get(BeerViewModel::class.java)
        binding.viewModel = beerViewModel
        binding.beer = Beer()
    }
}
