package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.*
import com.betrip.project.api.RetrofitClient
import com.betrip.project.models.LoginUser
import com.betrip.project.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                else {
                    RetrofitClient.instance.userLogin(email.text.toString(), password.text.toString())
                        .enqueue(object: Callback<LoginUser> {
                            override fun onFailure(call: Call<LoginUser>, t: Throwable) {
                                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                            }

                            override fun onResponse(call: Call<LoginUser>, response: Response<LoginUser>) {
                                startActivity(Intent(applicationContext, HomeTravelerActivity::class.java))
                            }
                        })
                }
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