package com.example.rentakucapstone.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityKonfirmasiPesananBinding

class KonfirmasiPesananActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKonfirmasiPesananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKonfirmasiPesananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}