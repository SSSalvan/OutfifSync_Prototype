package com.example.outfitsync.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.outfitsync.databinding.ItemOutfitResultCardBinding

data class OutfitResultItem(
    val id: Int,
    val name: String,
    val color: Int
)

class OutfitResultAdapter(
    private var items: List<OutfitResultItem>
) : RecyclerView.Adapter<OutfitResultAdapter.OutfitResultViewHolder>() {

    inner class OutfitResultViewHolder(private val binding: ItemOutfitResultCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OutfitResultItem) {
            binding.apply {
                tvItemName.text = item.name
                colorDot.setBackgroundColor(item.color)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OutfitResultViewHolder {
        val binding = ItemOutfitResultCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OutfitResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OutfitResultViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<OutfitResultItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}