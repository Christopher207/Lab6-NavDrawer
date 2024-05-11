package com.example.lab6_navdrawer

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etUser: EditText = findViewById<EditText>(R.id.etUser)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val btnSave: Button = findViewById(R.id.btnLogin)

        btnSave.setOnClickListener{
            val email: String = etUser.text.toString()
            val password: String = etPassword.text.toString()
            if(email=="invitado@esan.com"&&password=="invitado123"){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            val rootView: View = findViewById(android.R.id.content)//También se puede usar Toast
            Snackbar.make(rootView,"Credenciales inválidas", Snackbar.LENGTH_LONG).show()
        }
    }
}