package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var btnmi : Button
    private lateinit var btntk : Button
    private lateinit var btngaleri : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnmi = findViewById(R.id.btnmi)
        btntk = findViewById(R.id.btntekom)
        btngaleri = findViewById(R.id.btngaleri)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnmi.setOnClickListener{
            val intent = Intent(this@MainActivity, ManajemenInformatika::class.java)
            startActivity(intent)
        }

        btntk.setOnClickListener{
            val intent = Intent(this@MainActivity, TeknikKomputer::class.java)
            startActivity(intent)
        }

        btngaleri.setOnClickListener{
            val intent = Intent(this@MainActivity, GaleriPhoto::class.java)
            startActivity(intent)
        }
    }
}