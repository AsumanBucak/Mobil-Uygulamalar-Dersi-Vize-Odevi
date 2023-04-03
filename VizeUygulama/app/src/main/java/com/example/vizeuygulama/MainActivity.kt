package com.example.vizeuygulama

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var result = ""
    private var textName = "ASUMAN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textLength: Int = textName.length

        val layoutName = findViewById<View>(R.id.layoutName) as LinearLayout
        val layoutCheck = findViewById<View>(R.id.layoutCheck) as LinearLayout

        val progressBarLoading = findViewById<ProgressBar>(R.id.progressBarLoading)

        val textViewName: Array<TextView?> = arrayOfNulls(textLength)

        for (i in 0 until textLength) {
            textViewName[i] = TextView(this)
            textViewName[i]?.textSize = 45F
            textViewName[i]?.letterSpacing = 0.5F
            textViewName[i]?.setTextColor(Color.WHITE)
            textViewName[i]?.text = textName.substring(i, i + 1)
            val lpName: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            lpName.gravity = Gravity.CENTER
            layoutName.addView(textViewName[i], lpName)

            textViewName[i]?.setOnClickListener {

                if (result.length > textName.length - 2) {
                    progressBarLoading.visibility = View.VISIBLE
                    Handler(Looper.getMainLooper()).postDelayed(Runnable {
                        val intent = Intent(this,OrderActivity::class.java)
                        startActivity(intent)
                        finish()
                    }, 1000)
                }
                if (i == result.length) {
                    result += textViewName[i]?.text.toString()
                    if (textName.startsWith(result)) {
                        val imageCheck = ImageView(this)
                        imageCheck.layoutParams = LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                        )
                        imageCheck.setBackgroundResource(R.drawable.ic_check)
                        layoutCheck.addView(imageCheck)
                    }
                }
            }
        }


    }
}