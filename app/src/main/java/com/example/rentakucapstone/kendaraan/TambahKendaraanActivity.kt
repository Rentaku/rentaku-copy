package com.example.rentakucapstone.kendaraan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityRegisterBinding
import com.example.rentakucapstone.databinding.ActivityTambahKendaraanBinding

class TambahKendaraanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahKendaraanBinding
    private lateinit var jenisKendaraan: AutoCompleteTextView
    private lateinit var adapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTambahKendaraanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Tambah Kendaraan")

        val kendaraanOption = arrayOf("Motor", "Mobil")
        jenisKendaraan = findViewById<AutoCompleteTextView>(R.id.jenisKendaraan)
        adapter = ArrayAdapter(this, R.layout.list_gender, kendaraanOption)
        jenisKendaraan.setAdapter(adapter)

        binding.nextTextView.setOnClickListener {
            val selectedOption = jenisKendaraan.text.toString()

            if (selectedOption == "Motor") {
                val intent = Intent(this, TambahDetailKendaraanActivity::class.java)
                startActivity(intent)
            } else if (selectedOption == "Mobil") {
                val intent = Intent(this, TambahDetailKendaraanMobilActivity::class.java)
                startActivity(intent)
            }
        }
    }
}