package com.example.loltimer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.top_lane)
        button.setOnClickListener {
            setTopTimer()
        }
    }

    private fun setTopTimer() {
        val but: Button = findViewById(R.id.top_lane)
        but.isClickable = false
        val myText: TextView = findViewById(R.id.top_lane)
        val asd = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = millisUntilFinished / 1000 % 60
                val timerText = if (minutes == 0L) {
                    "$seconds sec"
                } else {
                    val secondsText: String = if ("$seconds".length == 1) "0$seconds" else "$seconds"
                    "$minutes:$secondsText"
                }
                myText.text = "Top flash CD: $timerText"
            }

            override fun onFinish() {
                myText.text = "Top Flash ready!"
                but.isClickable = true
            }
        }
        asd.start()
    }
}

