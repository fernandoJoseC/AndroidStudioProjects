package com.example.practicamiercoles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicamiercoles.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {

    private lateinit var views: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializationListeners()
    }

    private fun initializationListeners(){
        views.registerButtonActivity.setOnClickListener {
            goToMain()
        }
    }

    private fun goToMain(){
        var intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}