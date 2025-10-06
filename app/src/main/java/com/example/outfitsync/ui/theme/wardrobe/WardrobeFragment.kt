package com.example.dashboard_outfitsync

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WardrobeFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_wardrobe)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewWardrobe)

        // Set RecyclerView to display 2 columns in a grid.
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // 1. Create some sample data for our clothing list.
        val clothingList = mutableListOf<ClothingAdapter>()
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Casual"))
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Formal"))
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Casual"))
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Casual"))
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Formal"))
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Sporty"))
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Casual"))
        clothingList.add(ClothingAdapter(R.mipmap.ic_launcher, "Formal"))

        // 2. Create an instance of our adapter.
        val adapter = WardrobeAdapter(clothingList)

        // 3. Set the adapter on the RecyclerView.
        recyclerView.adapter = adapter
    }
}