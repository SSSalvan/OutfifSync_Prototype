package com.example.outfitsync

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
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
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // Hide bottom nav on certain destinations
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.navigation_home,
                R.id.navigation_wardrobe,
                R.id.navigation_shuffle,
                R.id.navigation_profile -> {
                    showBottomNav()
                }
                else -> {
                    hideBottomNav()
                }
            }
        }
    }

    private fun setupBottomNavigation() {
        binding.apply {
            // Calendar navigation
            btnNavCalendar.setOnClickListener {
                navigateToDestination(R.id.navigation_home)
                updateNavButtonStates(it)
            }

            // Wardrobe navigation
            btnNavHanger.setOnClickListener {
                navigateToDestination(R.id.navigation_wardrobe)
                updateNavButtonStates(it)
            }

            // Add button (Camera)
            btnAdd.setOnClickListener {
                navigateToDestination(R.id.navigation_camera_upload)
            }

            // Shuffle navigation
            btnNavShuffle.setOnClickListener {
                navigateToDestination(R.id.navigation_shuffle)
                updateNavButtonStates(it)
            }

            // Profile navigation
            btnUser.setOnClickListener {
                navigateToDestination(R.id.navigation_profile)
                updateNavButtonStates(it)
            }
        }
    }

    private fun navigateToDestination(destinationId: Int) {
        try {
            if (navController.currentDestination?.id != destinationId) {
                navController.navigate(destinationId)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun updateNavButtonStates(selectedView: View) {
        binding.apply {
            // Reset all button states
            btnNavCalendar.alpha = 0.5f
            btnNavHanger.alpha = 0.5f
            btnNavShuffle.alpha = 0.5f
            btnUser.alpha = 0.5f

            // Highlight selected button
            selectedView.alpha = 1f
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