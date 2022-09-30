package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loginSystem()
    }

    private fun loginSystem() {
        val email=findViewById<EditText>(R.id.etEmail)
        val password=findViewById<EditText>(R.id.etPassword)
        val btLogin=findViewById<Button>(R.id.btLogin)
        val driver = findViewById<RadioButton>(R.id.rbDriver)
        val traveler = findViewById<RadioButton>(R.id.rbTraveler)
        val goSignUp=findViewById<TextView>(R.id.tvSingUp)
        goSignUp.text=(Html.fromHtml("¿No tienes cuenta? <u>Crea una aquí</u>"))


        btLogin.setOnClickListener {
            if(email.text!!.isNotEmpty() and password.text!!.isNotEmpty() and (driver.isChecked or traveler.isChecked)){
                if(driver.isChecked) startActivity(Intent(this, HomeDriverActivity::class.java))
                else startActivity(Intent(this, HomeTravelerActivity::class.java))
            }
            else{
                showErrorText()
            }
        }

        goSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun showErrorText() {
        Toast.makeText(this, "Faltan completar algunos campos!", Toast.LENGTH_SHORT).show()
    }
}