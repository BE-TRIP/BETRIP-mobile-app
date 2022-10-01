package com.betrip.project.drivers.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.betrip.project.R
import com.betrip.project.drivers.models.TravelEvent

class DriverTravelAdapter (var travels: ArrayList<TravelEvent>): RecyclerView.Adapter<DriverTravelPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverTravelPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_driver_travels, parent, false)

        return  DriverTravelPrototype(view)
    }

    override fun onBindViewHolder(holder: DriverTravelPrototype, position: Int) {
        holder.bind(travels.get(position))
    }

    override fun getItemCount(): Int {
        return travels.size
    }
}

class DriverTravelPrototype(itemView: View): RecyclerView.ViewHolder(itemView) {
    val tvDestiny = itemView.findViewById<TextView>(R.id.tvDestiny)
    val tvVehicle = itemView.findViewById<TextView>(R.id.tvVehicleDriver)
    val tvDepartureTime = itemView.findViewById<TextView>(R.id.tvDepartureTime)
    val tvCost = itemView.findViewById<TextView>(R.id.tvCostDriverTravel)

    fun bind(travelEvent: TravelEvent){
        tvDestiny.text = travelEvent.destiny
        tvVehicle.text = travelEvent.vehicle_type
        tvDepartureTime.text = travelEvent.departure_time
        tvCost.text = travelEvent.cost.toString()
    }
}