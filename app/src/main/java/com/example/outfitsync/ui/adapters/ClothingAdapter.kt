package com.example.outfitsync.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.outfitsync.databinding.ItemClothingBinding

data class ClothingItem(
    val id: Int,
    val imageUrl: String,
    val category: String,
    val color: Int,
    val isLiked: Boolean = false
)

class ClothingAdapter(
    private var items: List<ClothingItem>,
    private val onItemClick: (ClothingItem) -> Unit,
    private val onLikeClick: (ClothingItem) -> Unit
) : RecyclerView.Adapter<ClothingAdapter.ClothingViewHolder>() {

    inner class ClothingViewHolder(private val binding: ItemClothingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ClothingItem) {
            binding.apply {
                clothingCategory.text = item.category
                colorDot.setBackgroundColor(item.color)

                // Load image (use Glide, Coil, or Picasso)
                // Glide.with(clothingImage).load(item.imageUrl).into(clothingImage)

                // Set like button state
                btnItemLike.alpha = if (item.isLiked) 1f else 0.5f

                root.setOnClickListener { onItemClick(item) }
                btnItemLike.setOnClickListener { onLikeClick(item) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothingViewHolder {
        val binding = ItemClothingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ClothingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClothingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<ClothingItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}