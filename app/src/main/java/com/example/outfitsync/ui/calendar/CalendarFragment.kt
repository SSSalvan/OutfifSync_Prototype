package com.example.outfitsync.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.outfitsync.databinding.FragmentCalendarBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CalendarFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        updateCalendar()
    }

    private fun setupUI() {
        binding.apply {
            btnPrevMonth.setOnClickListener {
                calendar.add(Calendar.MONTH, -1)
                updateCalendar()
            }

            btnNextMonth.setOnClickListener {
                calendar.add(Calendar.MONTH, 1)
                updateCalendar()
            }

            // Setup RecyclerView for calendar days
            recyclerViewCalendar.layoutManager = GridLayoutManager(requireContext(), 7)
        }
    }

    private fun updateCalendar() {
        val dateFormat = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
        binding.tvMonthYear.text = dateFormat.format(calendar.time)

        // Load calendar days into RecyclerView
        // TODO: Implement CalendarDayAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}