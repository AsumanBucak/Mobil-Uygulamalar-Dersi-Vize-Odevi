package com.example.vizeuygulama

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty


class OrderActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val radioGroup = findViewById<View>(R.id.radioGroup) as RadioGroup
        val checkboxShow = findViewById<View>(R.id.checkboxShow) as CheckBox
        val layoutOrder = findViewById<View>(R.id.layoutOrder) as LinearLayout
        val buttonContinue = findViewById<View>(R.id.buttonContinue) as Button

        val orderArray = resources.getStringArray(R.array.corba_list)

        checkboxShow.setOnCheckedChangeListener { compoundButton, isShow ->

            if (isShow) {
                layoutOrder.visibility = View.VISIBLE
                buttonContinue.visibility = View.VISIBLE
            } else {
                layoutOrder.visibility = View.GONE
                buttonContinue.visibility = View.GONE
            }

        }

        for (i in orderArray.indices) {
            val radioButton = RadioButton(this)
            radioButton.text = orderArray[i]
            radioButton.id = i
            radioButton.setTextColor(Color.WHITE)
            radioButton.buttonTintList = ColorStateList.valueOf(Color.WHITE)
            radioGroup.addView(radioButton)
        }

        buttonContinue.setOnClickListener {
            if (radioGroup.checkedRadioButtonId == -1) {
                println("uyarii")
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setIcon(R.drawable.ic_baseline_close_24)
                alertDialog.create()

                alertDialog.setTitle("Uyarı!")
                alertDialog.setMessage("Lütfen seçiminizi yapınız")
                alertDialog.setPositiveButton(
                    "Tekrar Dene"
                ) { dialogInterface, i ->

                }

                alertDialog.show()
            }
        }



        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            val radioBtn: RadioButton = findViewById<View>(checkedRadioButtonId) as RadioButton

            buttonContinue.setOnClickListener {

                val inflater = layoutInflater
                val layout: View =
                    inflater.inflate(
                        R.layout.wait_layout,
                        findViewById(R.id.custom_toast_container)
                    )
                val text = layout.findViewById<TextView>(R.id.textViewLoading)
                text.text = radioBtn.text.toString() + " Çorbası Güzel seçim lütfen bekleyiniz"

                val toast = Toast(applicationContext)
                toast.setGravity(Gravity.BOTTOM, 0, 120)
                toast.duration = Toast.LENGTH_SHORT
                toast.view = layout
                toast.show()
                Handler(Looper.getMainLooper()).postDelayed(Runnable {
                    val intent = Intent(this, OrderResultActivity::class.java)
                    intent.putExtra("selectOrder", radioBtn.text.toString())
                    intent.putExtra("orderId", checkedId)
                    startActivity(intent)
                    finish()
                }, 2000)


            }

        }

    }
}