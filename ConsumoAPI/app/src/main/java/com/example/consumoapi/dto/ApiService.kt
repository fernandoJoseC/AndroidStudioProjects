package com.example.consumoapi.dto

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("index.php")
    fun buscarListaProductos(): Call<List<Producto>>
}