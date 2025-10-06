package com.example.outfitsync.ui.scan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentScanOutfitBinding
import com.google.android.material.snackbar.Snackbar

class ScanOutfitFragment : Fragment() {

    private var _binding: FragmentScanOutfitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScanOutfitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            // Tombol kembali
            btnBack.setOnClickListener {
                findNavController().navigateUp()
            }

            // Menggunakan ID View Binding yang benar: btnSaveItemDone
            // Catatan: Nama properti View Binding di Kotlin adalah camelCase dari ID XML
            btnSaveItemDone.setOnClickListener {
                // Navigasi ke wardrobe setelah scan selesai (sesuai mobile_navigation.xml)
                findNavController().navigate(R.id.action_scan_outfit_to_wardrobe)
                Snackbar.make(binding.root, "Item berhasil ditambahkan ke lemari!", Snackbar.LENGTH_SHORT).show()
            }

            // Dropdown sekarang memiliki placeholder fungsional
            setupDropdowns()
        }
    }

    private fun setupDropdowns() {
        // Dropdown Outfit Type
        val outfitTypes = listOf("Top", "Bottom", "Footwear", "Accessory")
        setupSpinner(binding.btnOutfitType, outfitTypes, "Tipe Pakaian")

        // Dropdown Color
        val colors = listOf("Black", "White", "Pink", "Blue")
        setupSpinner(binding.btnColor, colors, "Warna")

        // Dropdown Save To
        val saveToCategories = listOf("Casual", "Formal", "Sporty")
        setupSpinner(binding.btnSaveTo, saveToCategories, "Simpan Ke Kategori")
    }

    // Fungsi bantuan sederhana untuk mensimulasikan interaksi dropdown
    private fun setupSpinner(button: View, items: List<String>, title: String) {
        button.setOnClickListener {
            Snackbar.make(
                binding.root,
                "$title: Opsi yang tersedia: ${items.joinToString(", ")}",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
