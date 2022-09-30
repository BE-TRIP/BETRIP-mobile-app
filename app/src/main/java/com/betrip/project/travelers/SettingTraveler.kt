package com.betrip.project.travelers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.betrip.project.HomeTravelerActivity
import com.betrip.project.MainActivity
import com.betrip.project.R

class SettingTraveler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_traveler)
        initCards()
    }
    fun initCards(){
        val cardItems=findViewById<CardView>(R.id.crdProfile)
        val cardTrips=findViewById<CardView>(R.id.crdTrips)
        val cardClose=findViewById<CardView>(R.id.crdCloseSession)
        val btnBack=findViewById<ImageButton>(R.id.btReturn)
        cardItems.setOnClickListener(){
            val intent = Intent(this, traveler_profile::class.java)
            startActivity(intent)
        }
        cardTrips.setOnClickListener(){
            val intent = Intent(this, HomeTravelerActivity::class.java)
            startActivity(intent)
        }
        cardClose.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnBack.setOnClickListener(){
            val intent = Intent(this, HomeTravelerActivity::class.java)
            startActivity(intent)
        }
    }
}