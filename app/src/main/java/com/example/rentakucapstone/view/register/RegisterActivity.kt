package com.example.rentakucapstone.view.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityRegisterBinding
import com.example.rentakucapstone.view.profile.ContToProfileActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var gender: AutoCompleteTextView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val genderOption = arrayOf("Laki-laki", "Perempuan")
        gender = findViewById(R.id.spinner_gender)
        adapter = ArrayAdapter(this, R.layout.list_gender, genderOption)
        gender.setAdapter(adapter)

        binding.signupButton.setOnClickListener {
            val intent = Intent(this, ContToProfileActivity::class.java)
            Toast.makeText(this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        setupView()
        playAnimation()
    }
    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun playAnimation() {

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(500)
        val nameTextView = ObjectAnimator.ofFloat(binding.nameTextView, View.ALPHA, 1f).setDuration(500)
        val nameEditTextLayout = ObjectAnimator.ofFloat(binding.nameEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val genderTextView = ObjectAnimator.ofFloat(binding.genderTextView, View.ALPHA, 1f).setDuration(500)
        val genderEditTextLayout = ObjectAnimator.ofFloat(binding.spinnerEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val numberTextView = ObjectAnimator.ofFloat(binding.numberTextView, View.ALPHA, 1f).setDuration(500)
        val numberEditTextLayout = ObjectAnimator.ofFloat(binding.numberEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val emailTextView = ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(500)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val passwordTextView = ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(500)
        val passwordEditTextLayout = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(500)


        AnimatorSet().apply {
            playSequentially(
                title,
                nameTextView,
                nameEditTextLayout,
                genderTextView,
                genderEditTextLayout,
                numberTextView,
                numberEditTextLayout,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                signup
            )
            startDelay = 500
        }.start()
    }
}