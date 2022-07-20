package com.example.prueba_formativa.dto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//conexion con WebServices Client API

class WsClient {
    companion object {

        private const val URL = "http://172.16.78.95:8080"


        private var retrofit: Retrofit? = null

        private fun retrofitClient(): Retrofit? {
            if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

        fun api(): ApiService? {
            return retrofitClient()?.create(ApiService::class.java)
        }



    }


}