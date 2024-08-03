package com.changyeon

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    lateinit var handler: Handler
    lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        handler = Handler(Looper.getMainLooper())
        var second = 0
        var checkCount = findViewById<Button>(R.id.button2)
        runnable = object : Runnable {
            override fun run() {
                if (second<100){
                    second++
                }

                Log.e("what second", second.toString())
                findViewById<TextView>(R.id.textView2).setText("${second}%")
                findViewById<ProgressBar>(R.id.khkhkhkugy).progress = second
                handler.postDelayed(this, 1000)
                checkCount.setOnClickListener {
                    if (checkCount.text == "시작") {
                        handler.postDelayed(runnable, 1000)
                        checkCount.text = ("정지")
                    } else {
                        handler.removeCallbacks(runnable)
                        checkCount.text = "시작"
                    }
                }
                checkCount.setOnClickListener {
                    if (checkCount.text == "시작") {
                        handler.postDelayed(runnable, 1000)
                        checkCount.text = ("정지")
                    } else {
                        handler.removeCallbacks(runnable)
                        checkCount.text = "시작"
                    }
                }
            }

        }
        handler.postDelayed(runnable, 1000)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
        Toast.makeText(this, "ahnym stupid", Toast.LENGTH_SHORT).show()
    }
}