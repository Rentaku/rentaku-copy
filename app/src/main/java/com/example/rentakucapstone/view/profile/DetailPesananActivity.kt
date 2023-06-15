package com.example.rentakucapstone.view.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityDetailPesananBinding

class DetailPesananActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailPesananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPesananBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}