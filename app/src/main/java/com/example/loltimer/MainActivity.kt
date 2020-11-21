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

        val topButton: Button = findViewById(R.id.top_lane)
        val jungleButton: Button = findViewById(R.id.jungle)
        val midButton: Button = findViewById(R.id.mid_lane)
        val botButton: Button = findViewById(R.id.bot_lane)
        val supButton: Button = findViewById(R.id.sup_lane)

        topButton.setOnClickListener {
            setTopTimer("Top")
        }
        jungleButton.setOnClickListener {
            setTopTimer("Jungle")
        }
        midButton.setOnClickListener {
            setTopTimer("Mid")
        }
        botButton.setOnClickListener {
            setTopTimer("Bot")
        }
        supButton.setOnClickListener {
            setTopTimer("Support")
        }
    }

    private fun setTopTimer(role: String) {

        val but: Button = when (role) {
            "Top" -> findViewById(R.id.top_lane)
            "Jungle" -> findViewById(R.id.jungle)
            "Mid" -> findViewById(R.id.mid_lane)
            "Bot" -> findViewById(R.id.bot_lane)
            "Support" -> findViewById(R.id.sup_lane)
            else -> findViewById(R.id.top_lane)
        }
        but.isClickable = false
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
                but.text = "$role flash CD: $timerText"
            }

            override fun onFinish() {
                but.text = "$role Flash ready"
                but.isClickable = true
            }
        }
        asd.start()
    }
}

