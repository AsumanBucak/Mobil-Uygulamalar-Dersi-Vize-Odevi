package com.example.vizeuygulama

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class OrderShowActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_show)

        val orderName = intent.getStringExtra("orderName")
        val orderTuz = intent.getStringExtra("orderTuz")
        val orderAci = intent.getStringExtra("orderAci")
        val orderEkstra = intent.getStringExtra("orderEkstra")
        val ekstraIstek = intent.getStringExtra("ekstraIstek")

        val textViewOrderSelectTuzAci = findViewById<TextView>(R.id.textViewOrderSelectTuzAci)
        val textViewSelectedEkstra = findViewById<TextView>(R.id.textViewSelectedEkstra)
        val textViewEkstraIstek = findViewById<TextView>(R.id.textViewEkstraIstek)
        val textViewYeniSiparis = findViewById<TextView>(R.id.textViewYeniSiparis)
        val exit = findViewById<RelativeLayout>(R.id.exit)

        textViewOrderSelectTuzAci.text = "Bir $orderName Çorbası Çeeek, $orderTuz ve $orderAci Olsun"
        textViewSelectedEkstra.text = orderEkstra
        if (ekstraIstek != "") {
            textViewEkstraIstek.text = "Ekstra İstek: ${ekstraIstek}"
        }


        textViewYeniSiparis.setOnClickListener {
            val intent = Intent(this,OrderActivity::class.java)
            startActivity(intent)
            finish()
        }

        exit.setOnClickListener {

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.ic_baseline_close_24)
            alertDialog.create()

            alertDialog.setTitle("Çıkış")
            alertDialog.setMessage("Çıkmak istediğinize emin misiniz?")
            alertDialog.setPositiveButton(
                "Evet"
            ) { dialogInterface, i ->
                finishAffinity()
            }
            alertDialog.setNegativeButton(
                "Hayır"
            ) { dialogInterface, i ->

            }

            alertDialog.show()

        }



    }
}