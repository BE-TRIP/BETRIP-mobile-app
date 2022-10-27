package com.betrip.project.api

import com.betrip.project.models.LoginDriver
import com.betrip.project.models.LoginTraveler
import com.betrip.project.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @POST("api/v1/travelers/auth/sign-in")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun travelerLogin(@Body post: User): Call<LoginTraveler>

    @POST("api/v1/drivers/auth/sign-in")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun driverLogin(@Body post: User): Call<LoginDriver>
}