package com.example.outfitsync.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentFavoritesBinding
import com.example.outfitsync.ui.adapters.ClothingAdapter
import com.example.outfitsync.ui.adapters.ClothingItem

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ClothingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadFavorites()
    }

    private fun setupRecyclerView() {
        adapter = ClothingAdapter(
            items = emptyList(),
            onItemClick = { item ->
                // Handle item click - navigate to detail screen
                handleItemClick(item)
            },
            onLikeClick = { item ->
                // Handle unlike (remove from favorites)
                handleUnlike(item)
            }
        )

        binding.recyclerViewFavorites.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@FavoritesFragment.adapter
        }
    }

    private fun loadFavorites() {
        // Load favorite items from your data source
        // This would typically come from a ViewModel

        // Example dummy data:
        val favorites = listOf(
            ClothingItem(
                id = 1,
                imageUrl = "",
                category = "Top",
                color = android.graphics.Color.parseColor("#FFD1D2"),
                isLiked = true
            ),
            ClothingItem(
                id = 2,
                imageUrl = "",
                category = "Bottom",
                color = android.graphics.Color.parseColor("#D2B48C"),
                isLiked = true
            )
            // Add more items as needed
        )

        adapter.updateItems(favorites)

        // Show/hide empty state
        if (favorites.isEmpty()) {
            showEmptyState()
        } else {
            hideEmptyState()
        }
    }

    private fun handleItemClick(item: ClothingItem) {
        // Navigate to item detail screen or show detail dialog
        // You can add this navigation action to your nav graph if needed
    }

    private fun handleUnlike(item: ClothingItem) {
        // Remove item from favorites
        // Update the list
        // This would typically be handled through a ViewModel

        // Show confirmation message
        com.google.android.material.snackbar.Snackbar.make(
            binding.root,
            "Removed from favorites",
            com.google.android.material.snackbar.Snackbar.LENGTH_SHORT
        ).setAction("UNDO") {
            // Re-add to favorites
        }.show()
    }

    private fun showEmptyState() {
        // You could add an empty state view in your layout
        // and show it here when there are no favorites
    }

    private fun hideEmptyState() {
        // Hide the empty state view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}