package com.betrip.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.*
import com.betrip.project.api.Api
import com.betrip.project.models.LoginTraveler
import com.betrip.project.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://betrip2022.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create<Api>(Api::class.java)

        btLogin.setOnClickListener {
            if(email.text!!.isNotEmpty() and password.text!!.isNotEmpty() and (driver.isChecked or traveler.isChecked)){
                if(driver.isChecked) startActivity(Intent(this, HomeDriverActivity::class.java))
                else {
                    val user: User = User(email.text.toString(),password.text.toString())
                    service.userLogin(user).enqueue(object : Callback<LoginTraveler>{
                        override fun onFailure(call: Call<LoginTraveler>, t: Throwable) {
                            Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<LoginTraveler>, response: Response<LoginTraveler>) {
                            if(response.isSuccessful){
                                startActivity(Intent(this@MainActivity, HomeTravelerActivity::class.java))
                            }
                            else Toast.makeText(this@MainActivity, "Error en el usuario o contraseña!", Toast.LENGTH_SHORT).show()
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