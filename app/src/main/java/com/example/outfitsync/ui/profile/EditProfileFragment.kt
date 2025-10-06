package com.example.outfitsync.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.databinding.FragmentEditProfileBinding
import com.google.android.material.snackbar.Snackbar

class EditProfileFragment : Fragment() {

    private var _binding: FragmentEditProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        loadProfileData()
    }

    private fun setupUI() {
        binding.apply {
            btnCancel.setOnClickListener {
                findNavController().navigateUp()
            }

            btnSave.setOnClickListener {
                saveProfileChanges()
            }

            profileImage.setOnClickListener {
                // Open image picker to change profile picture
                // You can implement this with ActivityResultLauncher
                showImagePickerOptions()
            }
        }
    }

    private fun loadProfileData() {
        // Load existing profile data
        // This would come from your ViewModel or SharedPreferences
        // For now, the TextInputEditTexts have placeholder data in the layout
    }

    private fun saveProfileChanges() {
        binding.apply {
            // Get values from input fields
            // Validate the data
            // Save to backend/local storage

            // Show success message
            Snackbar.make(
                binding.root,
                "Profile updated successfully",
                Snackbar.LENGTH_SHORT
            ).show()

            // Navigate back after a short delay
            binding.root.postDelayed({
                findNavController().navigateUp()
            }, 1000)
        }
    }

    private fun showImagePickerOptions() {
        // TODO: Implement image picker
        // You can use ActivityResultContracts.PickVisualMedia() or
        // ActivityResultContracts.TakePicture()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}