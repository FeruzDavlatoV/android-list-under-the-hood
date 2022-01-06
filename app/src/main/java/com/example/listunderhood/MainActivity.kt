package com.example.listunderhood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayout:LinearLayout
    private lateinit var laptops:ArrayList<Laptop>
    private lateinit var loadbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        laptops = ArrayList()

        for (i in 0..9){
            laptops.add(Laptop(R.drawable.im_laptop2,"Acer Laptop",
                "Acer Aspire is a Windows 10 laptop with a 15.60-inch display that has a " +
                        "resolution of 1920x1080 pixels. It is powered by a Core i7 processor and it " +
                        "comes with 8GB of RAM. The Acer Aspire packs 1TB of HDD storage. Graphics are" +
                        " powered by Intel HD Graphics 620."))
        }

        initViews()


    }

    private fun initViews() {

        linearLayout = findViewById(R.id.container_root)
        loadbtn = findViewById(R.id.btn_load)

        loadbtn.setOnClickListener {
            for (laptop in laptops) {
                linearLayout.addView(addItem(laptop))
            }
        }



    }
    private fun addItem(laptop: Laptop):LinearLayout{
        val tempLinearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(50,50,50,50)
            background = getDrawable(R.drawable.rounder_backround)
            layoutParams = params
        }

        val imageView = ImageView(this)
        imageView.apply {
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,350)
            setImageResource(laptop.image)
            layoutParams = params
        }

        val titleTextView = TextView(this).apply {
            text = laptop.title
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(50,50,50,50)
            textSize = 22f
            layoutParams = params

        }

        val descriptionTextView = TextView(this).apply {
            text = laptop.description
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(50,50,50,50)
            textSize = 15f
            layoutParams = params
        }

        tempLinearLayout.addView(imageView)
        tempLinearLayout.addView(titleTextView)
        tempLinearLayout.addView(descriptionTextView)

        return tempLinearLayout
    }
}