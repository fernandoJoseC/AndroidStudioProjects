package com.example.practicamiercoles.dto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.net.URL

class WsClient {
    companion object {
        private const val URLLogeo = "http://172.16.70.79:8080/"
        private const val URLLista = "https://proyecto-pm.herokuapp.com/"
        private var retrofit: Retrofit? = null

        private fun retrofitClient(url: String): Retrofit? {
            retrofit = Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit
        }

        fun apiLogeo(): ApiService? {
            return retrofitClient(URLLogeo)?.create(ApiService::class.java)
        }

        fun apiLista(): ApiService? {
            return retrofitClient(URLLista)?.create(ApiService::class.java)
        }

    }
}