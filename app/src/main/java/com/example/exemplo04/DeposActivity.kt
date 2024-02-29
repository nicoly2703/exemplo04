package com.example.exemplo04

import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class DeposActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depos)

        setSupportActionBar(findViewById(R.id.toolbar1))

        val saldo = intent.getStringExtra("sSaldo")
        val txtSaldo = findViewById<EditText>(R.id.txtsaldo3)
        txtSaldo.setText(saldo.toString())
        var nsaldo = saldo.toString().toDouble()
        val btConf = findViewById<Button>(R.id.edtConfirma)

        btConf.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.edtvalor)
            var nvalor = valorPix.text.toString().toDouble()
            if (nvalor > nsaldo) {
                Toast.makeText(
                    this, "Saldo de $nsaldo é insuficiente para $nvalor",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                nsaldo += nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK, data)
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            valorPix.setText("".toString())
            finish()
        }
    }
    fun voltarDepos (view: View) {
        val editText = findViewById<EditText>(R.id.edtvalor)
        val voltar = editText.text.toString()
    }
}