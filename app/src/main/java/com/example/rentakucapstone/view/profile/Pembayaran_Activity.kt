package com.example.rentakucapstone.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityPembayaran2Binding

class Pembayaran_Activity : AppCompatActivity() {

    private lateinit var binding: ActivityPembayaran2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembayaran2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}