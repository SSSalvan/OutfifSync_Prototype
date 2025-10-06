package com.example.outfitsync.ui.wardrobe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentWardrobeBinding

class WardrobeFragment : Fragment() {

    private var _binding: FragmentWardrobeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWardrobeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            // Likes/Favorites button
            btnLikes.setOnClickListener {
                findNavController().navigate(R.id.action_wardrobe_to_favorites)
            }

            // Chip filters
            chipGroup.setOnCheckedStateChangeListener { _, checkedIds ->
                when {
                    checkedIds.contains(R.id.chipTop) -> filterByCategory("top")
                    checkedIds.contains(R.id.chipBottom) -> filterByCategory("bottom")
                    checkedIds.contains(R.id.chipFootwear) -> filterByCategory("footwear")
                    checkedIds.contains(R.id.chipBags) -> filterByCategory("bags")
                    checkedIds.contains(R.id.chipAccessories) -> filterByCategory("accessories")
                }
            }
        }
    }

    private fun filterByCategory(category: String) {
        // Filter RecyclerView by category
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}