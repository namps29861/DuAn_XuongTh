package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.core.content.ContextCompat
import com.example.assignment2.helper.RetrofitAPI
import com.example.assignment2.httpmodels.LoginRequesModel
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.black
import com.example.lab2.ui.theme.orange

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                login()
            }
        }
    }


    @Composable
    fun login() {
        //background
        Box(

            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            MainLogin()
        }
    }

    @Composable
    fun MainLogin() {
        val context = LocalContext.current;

        var email = remember { mutableStateOf("vana350@gmail.com") }
        var password = remember { mutableStateOf("123456") }

        Column(modifier = Modifier.padding(vertical = 15.dp)) {
            Text(
                text = "Well hello",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 36.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Text(
                text = "there !",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.roboto)),
                fontSize = 36.sp,
                color = Color.White,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Enter your Email and Password to login, or.",
                    fontFamily = FontFamily(Font(R.font.roboto)),
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
                Row {
                    Text(
                        text = "Create new account",
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = ".",
                        fontFamily = FontFamily(Font(R.font.roboto)),
                        fontSize = 14.sp,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .height(45.dp)

                ) {
                    OutlinedTextField(
                        value = email.value,
                        onValueChange = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(15.dp)
                            ),
                        shape = RoundedCornerShape(15.dp),
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.email),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 10.sp,
                            color = black
                        )
                    )

                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .height(45.dp)

                ) {
                    OutlinedTextField(
                        value = password.value,
                        onValueChange = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(45.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(15.dp)
                            ),
                        shape = RoundedCornerShape(15.dp),
                        singleLine = true,
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.key),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        textStyle = TextStyle(
                            fontSize = 10.sp,
                            color = black
                        )
                    )

                }
            }
            TextButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 20.dp),
                onClick = { /*TODO*/ }) {
                Text(text = "Forgot Password ? " ,color = Color.Blue, fontSize = 12.sp,  fontFamily = FontFamily(Font(R.font.roboto)),)
            }

            fun onClickLogin() {
                try {
                    val retrofitAPI = RetrofitAPI()
                    val body = LoginRequesModel(
                        email = email.value,
                        password = password.value
                    )
                    retrofitAPI.login(body = body, callback = {})
                    context.startActivity(Intent(context, Bottom_Tab::class.java))
                } catch (e: Exception) {
                    Log.d(">>>>>>", "Failed to login: ${e.message}")
                }
            }


            TextButton(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.CenterHorizontally)
                    .width(315.dp)
                    .height(50.dp)
                    .background(
                        orange, shape = MaterialTheme.shapes.small
                    ),
                onClick = {
                    onClickLogin()
                }) {
                Text(text = "Sign In", color = Color.White, fontSize = 18.sp)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Lab2Theme {
            login()
        }

    }
}