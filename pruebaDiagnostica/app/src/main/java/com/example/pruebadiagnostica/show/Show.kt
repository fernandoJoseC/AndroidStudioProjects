package com.example.pruebadiagnostica.show

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebadiagnostica.R
import com.example.pruebadiagnostica.databinding.ActivityShowBinding

class Show : AppCompatActivity() {

    private lateinit var views: ActivityShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityShowBinding.inflate(layoutInflater)
        setContentView(views.root)
        showName(intent)
    }

    private fun showName(intent: Intent){
        val text_User = intent.getStringExtra("textUser")
        val text_Name = intent.getStringExtra("textName")
        val text_Email = intent.getStringExtra("textEmail")
        val text_Password = intent.getStringExtra("textPassword")
        val text_Telefono = intent.getStringExtra("textTelefono")
        val text_Direccion = intent.getStringExtra("textDireccion")

        views.viewUsuario.setText(text_User)
        views.viewName.setText(text_Name)
        views.viewEmail.setText(text_Email)
        views.viewPassword.setText(text_Password)
        views.viewPhone.setText(text_Telefono)
        views.viewAddress.setText(text_Direccion)

    }
}
