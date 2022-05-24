package com.example.pruebas.dto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebas.R
import com.example.pruebas.databinding.ProductoIndividualBinding

class ProductoAdaptador(private var listadoProductos: List<ProductoSimulado2>) :
    RecyclerView.Adapter<ProductoAdaptador.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.producto_individual, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productoActual = listadoProductos[position]
        holder.viewsViewHolder.nombreProducto.setText(productoActual.nombre)
        holder.viewsViewHolder.descriptionProduct.setText(productoActual.descripcion)

        //aqui falta la imagen
    }

    override fun getItemCount(): Int {
        return listadoProductos.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var viewsViewHolder: ProductoIndividualBinding
        /*var uri: String
        var nombre: String
        var descripcion: String*/

        init {
            viewsViewHolder = ProductoIndividualBinding.bind(itemView)
            /*uri = ""
            nombre = ""
            descripcion = ""*/
        }
    }


}