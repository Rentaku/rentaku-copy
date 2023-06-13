package com.example.rentakucapstone.view.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityLoginBinding
import com.example.rentakucapstone.view.profile.ContToProfileActivity
import com.example.rentakucapstone.view.profile.LengkapiProfilActivity2
import com.example.rentakucapstone.view.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth
    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
//            val selectedGender = binding.spinnerGender.text.toString()

            if (email.isEmpty()) {
                binding.emailEditText.error = "Email harus diisi"
                binding.emailEditText.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailEditText.error = "Email tidak valid"
                binding.emailEditText.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.passwordEditText.error = "Password harus diisi"
                binding.passwordEditText.requestFocus()
                return@setOnClickListener
            } else {
//                db.collection("users")
//                    .get()
//                    .addOnCompleteListener { task ->
//                        if (task.isSuccessful) {
//                            val sEmail = email
//                            val sPassword = password
//                            var isLogin = false
//                            for (doc in task.result) {
//                                val a = doc.getString("email")
//                                val b = doc.getString("password")
//                                if (a.equals(sEmail, ignoreCase = true) && b.equals(sPassword, ignoreCase = true)) {
//                                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
//                                    val intent = Intent(this, ContToProfileActivity::class.java)
//                                    startActivity(intent)
//                                    isLogin = true
//                                    break
//                                }
//                            }
//                            if (!isLogin) {
//                                Toast.makeText(
//                                    this,
//                                    "Cannot login, incorrect Email and Password",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            }
//                        }
//                    }
                loginFirebase(email, password)
            }


        }

        setupView()
        playAnimation()
    }

    private fun playAnimation() {
        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(500)
        val emailTextView = ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(500)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val passwordTextView = ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(500)
        val passwordEditTextLayout = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(500)
        val signin = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(500)
        val siginWithGoogle = ObjectAnimator.ofFloat(binding.loginWithGoogle, View.ALPHA, 1f).setDuration(500)


        AnimatorSet().apply {
            playSequentially(
                title,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                signin,
                siginWithGoogle
            )
            startDelay = 500
        }.start()
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

    private fun loginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val db = FirebaseFirestore.getInstance()
                    val usersRef = db.collection("users")

                    usersRef.whereEqualTo("email", user?.email)
                        .get()
                        .addOnSuccessListener { querySnapshot ->
                            if (!querySnapshot.isEmpty) {
                                val document = querySnapshot.documents[0]
                                val name = document.getString("name")
                                val phoneNumber = document.getString("phone_number")
                                val gender = document.getString("gender")

                                // Lakukan tindakan yang sesuai dengan data pengguna
                                Toast.makeText(this, "Selamat datang $name", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, ContToProfileActivity::class.java)
                                intent.putExtra("name", name)
                                startActivity(intent)
                            } else {
                                // Data pengguna tidak ditemukan di Firestore
                                Log.d(TAG, "Data pengguna tidak ditemukan di Firestore")
                            }
                        }
                        .addOnFailureListener { exception ->
                            // Error saat mengambil data pengguna dari Firestore
                            Log.e(TAG, "Error getting user data from Firestore", exception)
                        }
                } else {
                    // Gagal melakukan login
                    Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

//    fun onNextClick(view: View) {
//        binding.textBtnResgistrasi.setOnClickListener {
//            startActivity(Intent(this, RegisterActivity::class.java))
//            Toast.makeText(this, "Daftarin akun dulu yaa..", Toast.LENGTH_SHORT).show()
//        }
//    }
}