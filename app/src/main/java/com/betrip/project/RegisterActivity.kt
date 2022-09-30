package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register()
    }

    private fun register() {
        val goLogin=findViewById<TextView>(R.id.tvGoToLogin)
        goLogin.text=(Html.fromHtml("¿Ya tienes cuenta? <u>Entra aquí</u>"))
        val email=findViewById<EditText>(R.id.etEmailRegister)
        val password=findViewById<EditText>(R.id.etPasswordRegister)
        val nombre = findViewById<EditText>(R.id.etNombre)
        val edad = findViewById<EditText>(R.id.etEdad)
        val btLogin=findViewById<Button>(R.id.btLogin)
        val driver = findViewById<RadioButton>(R.id.rbDriverRegister)
        val traveler = findViewById<RadioButton>(R.id.rbTravelerRegister)

        btLogin.setOnClickListener {
            if(email.text!!.isNotEmpty() and password.text!!.isNotEmpty() and
                nombre.text!!.isNotEmpty() and edad.text!!.isNotEmpty() and (driver.isChecked or traveler.isChecked)){
                if(driver.isChecked) startActivity(Intent(this, HomeDriverActivity::class.java))
                else startActivity(Intent(this, HomeTravelerActivity::class.java))
            }
            else{
                showErrorText()
            }
        }

        goLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun showErrorText() {
        Toast.makeText(this, "Faltan completar algunos campos!", Toast.LENGTH_SHORT).show()
    }
}