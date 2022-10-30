package com.betrip.project.travelers.network

import com.betrip.project.travelers.models.ApiResponseDetails
import com.betrip.project.travelers.models.TravelEvent
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TravelEventService {
    @GET("travel-events")
    fun getEvents(@Query("page")page:Int, @Query("size")size:Int, @Query("sort")apiKey:String): Call<ApiResponseDetails>
    @GET("travel-events/{id}")
    fun getEventById(@Path("id")id:Int):Call<TravelEvent>
}