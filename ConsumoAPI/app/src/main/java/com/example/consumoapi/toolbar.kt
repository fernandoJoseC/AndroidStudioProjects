package com.example.consumoapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView

class toolbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.principal, menu)
        val menuItem = menu?.findItem(R.id.buscar)
        hacerBuscar(menuItem)
        return super.onCreateOptionsMenu(menu)
    }

    private fun hacerBuscar(menuItem: MenuItem?) {
        val buscarAlgo = menuItem?.actionView as SearchView
        buscarAlgo.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@toolbar,"typing... " + query, Toast.LENGTH_LONG).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(this@toolbar, "mandando a buscar... "+newText, Toast.LENGTH_LONG).show()
                return false
            }
        })

    }
}