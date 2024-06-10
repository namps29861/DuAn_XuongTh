package com.example.lab2

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.assignment.model.Product_Id
import com.example.assignment2.helper.RetrofitAPI
import com.example.lab2.ui.theme.Lab2Theme
import com.example.lab2.ui.theme.black
import com.example.lab2.ui.theme.orange


class MainActivity4 {


@Composable
fun Body4(value: String?){
    Box (
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(color = black)
    ) {
        Main4(value = value)
    }
}

@Composable
fun Main4(value: String?){
    var Product by remember { mutableStateOf(
        Product_Id(null, null, null,null, null, null, null, null, null, null)
    ) }

    fun getProductId() {
        try {
            val retrofitAPI = RetrofitAPI()
            retrofitAPI.getProductsId(value, callback =  { response ->
                if (response != null) {
                    Product = response.data
                }
            })
            Log.d(">>>>>>", "listProduct: ${Product}")
        } catch (e: Exception) {
            Log.d(">>>>>>", "Failed to register: ${e.message}")
        }
    }

    getProductId()

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(Product.images?.get(0))
            .size(Size.ORIGINAL)
            .build()
    )


    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 44.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .paint(
                    painter = painter,
                    contentScale = ContentScale.Fit
                )
                .height(213.dp)
                .fillMaxWidth()
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                )
                .padding(horizontal = 24.dp, vertical = 10.dp)

        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Color.Blue,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_back2),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                )
            }

            Box(
                modifier = Modifier
                    .background(
                        color = Color.Blue,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_favorite2),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                )
            }

        }

        Text(
            text = Product.name?:"",
            fontSize = 22.sp,
            fontWeight = FontWeight(800),
            lineHeight = 20.sp,
            color = Color(0xFFFF7400),
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 24.dp)
                .fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
        ) {
            Row {
                Image(
                    painterResource(id = R.drawable.icon_start),
                    contentDescription = "",
                    modifier = Modifier
                        .size(18.dp)
                )

                Text(
                    text = "4.5",
                    fontWeight = FontWeight(800),
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }

            Row {
                Image(
                    painterResource(id = R.drawable.icon_note),
                    contentDescription = "",
                    modifier = Modifier
                        .size(12.dp)
                )

                Text(
                    text = "80 items",
                    fontWeight = FontWeight(400),
                    fontSize = 10.sp,
                    lineHeight = 14.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.icon_start5),
            contentDescription = "",
            modifier = Modifier
                .size(width = 228.dp, height = 67.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box (
            modifier = Modifier
                .size(width = 323.dp, height = 168.dp)
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .border(
                    border = BorderStroke(1.dp, Color.LightGray)
                )
        ){

        }

        TextButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = 20.dp)
                .size(width = 338.dp, height = 48.dp)
                .background(color = orange, shape = RoundedCornerShape(10.dp))
            ) {
            Text(text = "SubmitSubmit")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Lab2Theme {
        Body4(value = "")
    }
}
}