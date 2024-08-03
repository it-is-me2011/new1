package com.changyeon

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        var videoView = findViewById<VideoView>(R.id.videov)
        var videostart : Button = findViewById(R.id.videostart)
        var uri = Uri.parse("android.resource://${packageName}/raw/dance_t")
        videoView.setVideoURI(uri)
        videostart.setOnClickListener {
            if (videoView.isPlaying){
                videostart.text = "시작"
                videoView.pause()
            } else{
                videostart.text = "정지"
                videoView.start()
            }

        }









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }
    }
}