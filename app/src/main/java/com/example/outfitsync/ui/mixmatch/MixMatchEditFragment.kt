package com.example.outfitsync.ui.mixmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentMixMatchEditBinding

class MixMatchEditFragment : Fragment() {

    private var _binding: FragmentMixMatchEditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMixMatchEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnUndo.setOnClickListener {
                findNavController().navigateUp()
            }

            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_mix_match_edit_to_result)
            }

            btnMagicWand.setOnClickListener {
                // Auto-generate outfit
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}