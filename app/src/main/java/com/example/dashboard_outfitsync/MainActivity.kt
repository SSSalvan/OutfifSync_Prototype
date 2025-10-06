package com.example.dashboard_outfitsync

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container_view)

        // Hubungkan semua tombol dari layout
        val btnNavCalendar: ImageButton = findViewById(R.id.btnNavCalendar)
        val btnNavHanger: ImageButton = findViewById(R.id.btnNavHanger)
        val btnAdd: ImageButton = findViewById(R.id.btnAdd)
        val btnNavShuffle: ImageButton = findViewById(R.id.btnNavShuffle)
        val btnUser: ImageButton = findViewById(R.id.btnUser)

        // Atur listener untuk setiap tombol
        btnNavCalendar.setOnClickListener {
            Toast.makeText(this, "Calendar clicked", Toast.LENGTH_SHORT).show()
        }

        btnNavHanger.setOnClickListener {
            Toast.makeText(this, "Hanger clicked", Toast.LENGTH_SHORT).show()
        }

        btnAdd.setOnClickListener {
            Toast.makeText(this, "Add new item", Toast.LENGTH_SHORT).show()
        }

        btnNavShuffle.setOnClickListener {
            Toast.makeText(this, "Shuffle clicked", Toast.LENGTH_SHORT).show()
        }

        btnUser.setOnClickListener {
            Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
        }
    }
}