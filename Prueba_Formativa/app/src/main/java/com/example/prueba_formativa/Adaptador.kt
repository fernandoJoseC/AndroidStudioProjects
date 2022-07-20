package com.example.prueba_formativa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba_formativa.databinding.FragmentTelefonosBinding
import com.example.prueba_formativa.dto.Telefonos

class Adaptador(val lista: List<Telefonos>) : RecyclerView.Adapter<Adaptador.TelefonoHolder>() {
    inner class TelefonoHolder(fragmetoView: View) : RecyclerView.ViewHolder(fragmetoView) {
        var viewsFragmentHolder: FragmentTelefonosBinding

        init {
            viewsFragmentHolder = FragmentTelefonosBinding.bind(fragmetoView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelefonoHolder {
        return TelefonoHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_telefonos, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TelefonoHolder, position: Int) {
        val numero = lista[position]
        holder.viewsFragmentHolder.number.text = numero.numero
    }

    override fun getItemCount(): Int {
        return lista.size
    }
}