package com.betrip.project.travelers.models

class TravelEvent (
    val id:Int,
    val driverId:Int,
    val destiny:String,
    val destinyUrl: String,
    val seating:Int,
    val starting_point:String,
    val departure_time: String,
    val departure_date:String,
    val cost:Int,
    val type:String,
    val plate:String,
    val travelerProfilePhotofUrl:String
)