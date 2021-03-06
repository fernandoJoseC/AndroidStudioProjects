package com.example.deliveryfernando

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.deliveryfernando.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()

    }

    private fun initializacionListeners(){
        views.button.setOnClickListener {
            //var textoRecogido = views.textInput.text
            Toast.makeText(this, ("el usuario es "+ views.editTextTextPersonName.text + " la contrasena es "+views.editTextTextPassword.text), Toast.LENGTH_SHORT).show()

        }
    }
}