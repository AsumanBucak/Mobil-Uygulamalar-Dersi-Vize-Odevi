package com.example.vizeuygulama

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.slider.Slider


class OrderResultActivity : AppCompatActivity(){

    lateinit var switchSarimsak: SwitchCompat
    lateinit var switchNane: SwitchCompat
    lateinit var switchDil: SwitchCompat
    lateinit var switchTerbiye: SwitchCompat
    lateinit var switchBeyin: SwitchCompat
    lateinit var switchSirke: SwitchCompat
    lateinit var switchKrema: SwitchCompat
    lateinit var switchYag: SwitchCompat
    lateinit var switchKasar: SwitchCompat
    lateinit var switchKitir: SwitchCompat
    lateinit var switchLimon: SwitchCompat
    lateinit var switchTozBiber: SwitchCompat
    lateinit var buttonSiparis: Button
    lateinit var textViewResultEkstra: TextView
    lateinit var editTextEkstra: EditText

    var orderTuz = "Tuzsuz"
    var orderAci = "Acısız"

    var selectedEkstra = ""

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_result)

        val orderName = intent.getStringExtra("selectOrder")
        val orderId = intent.getIntExtra("orderId", 0)

        val sliderTuz = findViewById<Slider>(R.id.sliderTuz)
        val sliderAci = findViewById<Slider>(R.id.sliderAci)

        switchSarimsak = findViewById<SwitchCompat>(R.id.switchSarimsak)
        switchNane = findViewById<SwitchCompat>(R.id.switchNane)
        switchDil = findViewById<SwitchCompat>(R.id.switchDil)
        switchTerbiye = findViewById<SwitchCompat>(R.id.switchTerbiye)
        switchBeyin = findViewById<SwitchCompat>(R.id.switchBeyin)
        switchSirke = findViewById<SwitchCompat>(R.id.switchSirke)
        switchKrema = findViewById<SwitchCompat>(R.id.switchKrema)
        switchYag = findViewById<SwitchCompat>(R.id.switchYag)
        switchKasar = findViewById<SwitchCompat>(R.id.switchKasar)
        switchKitir = findViewById<SwitchCompat>(R.id.switchKitir)
        switchLimon = findViewById<SwitchCompat>(R.id.switchLimon)
        switchTozBiber = findViewById<SwitchCompat>(R.id.switchTozBiber)
        buttonSiparis = findViewById(R.id.buttonSiparis)
        textViewResultEkstra = findViewById(R.id.textViewResultEkstra)
        editTextEkstra = findViewById(R.id.editTextEkstra)


        val textViewOrderName = findViewById<TextView>(R.id.textViewOrderName)

        textViewOrderName.text = orderName + " Çorbası"


        sliderTuz.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
            if (value == 6F) {
                orderTuz = "Bol Tuzlu"
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setIcon(R.drawable.ic_launcher_background)
                alertDialog.create()

                alertDialog.setTitle("Uyarı!")
                alertDialog.setMessage("Bu kadar tuz istediğinize emin misiniz?")
                alertDialog.setPositiveButton(
                    "Evet"
                ) { dialogInterface, i ->

                }
                alertDialog.setNegativeButton(
                    "Hayır"
                ) { dialogInterface, i ->
                    slider.value = 3F
                }

                alertDialog.show()
            } else if (value == 3F) {
                orderTuz = "Orta Tuzlu"
            } else {
                orderTuz = "Tuzsuz"
            }
            println("orderTuz---"+ orderTuz)
        })

        sliderAci.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
            if (value == 6F) {
                orderAci = "Bol Acılı"
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setIcon(R.drawable.asulogo)
                alertDialog.create()

                alertDialog.setTitle("Uyarı!")
                alertDialog.setMessage("Bu kadar Acı istediğinize emin misiniz?")
                alertDialog.setPositiveButton(
                    "Evet"
                ) { dialogInterface, i ->

                }
                alertDialog.setNegativeButton(
                    "Hayır"
                ) { dialogInterface, i ->
                    sliderAci.value = 3F
                }

                alertDialog.show()
            } else if (value == 3F) {
                orderAci = "Orta Acılı"
            } else {
                orderAci = "Acısız"
            }

        })




        buttonSiparis.setOnClickListener {

            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setIcon(R.drawable.asulogo)
            alertDialog.create()

            alertDialog.setTitle("Siparişinizin Durumu!")
            alertDialog.setMessage("Siparişiniz Hazırlanacak. Devam Etmek İstiyor musunuz?")
            alertDialog.setPositiveButton(
                "Evet"
            ) { dialogInterface, i ->
                if (switchSarimsak.isChecked) {
                    selectedEkstra += switchSarimsak.text.toString() + ","
                }
                if (switchNane.isChecked) {
                    selectedEkstra += switchNane.text.toString() + ","
                }
                if (switchDil.isChecked) {
                    selectedEkstra += switchDil.text.toString() + ","
                }
                if (switchTerbiye.isChecked) {
                    selectedEkstra += switchTerbiye.text.toString() + ","
                }
                if (switchBeyin.isChecked) {
                    selectedEkstra += switchBeyin.text.toString() + ","
                }
                if (switchSirke.isChecked) {
                    selectedEkstra += switchSirke.text.toString() + ","
                }
                if (switchKrema.isChecked) {
                    selectedEkstra += switchKrema.text.toString() + ","
                }
                if (switchYag.isChecked) {
                    selectedEkstra += switchYag.text.toString() + ","
                }
                if (switchKasar.isChecked) {
                    selectedEkstra += switchKasar.text.toString() + ","
                }
                if (switchKitir.isChecked) {
                    selectedEkstra += switchKitir.text.toString() + ","
                }
                if (switchLimon.isChecked) {
                    selectedEkstra += switchLimon.text.toString() + ","
                }
                if (switchTozBiber.isChecked) {
                    selectedEkstra += switchTozBiber.text.toString() + ","
                }

                println("Switch---"+ selectedEkstra)
                val intent = Intent(this,OrderShowActivity::class.java)
                intent.putExtra("orderName",orderName)
                intent.putExtra("orderEkstra",selectedEkstra)
                intent.putExtra("orderTuz",orderTuz)
                intent.putExtra("orderAci",orderAci)
                intent.putExtra("ekstraIstek",editTextEkstra.text.toString())
                startActivity(intent)
                finish()
            }
            alertDialog.setNegativeButton(
                "Tekrar kontrol etmek istiyorum"
            ) { dialogInterface, i ->

            }

            alertDialog.show()


        }

        println("order id---" + orderId)
        if (orderId == 0) {
            getVisibleSwitch(
                nane = true,
                yag = true,
                kitir = true,
                limon = true,
                tozBiber = true
            )
        } else if (orderId == 1) {
            getVisibleSwitch(nane = true, yag = true, kitir = true, limon = true, tozBiber = true)

        } else if (orderId == 2) {
            getVisibleSwitch(nane = true, yag = true, kitir = true, limon = true, tozBiber = true)
        } else if (orderId == 3) {
            getVisibleSwitch(krema = true)
        } else if (orderId == 4) {
            getVisibleSwitch(sarimsak = true, dil = true, beyin = true, sirke = true, yag = true, limon = true)
        } else if (orderId == 5) {
            getVisibleSwitch(nane = true, yag = true, kitir = true, tozBiber = true)
        } else if (orderId == 6) {
            getVisibleSwitch(nane = true, terbiye = true, yag = true, kasar = true, kitir = true, limon = true, tozBiber = true)
        } else if (orderId == 7) {
            getVisibleSwitch(yag = true, tozBiber = true)
        } else if (orderId == 8) {
            getVisibleSwitch(sarimsak = true, sirke = true, yag = true, limon = true, tozBiber = true)
        } else if (orderId == 9) {
            getVisibleSwitch(krema = true, yag = true, limon = true)
        }
    }

    @Suppress("SameParameterValue")
    private fun getVisibleSwitch(
        sarimsak: Boolean = false,
        nane: Boolean = false,
        dil: Boolean = false,
        terbiye: Boolean = false,
        beyin: Boolean = false,
        sirke: Boolean = false,
        krema: Boolean = false,
        yag: Boolean = false,
        kasar: Boolean = false,
        kitir: Boolean = false,
        limon: Boolean = false,
        tozBiber: Boolean = false
    ) {
        if (sarimsak) {
            switchSarimsak.visibility = View.VISIBLE
        }
        if (nane) {
            switchNane.visibility = View.VISIBLE
        }
        if (dil) {
            switchDil.visibility = View.VISIBLE
        }
        if (terbiye) {
            switchTerbiye.visibility = View.VISIBLE
        }
        if (beyin) {
            switchBeyin.visibility = View.VISIBLE
        }
        if (sirke) {
            switchSirke.visibility = View.VISIBLE
        }
        if (krema) {
            switchKrema.visibility = View.VISIBLE
        }
        if (yag) {
            switchYag.visibility = View.VISIBLE
        }
        if (kasar) {
            switchKasar.visibility = View.VISIBLE
        }
        if (kitir) {
            switchKitir.visibility = View.VISIBLE
        }
        if (limon) {
            switchLimon.visibility = View.VISIBLE
        }
        if (tozBiber) {
            switchTozBiber.visibility = View.VISIBLE
        }
    }

}