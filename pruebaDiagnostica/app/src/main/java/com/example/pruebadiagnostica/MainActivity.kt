package com.example.pruebadiagnostica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebadiagnostica.databinding.ActivityMainBinding
import com.example.pruebadiagnostica.datos.Datos

class MainActivity : AppCompatActivity() {

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.buttonRegister.setOnClickListener {
            goToDatos()
        }
    }

    private fun goToDatos() {
        var intent: Intent = Intent(this,Datos::class.java)
        startActivity(intent)
    }
}