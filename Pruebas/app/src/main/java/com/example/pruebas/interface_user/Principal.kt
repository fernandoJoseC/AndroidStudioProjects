package com.example.pruebas.interface_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import com.example.pruebas.R
import com.example.pruebas.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity() {

    private lateinit var views: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(views.root)
        showName(intent)
    }

    private fun showName(intent: Intent){
        val user_name = intent.getStringExtra("name_user")
        //views.showName.setText(resources.getText(R.string.app_name).toString()+": "+"hola fer")
        views.showName.setText(resources.getText(R.string.app_name).toString()+": "+user_name)

    }
}