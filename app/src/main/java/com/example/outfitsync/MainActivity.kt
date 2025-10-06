package com.example.outfitsync

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.outfitsync.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        setupBottomNavigation()
    }

    private fun setupNavigation() {
        // Mendapatkan NavController dari NavHostFragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Listener untuk menyembunyikan/menampilkan Bottom Nav dan memperbarui sorotan tombol
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Tentukan fragment mana yang menampilkan Bottom Nav
            when (destination.id) {
                R.id.navigation_home,
                R.id.navigation_wardrobe,
                R.id.navigation_shuffle,
                R.id.navigation_profile,
                R.id.navigation_calendar -> {
                    showBottomNav()
                }
                else -> {
                    hideBottomNav()
                }
            }
            // Memperbarui tampilan tombol yang disorot (termasuk saat navigasi kembali/Up)
            updateSelectedNavButton(destination.id)
        }
    }

    private fun setupBottomNavigation() {
        binding.apply {
            // Calendar navigation
            btnNavCalendar.setOnClickListener {
                navigateToDestination(R.id.navigation_calendar)
            }

            // Wardrobe navigation
            btnNavHanger.setOnClickListener {
                navigateToDestination(R.id.navigation_wardrobe)
            }

            // Add button (Camera)
            // Ini biasanya menavigasi ke fragment yang tidak memiliki Bottom Nav
            btnAdd.setOnClickListener {
                navigateToDestination(R.id.navigation_camera_upload)
            }

            // Shuffle navigation (FIXED: mengarahkan ke destinasi Shuffle yang benar)
            btnNavShuffle.setOnClickListener {
                navigateToDestination(R.id.navigation_shuffle)
            }

            // Profile navigation
            btnUser.setOnClickListener {
                navigateToDestination(R.id.navigation_profile)
            }
        }
    }

    /**
     * Memastikan hanya tombol yang saat ini aktif yang disorot (alpha = 1f).
     */
    private fun updateSelectedNavButton(destinationId: Int) {
        binding.apply {
            // Reset semua tombol ke alpha 0.5 (tidak disorot)
            btnNavCalendar.alpha = 0.5f
            btnNavHanger.alpha = 0.5f
            btnNavShuffle.alpha = 0.5f
            btnUser.alpha = 0.5f

            // Sorot tombol yang sesuai dengan destinasi saat ini (alpha = 1f)
            val selectedButton = when (destinationId) {
                R.id.navigation_calendar -> btnNavCalendar
                R.id.navigation_wardrobe -> btnNavHanger
                R.id.navigation_shuffle -> btnNavShuffle
                R.id.navigation_profile -> btnUser
                R.id.navigation_home -> btnNavCalendar // Asumsi Home dan Calendar berbagi tombol yang sama (atau Home adalah default)
                else -> null
            }
            selectedButton?.alpha = 1f
        }
    }

    private fun navigateToDestination(destinationId: Int) {
        try {
            // Hanya navigasi jika destinasi saat ini berbeda (untuk menghindari pemuatan ulang fragment yang sama)
            if (navController.currentDestination?.id != destinationId) {
                // Untuk tombol Bottom Nav, gunakan popUpTo agar stack bersih
                navController.navigate(destinationId)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun showBottomNav() {
        binding.bottomNavContainer.visibility = View.VISIBLE
        binding.navBorder.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bottomNavContainer.visibility = View.GONE
        binding.navBorder.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
