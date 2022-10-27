package com.betrip.project.travelers.models

import com.google.gson.annotations.SerializedName

class ApiResponseDetails (
    @SerializedName("content")
    val travelEvents: List<TravelEvent>
    )

