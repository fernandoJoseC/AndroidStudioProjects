package com.example.consumoapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.consumoapi.databinding.ActivityLoginBinding
import com.example.consumoapi.dto.Usuario
import com.example.consumoapi.dto.WsLogin
import com.example.consumoapi.listadoproductos.listadoProductos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login : AppCompatActivity() {
    private lateinit var views: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(views.root)
        addListeners()
    }

    private fun addListeners() {
        views.entrar.setOnClickListener {
            /*var usuario = Usuario()
            usuario.usuario = views.userInput.text.toString().trim()
            usuario.clave = views.passInput.text.toString().trim()
            WsLogin.apiLogeo()?.logearse(usuario)?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful && !response.body().toString().isEmpty()) {
                        val intent = Intent(this@login, listadoProductos::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@login, "clave erronea", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@login, t.message.toString(), Toast.LENGTH_SHORT).show()
                }

            })*/
            goToListado()
        }
    }
    private fun goToListado(){
        var intent: Intent = Intent(this,listadoProductos::class.java)
        startActivity(intent)
    }
}