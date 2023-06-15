package com.example.rentakucapstone.kendaraan

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.lifecycle.ViewModelProvider
import com.example.rentakucapstone.R
import com.example.rentakucapstone.dataKendaraan.*
import com.example.rentakucapstone.databinding.ActivityTambahDetailKendaraanBinding
import com.example.rentakucapstone.pricePrediction.PredictionViewModel
import java.text.DecimalFormat

class TambahDetailKendaraanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTambahDetailKendaraanBinding
    private lateinit var viewModel: PredictionViewModel
    private lateinit var merk: AutoCompleteTextView
    private lateinit var model: AutoCompleteTextView
    private lateinit var besarCC: AutoCompleteTextView
    private lateinit var tipeTransmisi: AutoCompleteTextView
    private lateinit var tahun: AutoCompleteTextView
    private lateinit var adapter: ArrayAdapter<String>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_detail_kendaraan)

        binding = ActivityTambahDetailKendaraanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[PredictionViewModel::class.java]

        val merkOption = MerkMotor.values().map { it.value }.toTypedArray()
        merk = findViewById<AutoCompleteTextView>(R.id.merk)
        adapter = ArrayAdapter(this, R.layout.list_gender, merkOption)
        merk.setAdapter(adapter)

        val modelOption = ModelMotor.values().map { it.value }.toTypedArray()
        model = findViewById<AutoCompleteTextView>(R.id.model)
        adapter = ArrayAdapter(this, R.layout.list_gender, modelOption)
        model.setAdapter(adapter)

        val besarCCOption = BesarCcMotor.values().map { it.value }.toTypedArray()
        besarCC = findViewById<AutoCompleteTextView>(R.id.besarCc)
        adapter = ArrayAdapter(this, R.layout.list_gender, besarCCOption)
        besarCC.setAdapter(adapter)

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
            viewModel.predictionResult
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
                            Log.d(TAG, "Prediction Result: $predictionList")
                        }
                        is com.example.rentakucapstone.Result.Failure -> {
                            val error = result.exception
                            // Menampilkan pesan error
                            Log.e(TAG, "Prediction Error: $error")
                        }
                    }
                })

    }

    private fun setupAction() {
        binding.generateButton.setOnClickListener {
            val mileage = binding.mileageEditText.text.toString()
            val merkMotor = MerkMotor.values().find { it.value == merk.text.toString() }
            val modelMotor = ModelMotor.values().find { it.value == model.text.toString() }
            val besarCcMotor = BesarCcMotor.values().find { it.value == besarCC.text.toString() }
            val tipeTransmisiMotor = TipeTransmisi.values().find { it.value == tipeTransmisi.text.toString() }
            val tahunMotor = TahunMotor.values().find { it.value == tahun.text.toString() }

            if (merkMotor != null && modelMotor != null && besarCcMotor != null && tahunMotor != null) {
                val motorData = MotorData(mileage, merkMotor, modelMotor, tahunMotor, besarCcMotor)
                viewModel.predictMotorPrice(motorData)
            } else {
                // Menampilkan pesan error jika ada dropdown yang tidak dipilih
                Log.e(TAG, "Please select all dropdown options")
            }
        }
    }
}