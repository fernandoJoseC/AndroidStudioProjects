package com.example.practicamiercoles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicamiercoles.databinding.ActivityMainBinding
import com.example.practicamiercoles.dto.User
import com.example.practicamiercoles.dto.WsClient
import com.example.practicamiercoles.listado.listProducts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var views: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater)
        setContentView(views.root)
        initializationListeners()
    }
    private fun initializationListeners(){
        /*views.enterButton.setOnClickListener {
            var usuario = User()
            usuario.usuario = views.editUser.text.toString().trim()
            usuario.clave = views.editPassword.text.toString().trim()
            WsClient.apiLogeo()?.logearse(usuario)?.enqueue(object : Callback<String>{
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful && !response.body().toString().isEmpty()){
                        val intent = Intent(this@MainActivity, listProducts::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@MainActivity, "Wrong Password", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message.toString(), Toast.LENGTH_SHORT).show()
                }
            })
        }*/
        views.enterButton.setOnClickListener {
            goToList()
        }
        views.registerButton.setOnClickListener {
            goToRegister()
        }
    }
    private fun goToList(){
        var intent: Intent = Intent(this, listProducts::class.java)
        startActivity(intent)
    }
    private fun goToRegister(){
        var intent: Intent = Intent(this, register::class.java)
        startActivity(intent)
    }
}