package com.example.pruebas.dto

class ProductoSimulado private constructor(

    val uri: String? = null,
    val nombre: String? = null,
    val descripcion: String? = null,

    ) {

    data class Builder(

        var uri: String? = null,
        var nombre: String? = null,
        var descripcion: String? = null,

    ){
        fun uri(uri: String?) = apply { this.uri = uri }
        fun nombre(nombre: String?) = apply { this.nombre=nombre }
        fun descripcion(descripcion: String?) = apply { this.descripcion=descripcion }
        fun build()=ProductoSimulado(uri,nombre,descripcion)
    }

}