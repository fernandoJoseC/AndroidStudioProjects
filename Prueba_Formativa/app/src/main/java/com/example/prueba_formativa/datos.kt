package com.example.prueba_formativa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prueba_formativa.databinding.ActivityDatosBinding
import com.example.prueba_formativa.dto.Cedula
import com.example.prueba_formativa.dto.WsClient
import com.example.prueba_formativa.dto.Telefonos
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class datos : AppCompatActivity() {

    private lateinit var views: ActivityDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        views = ActivityDatosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(views.root)
        addListProduct()

    }



    private fun addListProduct() {
        var cedulaEnviar = intent.getStringExtra("cedula")
        var cedula = Cedula()
        cedula.cedula = cedulaEnviar
        var token = intent.getStringExtra("token")!!
        val nombre = intent.getStringExtra("nombres")
        val telefono = intent.getStringExtra("telefono")
        val email = intent.getStringExtra("email")
        val foto = intent.getStringExtra("foto")

        views.nombre.setText(nombre)
        views.telefono.setText(telefono)
        views.email.setText(email)
        Picasso.get().load(foto).fit().centerInside().into(views.imagen)
        WsClient.api()?.buscarListaTelefonos(token,cedula)?.enqueue(object : Callback<List<Telefonos>>{
            override fun onResponse(call: Call<List<Telefonos>>, response: Response<List<Telefonos>>) {
                if (response.isSuccessful){
                    val list = response.body()!!
                    views.listadoItems.adapter = Adaptador(list)
                }else{
                    Toast.makeText(this@datos,android.R.string.httpErrorBadUrl,Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Telefonos>>, t: Throwable) {
                Toast.makeText(this@datos,android.R.string.httpErrorBadUrl, Toast.LENGTH_SHORT).show()
            }

        })
    }
}