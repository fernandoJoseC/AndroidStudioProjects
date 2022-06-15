package com.example.practicamiercoles.listado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicamiercoles.Adaptador
import com.example.practicamiercoles.R
import com.example.practicamiercoles.databinding.ActivityListProductsBinding
import com.example.practicamiercoles.descProduct
import com.example.practicamiercoles.dto.Product
import com.example.practicamiercoles.dto.WsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class listProducts : AppCompatActivity() {

    private lateinit var views: ActivityListProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityListProductsBinding.inflate(layoutInflater)
        setContentView(views.root)
        initialConfiguration()
        addListProducts()
        /*initializationListeners()*/
    }

    private fun initialConfiguration() {
        views.listItems.layoutManager = LinearLayoutManager(this)
    }

    private fun addListProducts() {
        WsClient.apiLista()?.buscarListaProductos()?.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val list = response.body()!!
                    views.listItems.adapter = Adaptador(list)
                } else {
                    Toast.makeText(
                        this@listProducts,
                        android.R.string.httpErrorBadUrl,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(
                    this@listProducts,
                    android.R.string.httpErrorBadUrl,
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    /*private fun initializationListeners(){
        views.listItems.setOnClickListener {
            goToDescProduct()
        }
    }
    private fun goToDescProduct(){
        var intent: Intent = Intent(this, descProduct::class.java)
        startActivity(intent)
    }*/
}