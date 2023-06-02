package com.example.rentakucapstone.view.profile

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.example.rentakucapstone.R
import com.example.rentakucapstone.dashboard.DashboardActivity
import com.example.rentakucapstone.databinding.ActivityLengkapiProfil2Binding
import com.example.rentakucapstone.view.register.RegisterActivity
import com.example.rentakucapstone.view.welcome.ForgotPasswordActivity

class LengkapiProfilActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityLengkapiProfil2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLengkapiProfil2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()

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

    private fun setupAction() {
        binding.simpan.setOnClickListener {
            startActivity(Intent(this, DataSavedActivity::class.java))
        }
    }
}