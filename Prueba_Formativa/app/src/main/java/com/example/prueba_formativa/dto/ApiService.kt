package com.example.prueba_formativa.dto

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @Headers("Content-Type: application/json")
    @POST("telefono/telefonos")
    fun buscarListaTelefonos(
        @Header("Authorization") token: String,
        @Body cedula: Cedula,
    ): Call<List<Telefonos>>

    @Headers("Content-Type: application/json")
    @POST("autentication/login")
    fun logearse(
        @Body usuario: User
    ): Call<Persona>




}