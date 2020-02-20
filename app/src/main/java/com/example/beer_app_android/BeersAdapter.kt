package com.example.beer_app_android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.beer_app_android.databinding.BeerViewBinding

class BeersAdapter(private val beers: List<Beer>) : RecyclerView.Adapter<BeersAdapter.BeersViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeersViewHolder {
        return BeersViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.beer_view,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return beers.size
    }

    override fun onBindViewHolder(holder: BeersViewHolder, position: Int) {
        holder.beerViewBinding.beer = beers[position]
    }

    inner class BeersViewHolder(
        val beerViewBinding: BeerViewBinding
    ) : RecyclerView.ViewHolder(beerViewBinding.root)
}
