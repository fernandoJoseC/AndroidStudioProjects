package com.example.consumoapi.listadoproductos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.consumoapi.Adaptador
import com.example.consumoapi.Preferencias
import com.example.consumoapi.R
import com.example.consumoapi.databinding.ActivityListadoProductosBinding
import com.example.consumoapi.dto.Producto
import com.example.consumoapi.dto.WsClient
import com.example.consumoapi.dto.WsLogin
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.buscar->{
                Toast.makeText(this, "quiero compartir", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.ajustes -> {
                val intent= Intent(this, Preferencias::class.java)
                startActivity(intent)
                true
            }
            R.id.ejemplo->{
                Toast.makeText(this, "Hola ejemplo", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initialConfiguration() {
        views.listadoItems.layoutManager = LinearLayoutManager(this)
    }

    private fun addListProducts() {
        WsLogin.apiLista()?.buscarListaProductos()?.enqueue(object : Callback<List<Producto>> {
            override fun onResponse(
                call: Call<List<Producto>>,
                response: Response<List<Producto>>
            ) {
                if (response.isSuccessful) {
                    val list = response.body()!!
                    views.listadoItems.adapter = Adaptador(list)
                } else {
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