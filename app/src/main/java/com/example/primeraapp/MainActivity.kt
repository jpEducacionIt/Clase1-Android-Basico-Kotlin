package com.example.primeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edNumberA: EditText
    private lateinit var edNumberB: EditText
    private lateinit var tvResultado: TextView
    private lateinit var botonCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNumberA = findViewById(R.id.eTNumberA)
        edNumberB = findViewById(R.id.eTNumberB)
        tvResultado = findViewById(R.id.tVResultado)
        botonCalcular = findViewById(R.id.buttonCalcular)

        botonCalcular.setOnClickListener {
            tvResultado.visibility = View.VISIBLE

            if (edNumberA.text.toString() != "" && edNumberB.text.toString() != "") {
                val numero1 = edNumberA.text.toString().toInt()
                val numero2 = edNumberB.text.toString().toInt()

                val operaciones = Operaciones(numero1, numero2, "resta")
                val resultado = when (operaciones.operacion) {
                    "resta" -> operaciones.numero1 - operaciones.numero2
                    else -> operaciones.numero1 + operaciones.numero2
                }
                tvResultado.text = resultado.toString()
            } else {
                Toast.makeText(this, "debe de agregar los 2 numeros", Toast.LENGTH_SHORT).show()
            }
        }
    }
}