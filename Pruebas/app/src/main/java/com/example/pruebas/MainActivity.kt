package com.example.pruebas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pruebas.databinding.ActivityMainBinding

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
            Toast.makeText(this, views.textInput.text, Toast.LENGTH_SHORT).show()
            views.textInput.setText ( resources.getString(R.string.app_name))
        }
    }
}