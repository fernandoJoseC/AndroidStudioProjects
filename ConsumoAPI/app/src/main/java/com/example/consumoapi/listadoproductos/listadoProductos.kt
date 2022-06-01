package com.example.consumoapi.listadoproductos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumoapi.Adaptador
import com.example.consumoapi.R
import com.example.consumoapi.databinding.ActivityListadoProductosBinding
import com.example.consumoapi.dto.Producto
import com.example.consumoapi.dto.WsClient
import com.example.consumoapi.producto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class listadoProductos : AppCompatActivity() {

    private lateinit var views: ActivityListadoProductosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityListadoProductosBinding.inflate(layoutInflater)
        setContentView(views.root)
        initialConfiguration()
        addListProducts()
    }

    private fun initialConfiguration() {
        views.listadoItems.layoutManager = LinearLayoutManager(this)
    }

    private fun addListProducts() {
        WsClient.api()?.buscarListaProductos()?.enqueue(object : Callback<List<Producto>> {
            override fun onResponse(call: Call<List<Producto>>, response: Response<List<Producto>>) {
                if (response.isSuccessful){
                    val list = response.body()!!
                    views.listadoItems.adapter = Adaptador(list)
                }else{
                    Toast.makeText(
                        this@listadoProductos,
                        android.R.string.httpErrorBadUrl,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Producto>>, t: Throwable) {
                Toast.makeText(
                    this@listadoProductos,
                    android.R.string.httpErrorBadUrl,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}