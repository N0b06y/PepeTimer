package com.example.pepetimer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var timer: CountDownTimer
    private lateinit var timerButton: Button
    private lateinit var timerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerButton = findViewById(R.id.timerButton)
        timerTextView = findViewById(R.id.timerTextView)

        timerButton.setOnClickListener {
            startTimer()
        }
    }

    private fun startTimer() {
        timer = object : CountDownTimer(60000, 1000) { // 60 seconds, tick every 1 second
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                timerTextView.text = "Seconds remaining: $seconds"
            }

            override fun onFinish() {
                timerTextView.text = "Timer finished!"
            }
        }

        timer.start()
    }
}
