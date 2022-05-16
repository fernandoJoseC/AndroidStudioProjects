package com.example.appfernandoandroid.interface_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfernandoandroid.R
import com.example.appfernandoandroid.databinding.ActivityPrincipalMainBinding

class Principal_main : AppCompatActivity() {

    private lateinit var views: ActivityPrincipalMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityPrincipalMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        showName(intent)

    }
    private fun showName(intent: Intent){
        val user_name=intent.getStringExtra("name_user")
        views.userLabel.setText("Hola ".toString()+user_name)
    }
}