package com.example.consumoapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.consumoapi.databinding.ActivityPreferenciasBinding
import com.example.consumoapi.listadoproductos.listadoProductos

class Preferencias : AppCompatActivity() {

    private lateinit var views: ActivityPreferenciasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityPreferenciasBinding.inflate(layoutInflater)
        setContentView(views.root)
        accionesMenuBajo()

    }

    private fun accionesMenuBajo() {
        views.navigation.setOnItemSelectedListener { itemBajo ->
            when (itemBajo.itemId) {
                R.id.home -> {
                    val intent = Intent(this@Preferencias, listadoProductos::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.personal -> {
                    Toast.makeText(this, "a donde voy", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false

            }
        }
    }
}