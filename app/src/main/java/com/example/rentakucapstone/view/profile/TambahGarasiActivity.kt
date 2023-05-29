package com.example.rentakucapstone.view.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityContToProfileBinding
import com.example.rentakucapstone.databinding.ActivityTambahGarasiBinding

class TambahGarasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahGarasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahGarasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onNextClick(view: View) {
        binding.nextTextView.setOnClickListener {
            startActivity(Intent(this, ListKendaraanRenterActivity::class.java))
            Toast.makeText(this, "Belum ada kendaraan yang ditambahkan", Toast.LENGTH_SHORT).show()
        }

    }
}