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
     var x = 0
     var y = 0
     var op = 0
     var tt = 1
     var ok = 0
    lateinit var view1: TextView
    lateinit var view2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        view1 = findViewById<TextView>(R.id.view1)
        view2 = findViewById<TextView>(R.id.view2)
        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)

        findViewById<Button>(R.id.plus).setOnClickListener(this)
        findViewById<Button>(R.id.minus).setOnClickListener(this)
        findViewById<Button>(R.id.multi).setOnClickListener(this)
        findViewById<Button>(R.id.divide).setOnClickListener(this)
        findViewById<Button>(R.id.equal).setOnClickListener(this)

        findViewById<Button>(R.id.equal).setOnClickListener(this)

        findViewById<Button>(R.id.buttonxx).setOnClickListener(this)
        findViewById<Button>(R.id.buttonc).setOnClickListener(this)
        findViewById<Button>(R.id.buttonce).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button0 -> setth(tt,0)
            R.id.button1 -> setth(tt,1)
            R.id.button2 -> setth(tt,2)
            R.id.button3 -> setth(tt,3)
            R.id.button4 -> setth(tt,4)
            R.id.button5 -> setth(tt,5)
            R.id.button6 -> setth(tt,6)
            R.id.button7 -> setth(tt,7)
            R.id.button8 -> setth(tt,8)
            R.id.button9 -> setth(tt,9)

            R.id.plus -> setop(1)
            R.id.minus -> setop(2)
            R.id.multi -> setop(3)
            R.id.divide -> setop(4)
            R.id.equal ->{
                var res = 0
                if(tt==2){
                    if(op==1){ res = x + y; view1.text = res.toString()}
                    if(op==2){ res = x - y; view1.text = res.toString()}
                    if(op==3){ res = x * y; view1.text = res.toString()}
                    if(op==4 && y!=0){ res = x / y; view1.text = res.toString()}
                    var tmp: String = view2.text.toString() + y.toString()
                    view2.text = tmp
                    tt=1
                    y = 0
                    x = res
                    ok = 1
                }
                else{
                    view1.setText(x.toString())
                }
            }

            R.id.buttonxx ->{
                if(tt == 1){
                    x = x/10
                    view1.text = x.toString()
                }
                else{
                    y = y/10
                    view1.text = y.toString()
                }
            }

            R.id.buttonc -> {
                x = 0
                y = 0
                tt = 1
                view1.text="0"
                view2.text=""
            }

            R.id.buttonce -> {
                if(tt == 1){
                    x = 0
                    view1.text = x.toString()
                    ok = 0
                }
                else{
                    y = 0
                    view1.text = y.toString()
                }
            }
        }

    }

    fun setth(trangthai : Int,num:Int){
        if(ok==1 && tt==1){ x = 0; view2.text=""}
        if(trangthai == 1){
            ok = 0
            x = x*10+ num
            view1.text = x.toString()
        }
        else{
            y = y*10 + num
            view1.text = y.toString()
        }
    }

    fun setop(num:Int){
        op = num
        tt=2
        var dau: String = ""
        when(op){
            1 -> dau = " + "
            2 -> dau = " - "
            3 -> dau = " x "
            4 -> dau =" / "
        }
        view1.text = "0"
        view2.text = x.toString() + dau
    }
}