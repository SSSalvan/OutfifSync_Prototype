package com.example.dashboard_outfitsync

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Hubungkan ke layout utama yang berisi FragmentContainerView
        setContentView(R.layout.activity_main)

        // 2. Dapatkan NavController dari NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // 3. Temukan semua tombol navigasi dari layout
        val btnNavCalendar: ImageButton = findViewById(R.id.btnNavCalendar)
        val btnNavHanger: ImageButton = findViewById(R.id.btnNavHanger)
        val btnAdd: ImageButton = findViewById(R.id.btnAdd)
        val btnNavShuffle: ImageButton = findViewById(R.id.btnNavShuffle)
        val btnUser: ImageButton = findViewById(R.id.btnUser)

        // 4. Atur OnClickListener untuk setiap tombol untuk menavigasi ke fragment yang sesuai
        btnNavCalendar.setOnClickListener {
            // Arahkan ke fragment calendar (ID dari navigation graph)
            navController.navigate(R.id.calendarFragment)
        }

        btnNavHanger.setOnClickListener {
            // Arahkan ke fragment wardrobe (ID dari navigation graph)
            navController.navigate(R.id.wardrobeFragment)
        }

        btnAdd.setOnClickListener {
            // Arahkan ke fragment camera upload (ID dari navigation graph)
            navController.navigate(R.id.cameraUploadFragment)
        }

        btnNavShuffle.setOnClickListener {
            // Arahkan ke fragment mix and match (ID dari navigation graph)
            navController.navigate(R.id.mixAndMatchFragment)
        }

        btnUser.setOnClickListener {
            // Arahkan ke fragment profile (ID dari navigation graph)
            navController.navigate(R.id.profileFragment)
        }
    }
}