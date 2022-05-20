package com.example.medicheck

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.medicheck.databinding.ActivityAppListBinding

class AppListActivity : AppCompatActivity() {

    var is_arrow_clicked = false
    private lateinit var binding: ActivityAppListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_app_list)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val settings_button = findViewById<Button>(R.id.settings_btn)
        val log_out_button = findViewById<Button>(R.id.log_out_btn)
        settings_button.setVisibility(View.GONE)
        log_out_button.setVisibility(View.GONE)
    }

    fun log_out_button(view: View) {
        val button = findViewById<Button>(R.id.log_out_btn)
        button.setOnClickListener {
            val intent = Intent(this, log_in_activity::class.java)
            startActivity(intent)
        }
    }

    fun arrow_btn_clicked(view: View) {
        val button = findViewById<Button>(R.id.arrow_btn)
        val settings_button = findViewById<Button>(R.id.settings_btn)
        val log_out_button = findViewById<Button>(R.id.log_out_btn)
        button.setOnClickListener {
            if(!is_arrow_clicked) {
                settings_button.setVisibility(View.VISIBLE)
                log_out_button.setVisibility(View.VISIBLE)
            }
            else{
                settings_button.setVisibility(View.GONE)
                log_out_button.setVisibility(View.GONE)
            }
            is_arrow_clicked=!is_arrow_clicked
        }
    }
}