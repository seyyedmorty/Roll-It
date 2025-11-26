package com.example.rollit

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var rollButton: Button
    lateinit var showButton: Button
    lateinit var diceFaces: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rollButton = findViewById(R.id.roll_btn)
        diceFaces = findViewById(R.id.dice_face)
        showButton = findViewById(R.id.show_button)


        rollButton.setOnClickListener {
            val rollNumber = Random.nextInt(1, 7)
            val shake = AnimationUtils.loadAnimation(this, R.anim.shake)
            val fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade_in)
            diceFaces.startAnimation(shake)
            val drawableResource = when (rollNumber) {
                1 ->
                    R.drawable.dice_1

                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> {
                    R.drawable.dice_6
                }
            }
            if(drawableResource == R.drawable.dice_6){
                showButton.visibility = View.VISIBLE
                showButton.startAnimation(fadeIn)
                Toast.makeText(this,"YAY!! Let's see the PRIZE!", Toast.LENGTH_SHORT).show()
            }
            showButton.setOnClickListener {
                diceFaces.setImageResource(R.drawable.fuckgorilla)
            }
            diceFaces.setImageResource(drawableResource)
        }

    }
}