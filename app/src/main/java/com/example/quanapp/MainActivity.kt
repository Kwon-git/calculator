package com.example.quanapp

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), OnClickListener {
     var x:Int? = null
     var y:Int? = null
     var z:Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        for (i in 0..9) {
            val buttonId = resources.getIdentifier("button$i", "id", packageName)
            val button: Button = findViewById(buttonId)
            button.setOnClickListener(this)
        }
        val btnplus: TextView = findViewById(R.id.plus)
        btnplus.setOnClickListener(this)

        val btnminus: TextView = findViewById(R.id.minus)
        btnminus.setOnClickListener(this)

        val btnmulti: TextView = findViewById(R.id.multi)
        btnmulti.setOnClickListener(this)

        val btndivide: TextView = findViewById(R.id.divide)
        btndivide.setOnClickListener(this)

        val btnc: TextView = findViewById(R.id.buttonc)
        btnc.setOnClickListener(this)

        val btnce: TextView = findViewById(R.id.buttonce)
        btnce.setOnClickListener(this)

        val btnxx: TextView = findViewById(R.id.buttonxx)
        btnxx.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        if(x!=null){
            if(v?.id==R.id.plus) z=1
            else if (v?.id==R.id.minus) z=2
            else if (v?.id==R.id.multi) z=3
            else if(v?.id==R.id.divide) z=4
        }
        else if(x==null){
            for (i in 0..9) {
                val buttonId = resources.getIdentifier("button$i", "id", packageName)
                if(v?.id==buttonId){
                    x = (x?.times(10) ?: 0) +i
                    break
                }
            }
        }

    }
}