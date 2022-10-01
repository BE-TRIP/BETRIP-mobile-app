package com.betrip.project.drivers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.betrip.project.HomeDriverActivity
import com.betrip.project.R

class CreateTripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_trip)

        buttonsActions()
    }

    private fun buttonsActions() {
        val btCreateTrip=findViewById<Button>(R.id.btCreateTrips)

        btCreateTrip.setOnClickListener {
            startActivity(Intent(this, HomeDriverActivity::class.java))
        }
    }
}