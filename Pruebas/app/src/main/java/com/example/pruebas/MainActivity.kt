package com.example.pruebas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pruebas.databinding.ActivityMainBinding
import com.example.pruebas.interface_user.Principal
import com.example.pruebas.interface_user.Productos

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
            goToPrincipal()
        }
        views.goProducts.setOnClickListener{
            goToProduct()
        }
    }

    private fun goToPrincipal() {
        var intent: Intent = Intent(this,Principal::class.java)
        startActivity(intent)

    }
    private fun goToProduct(){
        var intent: Intent = Intent(this, Productos::class.java)
        startActivity(intent)

    }
}
