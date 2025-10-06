package com.example.outfitsync.ui.mixmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentMixAndMatchBinding

class MixMatchFragment : Fragment() {

    private var _binding: FragmentMixAndMatchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMixAndMatchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            btnUndo.setOnClickListener {
                // Undo last action
            }

            btnNext.setOnClickListener {
                findNavController().navigate(R.id.action_mix_match_to_edit)
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