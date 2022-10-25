package com.betrip.project.api

import com.betrip.project.models.LoginUser
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("api/v1/travelers/auth/sign-in")
    fun userLogin(
        @Field("email") email:String,
        @Field("password") password:String
    ): Call<LoginUser>
}