package com.betrip.project.drivers.network

import com.betrip.project.drivers.models.Route
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface RouteService {
    @POST("drivers/{driverId}/driver-routes")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun postRoute(@Path("driverId")id:Int ,@Body route: Route):Call<Route>

}