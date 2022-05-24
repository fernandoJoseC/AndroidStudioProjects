package com.example.pruebas.interface_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebas.R
import com.example.pruebas.databinding.ActivityProductosBinding
import com.example.pruebas.dto.ProductoAdaptador
import com.example.pruebas.dto.ProductoSimulado
import com.example.pruebas.dto.ProductoSimulado2
import com.example.pruebas.fragments.Producto

class Productos : AppCompatActivity() {

    private lateinit var views: ActivityProductosBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(views.root)
        cargarProductos()

    }

    private fun cargarProductos(){
        val listaDeProductos = emularProductos()
        val adaptador = ProductoAdaptador(listaDeProductos)
        views.listaProductos.adapter = adaptador
    }

    private fun emularProductos(): List<ProductoSimulado2> {
        /*var producto_uno =
            ProductoSimulado.Builder().nombre("hamburguesa").descripcion("carne y aderezo").uri("")
                .build()*/
        var producto_uno = ProductoSimulado2()
        producto_uno.uri =
            "https://www.google.com/imgres?imgurl=https%3A%2F%2Fcookingwithdog.com%2Fwp-content%2Fuploads%2F2021%2F06%2Fbeef-hamburger-00.jpg&imgrefurl=https%3A%2F%2Fcookingwithdog.com%2Frecipe%2Fbeef-hamburger%2F&tbnid=KhKIyLVzfgFoqM&vet=10CAEQMyhoahcKEwjor46X2fb3AhUAAAAAHQAAAAAQAg..i&docid=3gcWIWIVTEvneM&w=1820&h=1024&q=hamburger&ved=0CAEQMyhoahcKEwjor46X2fb3AhUAAAAAHQAAAAAQAg"
        producto_uno.nombre = "hamburguesa de chorizo"
        producto_uno.descripcion = "chorizo y aderezos"

        var producto_dos = ProductoSimulado2()
        producto_dos.uri =
            "https://www.google.com/imgres?imgurl=https%3A%2F%2Felcorral.com.ec%2Fimg%2Four-cart%2F20200206051723.jpeg&imgrefurl=https%3A%2F%2Felcorral.com.ec%2Fnuestra-carta%2Fpollo&tbnid=75F0mWWc6yIUtM&vet=12ahUKEwjo0I6j2fb3AhXoi4QIHZoXChYQMygBegUIARDMAQ..i&docid=RK5-w-stqXd5NM&w=657&h=445&q=hamburger%20pollo&ved=2ahUKEwjo0I6j2fb3AhXoi4QIHZoXChYQMygBegUIARDMAQ"
        producto_dos.descripcion = "pollo y aderezos"
        producto_dos.nombre = "hamburguesa de pollo"

        val listado = listOf(producto_uno,producto_dos)
        return listado
    }
}
