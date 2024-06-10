package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.helper.RetrofitAPI
import com.example.assignment2.httpmodels.RegisterRequesModel
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.black
import com.example.lab2.ui.theme.gray
import com.example.lab2.ui.theme.orange
import com.example.lab2.ui.theme.white

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Body()
            }
        }
    }
}

@Composable
fun Body(){
    Box (
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(black)
    ){
        Main()
    }
}

@Composable
fun Main(){
    val context = LocalContext.current

    var name = remember { mutableStateOf("Nguyễn Văn A") }
    var email = remember { mutableStateOf("vana350@gmail.com") }
    var password = remember { mutableStateOf("123456") }
    var confirmpassword = remember { mutableStateOf("123456") }
    var phonenumber = remember { mutableStateOf("0123456789") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 59.dp)
    ) {
        Text(
            text = "Create Account",
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight(800),
            fontSize = 36.sp,
            lineHeight = 34.sp,
            color = white,
            modifier = Modifier
                .width(200.dp)
                .padding(horizontal = 24.dp)

        )

        Text(
            text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = gray)){
                append("Enter your Email and Password to sign up. ")

            }
            withStyle(style = SpanStyle(color = orange)){
                append("Already have an account?.")
            }
            },
            fontFamily = FontFamily(Font(R.font.roboto)),
            fontWeight = FontWeight(400),
            fontSize = 14.sp,
            lineHeight = 16.sp,
            modifier = Modifier
                .size(width = 260.dp, height = 43.dp)
                .padding(top = 9.dp, start = 24.dp)
        )

        Image(
            painterResource(id = R.drawable.img),
            contentDescription = "",
            modifier = Modifier
                .size(width = 312.dp, height = 120.dp)
                .padding(horizontal = 24.dp, vertical = 20.dp)
                .align(Alignment.CenterHorizontally)
        )

        TextField(
            value = name.value,
            onValueChange = {it: String -> name.value = it},
            placeholder = {Text(text = "Your name") },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.person),
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
            value = email.value,
            onValueChange = {it: String -> email.value = it},
            placeholder = {Text(text = "Email") },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.email),
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
            value = password.value,
            onValueChange = {it: String -> password.value = it},
            placeholder = {Text(text = "Password") },
            trailingIcon = {
                Icon(
                    painterResource(id = R.drawable.key),
                    contentDescription = "",
                )
            },
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 10.dp)
//                .background(white, shape = RoundedCornerShape(15.dp))
        )

        fun onClickRegister() {
            try {
                val retrofitAPI = RetrofitAPI()
                val body = RegisterRequesModel(
                    //username, email, phoneNumber, password, confirm
                    username = name.value, email = email.value,
                    phoneNumber = phonenumber.value,
                    password = password.value,
                    confirm = confirmpassword.value,
                )
                retrofitAPI.register(body = body, callback = { })
                context.startActivity(Intent(context, MainActivity2::class.java))
            } catch (e: Exception) {
                Log.d(">>>>>>", "Failed to register: ${e.message}")
            }
        }

        TextButton(
            onClick = {
                      onClickRegister()
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 10.dp)
                .background(orange, shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Sign Up",
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
fun GreetingPreview() {
    Lab2Theme {
        Body()
    }
}