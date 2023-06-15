package com.example.rentakucapstone.kendaraan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentakucapstone.R

class TambahDetailKendaraanMobilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_kendaraan_mobil)

        supportActionBar?.hide()
    }
}