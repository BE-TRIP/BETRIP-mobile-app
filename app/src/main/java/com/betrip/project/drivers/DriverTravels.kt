package com.betrip.project.drivers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrip.project.R
import com.betrip.project.drivers.adapters.DriverTravelAdapter
import com.betrip.project.drivers.models.TravelEvent

class DriverTravels : AppCompatActivity() {

    var travels = ArrayList<TravelEvent>()
    var driverTravelAdapter = DriverTravelAdapter(travels)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_travels)

        loadTravels()
        initView()
    }

    private fun initView(){
        val rvTravelEvent = findViewById<RecyclerView>(R.id.rvDriverTravels)
        rvTravelEvent.adapter = driverTravelAdapter
        rvTravelEvent.layoutManager = LinearLayoutManager(this)
    }

    private fun loadTravels(){
        travels.add(TravelEvent("Lima","6:00pm","8:00pm","21/10/22","21/10/22",50,"Minivan",5))
    }
}