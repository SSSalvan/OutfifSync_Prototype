package com.example.outfitsync.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentAddToCalendarBinding

class AddToCalendarFragment : Fragment() {

    private var _binding: FragmentAddToCalendarBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddToCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnClose.setOnClickListener {
                findNavController().navigateUp()
            }

            btnSave.setOnClickListener {
                // Save outfit to calendar
                findNavController().navigate(R.id.action_add_to_calendar_done)
            }

            calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
                // Handle date selection
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}