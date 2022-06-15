package com.example.practicamiercoles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicamiercoles.databinding.FragmentProductBinding
import com.example.practicamiercoles.dto.Product
import com.squareup.picasso.Picasso

class Adaptador(val lista: List<Product>) : RecyclerView.Adapter<Adaptador.ProductoHolder>() {
    inner class ProductoHolder(fragmentoView: View) : RecyclerView.ViewHolder(fragmentoView) {
        var viewsFragmentoHolder: FragmentProductBinding

        init {
            viewsFragmentoHolder = FragmentProductBinding.bind(fragmentoView)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        return ProductoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        holder.viewsFragmentoHolder.textOne.text = lista[position].marca
        holder.viewsFragmentoHolder.textTwo.text = lista[position].modelo
        holder.viewsFragmentoHolder.textThree.text = lista[position].capacidad.toString()
        holder.viewsFragmentoHolder.textFour.text = lista[position].placas
        Picasso.get().load(lista[position].url).fit().centerInside()
            .into(holder.viewsFragmentoHolder.image)


    }

    override fun getItemCount(): Int {
        return lista.size
    }
}