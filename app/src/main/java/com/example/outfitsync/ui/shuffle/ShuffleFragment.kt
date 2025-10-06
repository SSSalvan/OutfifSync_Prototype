package com.example.outfitsync.ui.shuffle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
// FIX: Import binding yang benar
import com.example.outfitsync.databinding.FragmentShuffleBinding
import com.google.android.material.snackbar.Snackbar

class ShuffleFragment : Fragment() {

    // FIX: Menggunakan FragmentShuffleBinding
    private var _binding: FragmentShuffleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // FIX: Menggunakan FragmentShuffleBinding.inflate
        _binding = FragmentShuffleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            // Logika klik tombol Shuffle Sekarang
            btnShuffleNow.setOnClickListener {
                // TODO: Implementasi logika pengacakan pakaian di sini

                Snackbar.make(
                    binding.root,
                    "Mengocok pakaian... Menavigasi ke hasil!",
                    Snackbar.LENGTH_SHORT
                ).show()

                // Navigasi ke halaman hasil outfit (OutfitResultFragment)
                // Pastikan action_shuffle_to_result sudah didefinisikan di mobile_navigation.xml
                findNavController().navigate(R.id.action_shuffle_to_result)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
