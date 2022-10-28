package com.betrip.project.drivers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.betrip.project.HomeDriverActivity
import com.betrip.project.R
import com.betrip.project.drivers.models.Route
import com.betrip.project.drivers.network.RouteService
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CreateTripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_trip)

        createRoute()
    }

    fun createRoute(){

        val btCreateTrips = findViewById<Button>(R.id.btCreateTrips)
        btCreateTrips.setOnClickListener{
            val destiny = findViewById<TextInputEditText>(R.id.etTripDestiny)
            val seats = findViewById<TextInputEditText>(R.id.etTripSeats)
            val time = findViewById<TextInputEditText>(R.id.etTripDepartTime)
            val date = findViewById<TextInputEditText>(R.id.etTripDepartDate)
            val cost = findViewById<TextInputEditText>(R.id.etTripCost)
            val departPoint = findViewById<TextInputEditText>(R.id.etTripDepartPlace)

            val route: Route = Route(1, destiny.text.toString(), Integer.parseInt(seats.text.toString()) , departPoint.text.toString(), time.text.toString(), date.text.toString(), Integer.parseInt(cost.text.toString()))

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://be-trip-back322.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create<RouteService>(RouteService::class.java)

            service.postRoute(1, route).enqueue(object : Callback<Route>{
                override fun onFailure(call: Call<Route>, t: Throwable) {
                    Toast.makeText(this@CreateTripActivity, t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Route>, response: Response<Route>) {
                    if(response.isSuccessful){
                        Toast.makeText(this@CreateTripActivity, "Creacion correcta", Toast.LENGTH_SHORT).show()
                    }
                    else Toast.makeText(this@CreateTripActivity,"Creacion fallida", Toast.LENGTH_SHORT).show()
                }
            })

            startActivity(Intent(this, HomeDriverActivity::class.java))
        }
    }

    private fun buttonsActions() {
        val btCreateTrip=findViewById<Button>(R.id.btCreateTrips)

        btCreateTrip.setOnClickListener {
            startActivity(Intent(this, HomeDriverActivity::class.java))
        }
    }
}