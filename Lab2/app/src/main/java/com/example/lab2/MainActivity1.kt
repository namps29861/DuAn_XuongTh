package com.example.lab2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.black
import com.example.lab2.ui.theme.gray
import com.example.lab2.ui.theme.orange
import com.example.lab2.ui.theme.white


class MainActivity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Body1()
            }
        }
    }
}
@Composable
fun Body1(){
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(black),

    ){
        Main1()
    }
}
@Composable
fun Main1() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = white)) {
                    append("Welcome to ")

                }
                withStyle(style = SpanStyle(color = orange)) {
                    append("Orangic")
                }
            },
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight(400),
            fontSize = 35.sp,
            lineHeight = 38.sp,
            modifier = Modifier
                .size(width = 200.dp, height = 80.dp)
                .padding(top = 5.dp, start = 30.dp)
        )
        Text(
            text = "Your favourite foods delivered fast at your door",
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            lineHeight = 16.sp,
            color = gray,
            style = TextStyle(textAlign = TextAlign.Left),
            modifier = Modifier
                .width(300.dp)
                .padding(horizontal = 24.dp, vertical = 10.dp,)



        )
        Image(
            painterResource(id = R.drawable.img_2), contentDescription = "",
                modifier = Modifier
                    .size(width = 312.dp, height = 312.dp)
                    .padding(horizontal = 24.dp, vertical = 20.dp)
                    .align(Alignment.CenterHorizontally)
            )
        Text(text = "What are you waiting for ?",
            fontSize = 22.sp,
            color = white,
            lineHeight = 19.sp,
            fontFamily = FontFamily(Font(R.font.roboto)),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(text = "Explore a world of culinary delights – place your order now and discover a variety of tempting dishes waiting just for you!",
                fontSize = 19.sp,
                fontFamily = FontFamily(Font(R.font.roboto)),
                color = gray,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top=10.dp, start = 30.dp)
            )
        TextButton(
            onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
                .padding(horizontal = 24.dp, vertical = 10.dp)
                .background(orange, shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Let's go",
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(800),
                fontSize = 16.sp,
                lineHeight = 17.sp,
                color = white
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    Lab2Theme {
        Body1()
    }
}