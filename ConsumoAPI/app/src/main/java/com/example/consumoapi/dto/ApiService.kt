package com.example.consumoapi.dto

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("api/camiones")
    fun buscarListaProductos(): Call<List<Producto>>

    @Headers("Content-Type: application/json")
    @POST("autentication/login")
    fun logearse(
        @Body usuario: Usuario
    ): Call<String>


}