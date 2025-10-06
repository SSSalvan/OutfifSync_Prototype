package com.example.dashboard_outfitsync

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WardrobeAdapter(private val items: List<ClothingAdapter>) :
    RecyclerView.Adapter<WardrobeAdapter.ViewHolder>() {

    // This class holds the views for a single item (from item_clothing.xml).
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val clothingImage: ImageView = view.findViewById(R.id.clothingImage)
        val clothingCategory: TextView = view.findViewById(R.id.clothingCategory)
    }

    // Creates a new ViewHolder by inflating the item_clothing.xml layout.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_clothing, parent, false)
        return ViewHolder(view)
    }

    // Binds the data from our list to the views in the ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.clothingImage.setImageResource(item.imageResId)
        holder.clothingCategory.text = item.category
    }

    // Returns the total number of items in our list.
    override fun getItemCount(): Int {
        return items.size
    }
}