package com.example.appfernandoandroid.interface_user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfernandoandroid.databinding.ActivityInterfaceUserBinding


class interface_user : AppCompatActivity() {

    private lateinit var views: ActivityInterfaceUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityInterfaceUserBinding.inflate(layoutInflater)
        setContentView(views.root)
        showName(intent)
    }

    private fun showName(intent: Intent) {

        val user_name = intent.getStringExtra("name_user")
        views.showName.setText(user_name)

    }


}