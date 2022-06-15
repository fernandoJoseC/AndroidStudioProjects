package com.example.pruebadiagnostica.datos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pruebadiagnostica.R
import com.example.pruebadiagnostica.databinding.ActivityDatosBinding
import com.example.pruebadiagnostica.show.Show

class Datos : AppCompatActivity() {

    private lateinit var views: ActivityDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityDatosBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializacionListeners()
    }

    private fun initializacionListeners() {
        views.buttonAccept.setOnClickListener {
            val pass = views.passwordLayoutEdit.text.toString()
            if (views.userLayoutEdit.text.toString().length >= 8 &&
                views.nameLayoutEdit.text.toString().length >= 8 &&
                views.emailLayoutEdit.text.toString().length >= 8 &&
                pass == views.rpasswordLayoutEdit.text.toString() &&
                views.phoneLayoutEdit.text.toString().length == 10 &&
                views.addressLayoutEdit.text != null

            ) {
                val userText = views.userLayoutEdit.text.toString()
                val nameText = views.nameLayoutEdit.text.toString()
                val emailText = views.emailLayoutEdit.text.toString()
                val passwordText = views.passwordLayoutEdit.text.toString()
                val telefonoText = views.phoneLayoutEdit.text.toString()
                val direccionText = views.addressLayoutEdit.text.toString()
                goToShow(userText, nameText, emailText, passwordText, telefonoText, direccionText)
            } else {
                Toast.makeText(this, "La contraseña debe ser la misma", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun goToShow(
        userText: String,
        nameText: String,
        emailText: String,
        passwordText: String,
        telefonoText: String,
        direccionText: String
    ) {

        var intent: Intent = Intent(this, Show::class.java)
        intent.putExtra("textUser", userText)
        intent.putExtra("textName", nameText)
        intent.putExtra("textEmail", emailText)
        intent.putExtra("textPassword", passwordText)
        intent.putExtra("textTelefono", telefonoText)
        intent.putExtra("textDireccion", direccionText)
        startActivity(intent)
    }
}