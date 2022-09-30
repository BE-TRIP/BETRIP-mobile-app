package com.betrip.project.drivers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.betrip.project.HomeDriverActivity
import com.betrip.project.R

class CreateMenuDriverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_menu_driver)

        buttonsActions()
    }

    private fun buttonsActions() {
        val btSeeTrip=findViewById<Button>(R.id.btSeeTrips)
        val btCreate=findViewById<Button>(R.id.btCreateTrip)

        btCreate.setOnClickListener {
            startActivity(Intent(this, CreateTripActivity::class.java))
        }

        btSeeTrip.setOnClickListener {
            startActivity(Intent(this, HomeDriverActivity::class.java))
        }
    }
}