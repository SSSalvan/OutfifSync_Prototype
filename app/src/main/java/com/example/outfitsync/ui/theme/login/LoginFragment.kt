package com.example.outfitsync.ui.theme.login

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dashboard_outfitsync.MainActivity
import com.example.dashboard_outfitsync.R
import com.example.outfitsync.ui.theme.login.SignupActivity
import com.google.android.material.button.MaterialButton

class LoginFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        val btnLogin: MaterialButton = findViewById(R.id.btnLogin)
        val tvSignup: TextView = findViewById(R.id.tvSignup)

        btnLogin.setOnClickListener {
            // Setelah login berhasil, buka MainActivity (Dashboard)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menutup halaman login agar tidak bisa kembali
        }

        tvSignup.setOnClickListener {
            // Membuka halaman SignupActivity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}