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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.black
import com.example.lab2.ui.theme.gray
import com.example.lab2.ui.theme.orange
import com.example.lab2.ui.theme.white

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Body2()
            }
        }
    }
}

@Composable
fun Body2(){
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(black)
    ) {
        Main2()
    }
}

@Composable
fun Main2(){
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 59.dp)
    ) {
        TextButton(
            onClick = {
                context.startActivity(Intent(context, Login ::class.java))
            },
            modifier = Modifier
                .background(white, shape = RoundedCornerShape(20.dp))
                .align(Alignment.End)
                .padding(horizontal = 15.dp)

        ) {
            Text(
                text = "Skip",
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontWeight = FontWeight(800),
                fontSize = 16.sp,
                lineHeight = 17.sp,
                color = Black
            )

        }

        Text(
            text = "Well done !",
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight(800),
            fontSize = 36.sp,
            lineHeight = 34.sp,
            color = white,
            modifier = Modifier
                .width(250.dp)
                .padding(horizontal = 24.dp, vertical = 10.dp)

        )

        Text(
            text = "Your account is ready, we only need a little bit more informations to help you have a better experience",
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            lineHeight = 16.sp,
            color = gray,
            style = TextStyle(textAlign = TextAlign.Left),
            modifier = Modifier
                .width(300.dp)
                .padding(horizontal = 24.dp, vertical = 10.dp)

        )

        TextField(
            value = email,
            onValueChange = {it: String -> email = it},
            placeholder = {Text(text = "Your city") },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.map),
                    contentDescription = "",
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 10.dp)
//                .background(white, shape = RoundedCornerShape(15.dp))
        )

        TextField(
            value = email,
            onValueChange = {it: String -> email = it},
            placeholder = {Text(text = "Your state") },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.state),
                    contentDescription = "",
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 10.dp)
//                .background(white, shape = RoundedCornerShape(15.dp))
        )

        TextField(
            value = email,
            onValueChange = {it: String -> email = it},
            placeholder = {Text(text = "Your address") },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.address),
                    contentDescription = "",
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 10.dp)
//                .background(white, shape = RoundedCornerShape(15.dp))
        )

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
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
fun GreetingPreview2() {
    Lab2Theme {
        Body2()
    }
}