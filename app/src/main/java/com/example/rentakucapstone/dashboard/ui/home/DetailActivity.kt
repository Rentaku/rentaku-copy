package com.example.rentakucapstone.dashboard.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}