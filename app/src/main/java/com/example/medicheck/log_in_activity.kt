package com.example.medicheck

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.content.Intent

class log_in_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
    }
    fun sign_in_button_clicked(view: View) {
        val button = findViewById<Button>(R.id.sign_in_btn)
        button.setOnClickListener {
            val intent = Intent(this, AppListActivity::class.java)
            startActivity(intent)
        }
    }

    fun sign_up_button_clicked(view: View) {
        val button = findViewById<Button>(R.id.sign_up_btn)
        button.setOnClickListener {
            val intent = Intent(this, sign_up_activity::class.java)
            startActivity(intent)
        }
    }
}