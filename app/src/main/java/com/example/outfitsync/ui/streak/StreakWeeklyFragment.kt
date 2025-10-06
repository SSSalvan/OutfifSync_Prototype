package com.example.outfitsync.ui.streak

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentStreakWeeklyBinding

class StreakWeeklyFragment : Fragment() {

    private var _binding: FragmentStreakWeeklyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStreakWeeklyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        updateStreakDisplay()
    }

    private fun setupUI() {
        binding.apply {
            btnBack.setOnClickListener {
                // RECODE: Navigate directly to the Home screen and clear the back stack
                // up to the home destination to prevent looping.
                findNavController().navigate(R.id.action_streak_to_home)
            }
        }
    }

    // ... (rest of the file remains the same)
    private fun updateStreakDisplay() {
        binding.apply {
            // Set streak count (example: 26 days)
            tvStreakCount.text = "26"

            // You can change the flame image based on streak length
            // imgFlame.setImageResource(R.drawable.streak_flame_week_1)

            // Update day indicators based on actual streak data
            // This is a placeholder - you'll update this with real data
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}