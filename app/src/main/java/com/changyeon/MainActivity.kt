package com.changyeon

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.button)
        var edt : EditText = findViewById(R.id.eric)
        var asdfghjkl : Button = findViewById(R.id.tv)
        asdfghjkl.setOnClickListener {
            Toast.makeText(this,"도전성공!",Toast.LENGTH_SHORT).show()
        }
        btn.setOnClickListener {
            var str : String = edt.text.toString()
            if(str.equals("111116")){
                var intent: Intent =Intent(this,MainActivity3::class.java)
                startActivity(intent)
            }
            Toast.makeText(this,"펑!?!?!?!?!!!!",Toast.LENGTH_SHORT).show()
        }


        var four = findViewById<Button>(R.id.four_button)
        four.setOnClickListener {
            var intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }


        var sp = getPreferences(MODE_PRIVATE)
        var editor = sp.edit()
        var bicycle = findViewById<CheckBox>(R.id.bicycle)
        bicycle.isChecked = sp.getBoolean("bicycle",false)
        var autoBicycie = findViewById<CheckBox>(R.id.auto_bicycle)
        autoBicycie.isChecked = sp.getBoolean("autobicycie",false)
        var car =findViewById<CheckBox>(R.id.car)
        car.isChecked = sp.getBoolean("car",false)

        bicycle.setOnCheckedChangeListener { buttonView, isChecked ->
            editor.putBoolean("bicycle",isChecked)
            editor.commit()
        }
        autoBicycie.setOnCheckedChangeListener { buttonView, isChecked ->
            editor.putBoolean("autobicycie",isChecked)
            editor.commit()
        }
        car.setOnCheckedChangeListener { buttonView, isChecked ->
            editor.putBoolean("car",isChecked)
            editor.commit()
        }

        var raGroup = findViewById<RadioGroup>(R.id.group)
        var checkId = sp.getInt("group", R.id.r1)
        raGroup.check(checkId)
        raGroup.setOnCheckedChangeListener { group, checkedId ->
            editor.putInt("group",checkedId)
            editor.commit()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}