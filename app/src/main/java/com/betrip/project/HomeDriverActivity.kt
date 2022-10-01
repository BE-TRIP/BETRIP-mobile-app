package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import com.betrip.project.drivers.CreateMenuDriverActivity
import com.betrip.project.drivers.CreateTripActivity
import com.betrip.project.drivers.Driver_profile

class HomeDriverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_driver)

        loadProfile()
    }

    private fun loadProfile() {
        val driverProfile = findViewById<Button>(R.id.btGoToProfile)
        val createMenu= findViewById<Button>(R.id.btGoCreate)

        driverProfile.setOnClickListener {
            startActivity(Intent(this, CreateMenuDriverActivity::class.java))
        }

        createMenu.setOnClickListener {
            startActivity(Intent(this, CreateTripActivity::class.java))
        }
    }
}