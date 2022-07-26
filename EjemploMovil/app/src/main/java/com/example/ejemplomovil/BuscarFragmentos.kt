package com.example.ejemplomovil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.casella.turecuador.db.Backend
import com.casella.turecuador.db.DatosEnviar
import com.example.ejemplomovil.backend.DatosUsuario
import com.example.ejemplomovil.buscador.AdaptadorPersonas
import com.example.ejemplomovil.databinding.ActivityBuscarFragmentosBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuscarFragmentos : AppCompatActivity() {

    private lateinit var views: ActivityBuscarFragmentosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityBuscarFragmentosBinding.inflate(layoutInflater)
        setContentView(views.root)
        setSupportActionBar(views.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_listado, menu)

        habilitarBuscador(menu.findItem(R.id.search))

        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.search) {
//            habilitarBuscador(item)
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun habilitarBuscador(item: MenuItem) {
        val buscador = item.actionView as SearchView
        buscador.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                buscando(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                buscando(newText)
                return false
            }

        })
    }

    private fun buscando(texto: String?) {
        // si este texto no es nulo
        texto?.let { textoReal ->
            if (textoReal.length >= 3) {
//                llamar backend
//                var datos = DatosEnviar()
//                datos.usuario = textoReal

                Backend.api()?.buscarPersona(DatosEnviar.Builder().user(textoReal).build())?.enqueue(object : Callback<List<DatosUsuario>>{
                    override fun onResponse(
                        call: Call<List<DatosUsuario>>,
                        response: Response<List<DatosUsuario>>
                    ) {
                        if (response.isSuccessful ){
                            // si no llega a ser nulo guardame la info en listado
                            response.body()?.let { listado ->
                                llenarFragmentos(listado)
                            }

                        }
                    }



                    override fun onFailure(call: Call<List<DatosUsuario>>, t: Throwable) {
                        TODO("Not yet implemented")
//                        Toast.makeText(this, t.message, Toast.LENGTH_SHORT)
                    }
                })
            }
        }


    }

    private fun llenarFragmentos(lista: List<DatosUsuario>) {
        views.enlistador.layoutManager = LinearLayoutManager(this)
        views.enlistador.adapter = AdaptadorPersonas(lista)
    }


}