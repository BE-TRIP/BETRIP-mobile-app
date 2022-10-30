package com.betrip.project.travelers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.betrip.project.R
import com.betrip.project.travelers.models.TravelEvent
import com.betrip.project.travelers.network.TravelEventService
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SelectedTravelEvent : AppCompatActivity() {
    private val url="https://be-trip-back322.herokuapp.com/api/v1/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selected_travel_event)
        val intent3=intent.getIntExtra("ID",1)
        loadData(this,intent3)
    }
    fun loadData(context:Context,id:Int){
        val destiny=findViewById<TextView>(R.id.tvDestinySelected)
        val departureDate=findViewById<TextView>(R.id.tvDepartureDateSelected)
        val departureTime=findViewById<TextView>(R.id.tvDepartureTimeSelected)
        val seating=findViewById<TextView>(R.id.tvDepartureSeatingsSelected)
        val imgView=findViewById<ImageView>(R.id.imvSelectedImg)
        val retrofit= Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create())
            .build()
        val travelEventService:TravelEventService
        travelEventService=retrofit.create(TravelEventService::class.java)
        //function get jokes access
        val request=travelEventService.getEventById(id)
        request.enqueue(object : Callback<TravelEvent> {
            override fun onResponse(call: Call<TravelEvent>, response: Response<TravelEvent>) {
                if(response.isSuccessful){
                    destiny.text=response.body()!!.destiny
                    departureDate.text=response.body()!!.departure_date
                    departureTime.text=response.body()!!.departure_time
                    seating.text=response.body()!!.seating.toString()
                    val picBuilder = Picasso.Builder(context)
                    picBuilder.downloader(OkHttp3Downloader(context))
                    picBuilder.build().load(response.body()!!.destinyUrl).into(imgView)
                }

            }

            override fun onFailure(call: Call<TravelEvent>, t: Throwable) {
                destiny.text="your internet is trash, gfys"
            }

        })

    }
}