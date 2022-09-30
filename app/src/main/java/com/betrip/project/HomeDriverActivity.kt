package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import com.betrip.project.drivers.Driver_profile

class HomeDriverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_driver)

        loadProfile()
    }

    private fun loadProfile() {
        val driverProfile = findViewById<Button>(R.id.btGoToProfile)

        driverProfile.setOnClickListener {
            startActivity(Intent(this, Driver_profile::class.java))
        }
    }
}