package com.example.outfitsync.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentEmailVerifiedBinding

class EmailVerifiedFragment : Fragment() {

    private var _binding: FragmentEmailVerifiedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailVerifiedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnDone.setOnClickListener {
                // RECODE: Navigasi ke Streak untuk pengguna baru (sesuai permintaan)
                findNavController().navigate(R.id.action_verified_to_streak)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
