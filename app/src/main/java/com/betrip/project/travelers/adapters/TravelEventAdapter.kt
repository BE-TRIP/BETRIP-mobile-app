package com.betrip.project.travelers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.betrip.project.R
import com.betrip.project.travelers.models.TravelEvent

class TravelEventAdapter(private val travelEvents:List<TravelEvent>, private val onClickListener: (TravelEvent)->Unit): RecyclerView.Adapter<TravelEventPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TravelEventPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_event_card, parent,false)

        return TravelEventPrototype(view)
    }

    override fun onBindViewHolder(holder: TravelEventPrototype, position: Int) {
        holder.bind(travelEvents[position],onClickListener)
    }

    override fun getItemCount(): Int {
        return travelEvents.size
    }

}

class TravelEventPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvDestiny = itemView.findViewById<TextView>(R.id.tvDestiny)
    val tvDepartureTime = itemView.findViewById<TextView>(R.id.tvDepartureTime)
    val tvDepartureDate = itemView.findViewById<TextView>(R.id.tvDate)
    val tvSeat = itemView.findViewById<TextView>(R.id.tvSeats)
    val btKnowMore=itemView.findViewById<Button>(R.id.btKnowMore)
    fun bind(travelEvent: TravelEvent,onClickListener: (TravelEvent) -> Unit){
        tvDestiny.text = travelEvent.destiny
        tvDepartureTime.text = travelEvent.departure_time
        tvDepartureDate.text = travelEvent.departure_date
        tvSeat.text = travelEvent.seats.toString()
        btKnowMore.setOnClickListener(){
            onClickListener(travelEvent)
        }
    }
}
