package com.example.outfitsync.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.outfitsync.R
import com.example.outfitsync.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            tvSignup.setOnClickListener {
                findNavController().navigate(R.id.action_login_to_signup)
            }

            btnLogin.setOnClickListener {
                // Validate and login
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()

                if (validateInput(email, password)) {
                    // Logika autentikasi berhasil

                    // TODO: Ganti placeholder ini dengan logika backend/database nyata
                    val isFirstLogin = false
                    val hasNewStreak = true

                    if (isFirstLogin || hasNewStreak) {
                        // Navigasi ke Streak untuk login pertama atau streak baru
                        findNavController().navigate(R.id.action_login_to_streak)
                    } else {
                        // Navigasi ke Home untuk login biasa
                        findNavController().navigate(R.id.action_login_to_home)
                    }
                }
            }

            btnGoogleSignIn.setOnClickListener {
                // Handle Google Sign In
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            binding.tilEmail.error = "Email is required"
            return false
        }
        if (password.isEmpty()) {
            binding.tilPassword.error = "Password is required"
            return false
        }
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
