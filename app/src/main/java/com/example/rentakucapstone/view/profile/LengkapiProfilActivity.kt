package com.example.rentakucapstone.view.profile

<<<<<<< HEAD
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityLengkapiProfilBinding
import com.example.rentakucapstone.databinding.ActivityTambahGarasiBinding

class LengkapiProfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLengkapiProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLengkapiProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onNextClick(view: View) {
        binding.nextTextView.setOnClickListener {
            startActivity(Intent(this, LengkapiProfilActivity2::class.java))
            Toast.makeText(this, "Data berhasil Disimpan", Toast.LENGTH_SHORT).show()
        }

=======
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rentakucapstone.R

class LengkapiProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lengkapi_profil)
>>>>>>> 32a93d05e359b3defa77f303ecedb5ac41d75d46
    }
}