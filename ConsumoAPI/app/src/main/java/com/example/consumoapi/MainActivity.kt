package com.example.consumoapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.consumoapi.databinding.ActivityMainBinding
import com.example.consumoapi.listadoproductos.listadoProductos

class MainActivity : AppCompatActivity() {

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.button.setOnClickListener {
            goToListadoProductos()
        }

    }
    private fun goToListadoProductos(){
        var intent: Intent = Intent(this,listadoProductos::class.java)
        startActivity(intent)
    }
}