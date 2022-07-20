package com.example.prueba_formativa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prueba_formativa.databinding.ActivityDatosBinding
import com.example.prueba_formativa.databinding.ActivityMainBinding
import com.example.prueba_formativa.dto.WsClient
import com.example.prueba_formativa.dto.Persona
import com.example.prueba_formativa.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        logearse()

    }

    private fun logearse() {
        views.entrar.setOnClickListener {
            var usuarioEnviar = User()
            val usuario = views.userInput.text.toString().trim()
            val clave = views.passInput.text.toString().trim()
            usuarioEnviar.usuario = usuario
            usuarioEnviar.clave = clave
            WsClient.api()?.logearse(usuarioEnviar)?.enqueue(object : Callback<Persona> {
                override fun onResponse(call: Call<Persona>, response: Response<Persona>) {
                    if (response.isSuccessful && !response.body().toString().isEmpty()) {
                        val token = response.headers().get("authorization")!! // !! no sea nulo
                        val persona = response.body()!!
                        goToDatos(token, persona)

                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            response.errorBody().toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<Persona>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
            //goToDatos()

        }
    }

    private fun goToDatos(token: String, persona: Persona) {
        var intent: Intent = Intent(this, datos::class.java)
        intent.putExtra("nombres", persona.nombres)
        intent.putExtra("email", persona.email)
        intent.putExtra("telefono", persona.telefono)
        intent.putExtra("foto", persona.foto)
        intent.putExtra("cedula", persona.cedula)
        intent.putExtra("token", token)
        startActivity(intent)
    }

}
