package com.betrip.project.travelers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.betrip.project.HomeTravellerActivity
import com.betrip.project.R

class CreateEvent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)
        initButtons()
    }

    fun initButtons(){
        val btSave=findViewById<Button>(R.id.btSave).setOnClickListener(){
            val intent = Intent(this, HomeTravellerActivity::class.java)
            startActivity(intent)
        }
    }
}