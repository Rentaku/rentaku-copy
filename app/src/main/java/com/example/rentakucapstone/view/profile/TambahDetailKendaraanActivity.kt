package com.example.rentakucapstone.kendaraan

import android.annotation.SuppressLint
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.ViewModelProvider
import com.example.rentakucapstone.R
import com.example.rentakucapstone.dataKendaraan.*
import com.example.rentakucapstone.databinding.ActivityTambahKendaraanMobilBinding
import com.example.rentakucapstone.pricePrediction.PredictionViewModel
import java.text.DecimalFormat

class TambahDetailKendaraanMobilActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahKendaraanMobilBinding
    private lateinit var viewModel: PredictionViewModel
    private lateinit var merk: AutoCompleteTextView
    private lateinit var model: AutoCompleteTextView
    private lateinit var kategori: AutoCompleteTextView
    private lateinit var tipeTransmisi: AutoCompleteTextView
    private lateinit var tahun: AutoCompleteTextView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_kendaraan_mobil)

        binding = ActivityTambahKendaraanMobilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[PredictionViewModel::class.java]

        val merkOption = MerkMobil.values().map { it.value }.toTypedArray()
        merk = findViewById<AutoCompleteTextView>(R.id.merk)
        adapter = ArrayAdapter(this, R.layout.list_gender, merkOption)
        merk.setAdapter(adapter)

        val modelOption = ModelMobil.values().map { it.value }.toTypedArray()
        model = findViewById<AutoCompleteTextView>(R.id.model)
        adapter = ArrayAdapter(this, R.layout.list_gender, modelOption)
        model.setAdapter(adapter)

        val kategoriOption = KategoriMobil.values().map { it.value }.toTypedArray()
        kategori = findViewById<AutoCompleteTextView>(R.id.kategori)
        adapter = ArrayAdapter(this, R.layout.list_gender, kategoriOption)
        kategori.setAdapter(adapter)

        val tipeTransmisiOption = TipeTransmisi.values().map { it.value }.toTypedArray()
        tipeTransmisi = findViewById<AutoCompleteTextView>(R.id.tipeTransmisi)
        adapter = ArrayAdapter(this, R.layout.list_gender, tipeTransmisiOption)
        tipeTransmisi.setAdapter(adapter)

        val tahunOption = TahunMotor.values().map { it.value }.toTypedArray()
        tahun = findViewById<AutoCompleteTextView>(R.id.tahun)
        adapter = ArrayAdapter(this, R.layout.list_gender, tahunOption)
        tahun.setAdapter(adapter)

        setupAction()
        generatePrediction()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun generatePrediction() {
        val harga = binding.hargaEditText
        viewModel.carPredictionResult
            .observe(this, { result ->
                when (result) {
                    is com.example.rentakucapstone.Result.Success<*> -> {
                        val predictionList = result.data
                        // Menampilkan hasil prediksi
                        val formattedPrediction = if (predictionList?.isNotEmpty() == true){
                            val firstPrediction = predictionList?.get(0)?.firstOrNull()
                            if (firstPrediction != null) {
                                val decimalFormat = DecimalFormat("#,###.###")
                                decimalFormat.format(firstPrediction)
                            } else {
                                ""
                            }
                        } else {
                            ""
                        }
                        harga.setText(formattedPrediction)
                        Log.d(ContentValues.TAG, "Prediction Result: $predictionList")
                    }
                    is com.example.rentakucapstone.Result.Failure -> {
                        val error = result.exception
                        // Menampilkan pesan error
                        Log.e(ContentValues.TAG, "Prediction Error: $error")
                    }
                }
            })

    }

    private fun setupAction() {
        binding.generateButton.setOnClickListener {
            val mileage = binding.mileageEditText.text.toString()
            val merkMobil = MerkMobil.values().find { it.value == merk.text.toString() }
            val modelMobil = ModelMobil.values().find { it.value == model.text.toString() }
            val kategoriMobil = KategoriMobil.values().find { it.value == kategori.text.toString() }
            val tipeTransmisi = TipeTransmisi.values().find { it.value == tipeTransmisi.text.toString() }
            val tahunMobil = TahunMotor.values().find { it.value == tahun.text.toString() }

            if (merkMobil != null && modelMobil != null && kategoriMobil != null && tahunMobil != null) {
                val mobilData = MobilData(mileage, merkMobil, modelMobil, kategoriMobil, tahunMobil, tipeTransmisi)
                viewModel.predictMobilPrice(mobilData)
            } else {
                // Menampilkan pesan error jika ada dropdown yang tidak dipilih
                Log.e(ContentValues.TAG, "Please select all dropdown options")
            }
        }
    }
}