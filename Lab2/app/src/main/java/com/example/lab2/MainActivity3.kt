package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.assignment.model.Product
import com.example.assignment2.helper.RetrofitAPI
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.black
import com.example.lab2.ui.theme.orange


class MainActivity3 {




@Composable
fun RenderProduct(product: Product, goToScreen: (String) -> Unit) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(product.images?.get(0))
            .size(Size.ORIGINAL)
            .build()
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(horizontal = 24.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color.White)
            .border(
                width = 1.dp,
                color = Color(0XFF37474F),
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Column {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(136.dp)
                    .paint(
                        painter = painter,
                        contentScale = ContentScale.FillBounds
                    )

            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 13.dp, vertical = 10.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(100.dp)),
                ) {
                    Text(
                        text = "4.5",
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.icon_start),
                        contentDescription = "",
                        modifier = Modifier
                            .size(12.dp)
                    )

                    Text(
                        text = "100",
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.icon_favorite),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(horizontal = 13.dp, vertical = 10.dp)
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.25.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = product.name?:"",
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Image(
                        painterResource(id = R.drawable.icon_tich),
                        contentDescription = "",
                        modifier = Modifier
                            .size(10.dp)
                            .padding(start = 14.07.dp)

                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painterResource(id = R.drawable.icon_shipper),
                        contentDescription = "",
                        modifier = Modifier
                            .size(width = 16.16.dp, height = 11.43.dp)
                    )
                    Text(
                        text = "Free shipping",
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Image(
                        painterResource(id = R.drawable.icon_olock),
                        contentDescription = "",
                        modifier = Modifier
                            .size(12.dp)
                    )
                    Text(
                        text = "10-15 mins",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Button(
                        onClick = {
                                  goToScreen("detail/${product._id}")
                        },
                        modifier = Modifier
                            .clip(RectangleShape)
                            .padding(end = 2.dp),
                        colors = ButtonDefaults.buttonColors(Color(0XFFF6F6F6))

                    ) {
                        Text(
                            text = "Burger",
                            color = Color(0XFF8A8E9B)
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(RectangleShape)
                            .padding(end = 2.dp),
                        colors = ButtonDefaults.buttonColors(Color(0XFFF6F6F6))

                    ) {
                        Text(
                            text = "Chicken",
                            color = Color(0XFF8A8E9B)
                        )
                    }

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .clip(RectangleShape)
                            .padding(end = 2.dp),
                        colors = ButtonDefaults.buttonColors(Color(0XFFF6F6F6))

                    ) {
                        Text(
                            text = "Fast Food",
                            color = Color(0XFF8A8E9B)
                        )
                    }
                }
            }

        }
    }

    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun Header() {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        TextButton(
            onClick = { context.startActivity(Intent(context, MainActivity4::class.java)) },


        ){
            Image(
                painterResource(id = R.drawable.icon_back),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 24.dp)
            )
        }

        Text(
            text = "Featured Partner",
            fontWeight = FontWeight(800),
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            color = orange,
            lineHeight = 20.sp,
            modifier = Modifier.height(50.dp)
        )
    }
}

@Composable
fun Main3(goToScreen: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 44.dp)
    ) {
        Header()
        var listProduct by remember { mutableStateOf(listOf<com.example.assignment.model.Product>()) }

        fun getProduct() {
            try {
                val retrofitAPI = RetrofitAPI()
                val page = 1
                val limit = 20
                val keywords = ""
                retrofitAPI.getProducts(page, limit, keywords, callback =  { response ->
                    listProduct = response?.data ?: listOf()})
                Log.d(">>>>>>", "listProduct: ${listProduct}")
            } catch (e: Exception) {
                Log.d(">>>>>>", "Failed to register: ${e.message}")
            }
        }

        getProduct()

        LazyColumn {
            items(listProduct.size) { index ->
                RenderProduct(listProduct[index], goToScreen = goToScreen)
            }
        }
    }
}

@Composable
fun Body3(goToScreen:(String)->Unit) {
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(black)
    ) {
        Main3(goToScreen = goToScreen)
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        Body3(goToScreen = {})
    }
}
}