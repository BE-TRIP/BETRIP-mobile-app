package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginSystem()
    }

    private fun loginSystem() {
        val email=findViewById<EditText>(R.id.etEmail)
        val password=findViewById<EditText>(R.id.etPassword)
        val btLogin=findViewById<Button>(R.id.btLoginTraveler)
        val btLoginDriver=findViewById<Button>(R.id.btLoginDriver)

        btLogin.setOnClickListener {
            if(email.text!!.isNotEmpty() and password.text!!.isNotEmpty()){
                startActivity(Intent(this, HomeTravellerActivity::class.java))
            }
            else{
                showErrorText()
            }
        }

        btLoginDriver.setOnClickListener {
            if(email.text!!.isNotEmpty() and password.text!!.isNotEmpty()){
                startActivity(Intent(this, HomeDriverActivity::class.java))
            }
            else{
                showErrorText()
            }
        }
    }

    private fun showErrorText() {
        Toast.makeText(this, "Faltan completar algunos campos!", Toast.LENGTH_SHORT).show()
    }
}