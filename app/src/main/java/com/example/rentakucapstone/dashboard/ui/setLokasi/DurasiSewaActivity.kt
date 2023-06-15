package com.example.rentakucapstone.dashboard.ui.setLokasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentakucapstone.databinding.ActivityDurasiSewaBinding

class DurasiSewaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDurasiSewaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDurasiSewaBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setTitle("Sewa Motor")

        supportActionBar?.hide()
    }
}