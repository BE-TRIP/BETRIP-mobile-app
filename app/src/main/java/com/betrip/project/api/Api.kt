package com.betrip.project.api

import com.betrip.project.models.LoginUser
import com.betrip.project.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api {
    @POST("api/v1/travelers/auth/sign-in")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun userLogin(@Body post: User): Call<LoginUser>
}