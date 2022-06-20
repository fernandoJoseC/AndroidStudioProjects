package com.example.consumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.consumoapi.databinding.ActivityPreferenciasBinding

class Preferencias : AppCompatActivity() {

    private lateinit var views: ActivityPreferenciasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityPreferenciasBinding.inflate(layoutInflater)
        setContentView(views.root)
    }
}