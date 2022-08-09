package com.example.composetut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetut.ui.theme.ComposeTUTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                for(i in 1..6)
                {
                    Greeting(name = "pratik $i")
                }
                Button(
                    onClick = { /* ... */ },

                    contentPadding = PaddingValues(
                        start = 20.dp,
                        top = 12.dp,
                        end = 20.dp,
                        bottom = 12.dp
                    )
                ) {
                    // Inner content including an icon and a text label
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Like")
                }


                ExtendedFloatingActionButton(
                    onClick = { /* ... */ },
                    icon = {
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Favorite"
                        )
                    },
                    text = { Text("Like") }
                )

            }


        }
    }
}

@Composable
fun Greeting(name: String) {
    Row(modifier = Modifier
        .padding(10.dp),
        verticalAlignment =Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.crop), contentDescription ="pratik image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(2.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text=name,
            style = MaterialTheme.typography.h6


        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTUTTheme {
        Greeting("Android")
    }
}