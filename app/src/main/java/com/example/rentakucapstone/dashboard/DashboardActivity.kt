package com.example.rentakucapstone.dashboard

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rentakucapstone.R
import com.example.rentakucapstone.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

<<<<<<< HEAD
        val navController = findNavController(R.id.nav_host_fragment_activity_dashboard)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_favourite, R.id.navigation_pesanan, R.id.navigation_account
            )
        )
        // setupActionBarWithNavController(navController, appBarConfiguration)
        // navView.setupWithNavController(navController)
=======
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_dashboard)
       // val navController = navHostFragment.navController
        val navController = findNavController(R.id.nav_host_fragment_activity_dashboard)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_favourite, R.id.navigation_pesanan, R.id.navigation_account
        ).build()
         // setupActionBarWithNavController(navController, appBarConfiguration)
         navView.setupWithNavController(navController)
>>>>>>> 32a93d05e359b3defa77f303ecedb5ac41d75d46
    }
}