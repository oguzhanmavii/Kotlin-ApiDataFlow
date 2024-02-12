package com.example.apidataflow

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("api/users")
    suspend fun getUsers(): ApiResponse
}

data class User(
    val id:Int,
    val email:String,
    val first_name:String,
    val last_name:String,
    val avatar:String
)

data class ApiResponse(
    val  data: List<User>
)

val retrofit = Retrofit.Builder()
    .baseUrl("https://reqres.in/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val apiService = retrofit.create(ApiService::class.java)

suspend fun fetchData(): List<User> {
    return apiService.getUsers().data
}