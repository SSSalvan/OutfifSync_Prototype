package com.example.outfitsync.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentCameraUploadBinding
import com.google.android.material.snackbar.Snackbar

class CameraUploadFragment : Fragment() {

    private var _binding: FragmentCameraUploadBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCameraUploadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnTakePhoto.setOnClickListener {
                // Navigasi ke fragment pemindaian (CameraScanFragment)
                findNavController().navigate(R.id.action_upload_to_scan)
            }

            btnChooseFromLibrary.setOnClickListener {
                // Masalah 4: Tombol Choose from Library tidak berfungsi
                // Placeholder: Di dunia nyata, ini akan meluncurkan ActivityResultLauncher
                // untuk memilih gambar dari galeri.
                Snackbar.make(binding.root, "Membuka Galeri/Pustaka untuk memilih gambar...", Snackbar.LENGTH_SHORT).show()
                // TODO: Implementasi nyata menggunakan registerForActivityResult(ActivityResultContracts.PickVisualMedia())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
