package com.example.appfernandoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfernandoandroid.databinding.ActivityMainBinding
import com.example.appfernandoandroid.interface_user.Principal_main


class MainActivity : AppCompatActivity() {

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.buttonLoggin.setOnClickListener {
            //var textoRecogido = views.textInput.text
            //Toast.makeText(this, ("el usuario es "+ views.editTextUserName2.text + " la contrasena es "+views.editTextPassword2.text), Toast.LENGTH_SHORT).show()
            val userText = views.inputUserNameEdit.text.toString()
            val passwordText = views.inputPasswordEdit.text.toString()
            userText?.let {
                passwordText?.let { itp ->
                    if (it.equals("fernando") && itp.equals("5311")) {
                        goToPrincipal(userText)
                    }
                }
            }
        }
    }

    private fun goToPrincipal(userText: String) {
        var intent: Intent = Intent(this, Principal_main::class.java)
        intent.putExtra("name_user", userText)
        startActivity(intent)
    }


}