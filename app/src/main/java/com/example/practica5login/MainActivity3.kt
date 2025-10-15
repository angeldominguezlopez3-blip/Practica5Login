package com.example.practica5login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    private lateinit var txtUsuario: TextView
    private lateinit var imgUsuario: ImageView
    private lateinit var btnSalir: Button
    private var conector: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtUsuario = findViewById(R.id.textViewUsuario)
        imgUsuario = findViewById(R.id.imageViewUsuario)
        btnSalir = findViewById(R.id.buttonSalir)

        conector = getSharedPreferences("usuarios", MODE_PRIVATE)

        val usuario = intent.getStringExtra("usuario") ?: "Usuario"

        // Mostrar información del usuario
        txtUsuario.text = "Bienvenido: $usuario"

        // Cargar imagen del usuario
        val imagenId = conector?.getInt("imagen_$usuario", R.drawable.user_default) ?: R.drawable.user_default
        imgUsuario.setImageResource(imagenId)

        btnSalir.setOnClickListener {
            val intent = Intent(this@MainActivity3, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}