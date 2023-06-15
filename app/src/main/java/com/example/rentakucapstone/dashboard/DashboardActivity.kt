package com.example.rentakucapstone.dashboard

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.rentakucapstone.R
import com.example.rentakucapstone.dashboard.ui.account.AccountFragment
import com.example.rentakucapstone.databinding.ActivityDashboardBinding

@Suppress("DEPRECATION")
class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.show()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_dashboard)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_favourite, R.id.navigation_pesanan, R.id.navigation_account
        ).build()
//          setupActionBarWithNavController(navController, appBarConfiguration)
         navView.setupWithNavController(navController)

        name = intent.getStringExtra("name") ?: ""

        navView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.navigation_home)
                    navController.popBackStack(R.id.navigation_account, false)

                }
                R.id.navigation_favourite -> {
                    navController.navigate(R.id.navigation_favourite)
                    true
                }
                R.id.navigation_pesanan -> {
                    navController.navigate(R.id.navigation_pesanan)
                    true
                }
                R.id.navigation_account -> {
                    val bundle = Bundle()
                    bundle.putString("name", name)
                    navController.popBackStack(R.id.navigation_account, false)
                    navController.navigate(R.id.navigation_account, bundle)
                    true
                }
                else -> false
            }
        }
    }
}