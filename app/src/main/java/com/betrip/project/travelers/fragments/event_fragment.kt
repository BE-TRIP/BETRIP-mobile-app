package com.betrip.project.travelers.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrip.project.R
import com.betrip.project.travelers.SelectedTravelEvent
import com.betrip.project.travelers.TravelEventAdapter
import com.betrip.project.travelers.models.ApiResponseDetails
import com.betrip.project.travelers.models.TravelEvent
import com.betrip.project.travelers.network.TravelEventService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class event_fragment : Fragment() {
    var travelEvents= mutableListOf<TravelEvent>()
    lateinit var travelEventAdapter: TravelEventAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_event_fragment, container, false)
        loadContact()

        travelEventAdapter = TravelEventAdapter(travelEvents,{travelEvent ->loadEventTravel(travelEvent) })
        val rvTravelEvent = view.findViewById<RecyclerView>(R.id.rvEvents2)
        rvTravelEvent.adapter = travelEventAdapter
        rvTravelEvent.layoutManager = LinearLayoutManager(context)
        return view
    }
    private fun loadContact() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://be-trip-back322.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val eventService: TravelEventService
        eventService = retrofit.create(TravelEventService::class.java)
        val request = eventService.getEvents(
            0,1,
            "string")

        request.enqueue(object : Callback<ApiResponseDetails> {
            override fun onFailure(call: Call<ApiResponseDetails>, t: Throwable) {
                Log.d("Activity Fail", "Error: "+t.toString())
            }

            override fun onResponse(call: Call<ApiResponseDetails>, responseDetails: Response<ApiResponseDetails>) {
                if (responseDetails.isSuccessful) {
                    val events: List<TravelEvent> = responseDetails.body()!!.travelEvents
                    travelEvents= events as MutableList<TravelEvent>
                    //recyclerView.layoutManager = LinearLayoutManager(context)
                    //recyclerView.adapter = ProductAdapter(products, { product,context->onItemClicked(product,context)},1)
                }

                else{
                    Log.d("Activity Fail", "Error: "+responseDetails.code())
                }
            }
        })


    }
    private fun loadEventTravel(travelEvent: TravelEvent){
        val intent= Intent(context,SelectedTravelEvent::class.java).apply {
            putExtra("ID",travelEvent.id)
        }
        startActivity(intent)
    }
}
