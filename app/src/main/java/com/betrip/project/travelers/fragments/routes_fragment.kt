package com.betrip.project.travelers.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrip.project.R
import com.betrip.project.travelers.SelectedTravelEvent
import com.betrip.project.travelers.TravelEventAdapter
import com.betrip.project.travelers.models.TravelEvent

class routes_fragment : Fragment() {
    lateinit var travelEvents: List<TravelEvent>
    lateinit var travelEventAdapter: TravelEventAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_routes_fragment, container, false)
        loadContact()

       travelEventAdapter = TravelEventAdapter(travelEvents,{travelEvent ->loadEventTravel(travelEvent) })
        val rvTravelEvent = view.findViewById<RecyclerView>(R.id.rvRoutes)
        rvTravelEvent.adapter = travelEventAdapter
        rvTravelEvent.layoutManager = LinearLayoutManager(context)
        return view
    }
    private fun loadContact() {
        val geeks = listOf(TravelEvent("Lima","25-12-2002","15:00",12))
        travelEvents=geeks;
    }
    private fun loadEventTravel(travelEvent: TravelEvent){
        val intent= Intent(context, SelectedTravelEvent::class.java)
        startActivity(intent)
    }
}