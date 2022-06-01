package com.example.consumoapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consumoapi.databinding.FragmentProductoBinding
import com.example.consumoapi.dto.Producto
import com.example.consumoapi.listadoproductos.listadoProductos
import com.squareup.picasso.Picasso

class Adaptador(val lista: List<Producto>) : RecyclerView.Adapter<Adaptador.ProductoHolder>() {

    inner class ProductoHolder(fragmentoView: View) : RecyclerView.ViewHolder(fragmentoView) {

        var viewsFragmentHolder: FragmentProductoBinding

        init {
            viewsFragmentHolder = FragmentProductoBinding.bind(fragmentoView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoHolder {
        return ProductoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_producto, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductoHolder, position: Int) {
        holder.viewsFragmentHolder.nombre.text = lista[position].nombre
        holder.viewsFragmentHolder.descripcion.text = lista[position].descripcion
        holder.viewsFragmentHolder.precio.text = lista[position].precio.toString()
        Picasso.get().load(lista[position].url).fit().centerInside().into(holder.viewsFragmentHolder.image)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}