package com.example.rollit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            RollItScreen()   // این هنوز وجود ندارد، مرحله بعد می‌سازیمش
        }


    }
}

@Composable
fun RollItScreen() {
    val context = LocalContext.current
    var diceImages by remember { mutableIntStateOf(R.drawable.dice_1) }
    var showBtnVisible by remember { mutableStateOf(false) }
    var isShaking by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = diceImages),
            contentDescription = "Dice Image",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))


        Button(
            onClick = {
                isShaking = true
                val roll = (1..6).random()
                val drawable = when (roll) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }
                diceImages = drawable

                if (drawable == R.drawable.dice_6) {
                    showBtnVisible = true
                    Toast.makeText(context, "YAY!! Let's See The Prize", Toast.LENGTH_SHORT)
                        .show()
                }
                isShaking = false
            },
            enabled = !isShaking && !showBtnVisible
        ) {
            Text("Roll It")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier.height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            if (showBtnVisible) {
                Button(
                    onClick = {
                        diceImages = R.drawable.fuckgorilla
                        showBtnVisible = false
                    },
                ) { Text("Show") }
            }
        }
    }
}