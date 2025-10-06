package com.example.outfitsync.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentOutfitResultBinding

class OutfitResultFragment : Fragment() {

    private var _binding: FragmentOutfitResultBinding? = null
    private val binding get() = _binding!!
    private var isLiked = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOutfitResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        displayOutfitResults()
    }

    private fun setupUI() {
        binding.apply {
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }

            btnSaveToCalendar.setOnClickListener {
                // Navigate to add to calendar screen
                findNavController().navigate(R.id.action_result_to_add_calendar)
            }

            btnLike.setOnClickListener {
                isLiked = !isLiked
                updateLikeButton()
            }
        }
    }

    private fun displayOutfitResults() {
        // This is where you would display the outfit items
        // For now, the layout includes placeholder items
        // You can populate these with actual data from your ViewModel
    }

    private fun updateLikeButton() {
        binding.apply {
            if (isLiked) {
                btnLike.setImageResource(R.drawable.ic_heart_filled)
                btnLike.imageTintList = android.content.res.ColorStateList.valueOf(
                    requireContext().getColor(R.color.colorPrimary)
                )
            } else {
                btnLike.setImageResource(R.drawable.ic_heart_outline)
                btnLike.imageTintList = android.content.res.ColorStateList.valueOf(
                    requireContext().getColor(R.color.colorPrimary)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}