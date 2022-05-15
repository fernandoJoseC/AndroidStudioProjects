package com.example.appfernandoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appfernandoandroid.databinding.ActivityMainBinding
import com.example.appfernandoandroid.interface_user.interface_user


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
            //var textoRecogido = views.textInput.text
            //Toast.makeText(this, ("el usuario es "+ views.editTextUserName2.text + " la contrasena es "+views.editTextPassword2.text), Toast.LENGTH_SHORT).show()
            val userText = views.editTextUserName2.text.toString()
            val passwordText = views.editTextPassword2.text.toString()

            userText?.let {
                passwordText?.let { itp ->
                    if (it.equals("fernando") && itp.equals("5311")) {
                        goToPrincipal(userText)
                    }
                }
            }
        }
    }

    private fun goToPrincipal(userText:String){
        var intent: Intent = Intent(this, interface_user::class.java)
        intent.putExtra("name_user", userText)
        startActivity(intent)
    }


}