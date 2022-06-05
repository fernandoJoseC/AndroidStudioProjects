package com.example.consumoapi.dto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//conexion con WebServices Client API

class WsClient {
    companion object {

        /*private const val URL = "http://172.16.4.55/backendRapidoMovil/"*/
        private const val URL = "https://proyecto-pm.herokuapp.com/"
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