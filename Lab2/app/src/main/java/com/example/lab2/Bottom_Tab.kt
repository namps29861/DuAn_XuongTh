package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab2.ui.theme.Lab2Theme

class Bottom_Tab : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Body5()
            }
        }
    }
}

@Composable
fun Body5(){


    val Home = MainActivity3()
    val ProductDetailActivity = MainActivity4()





    //khai bao bien de chuyen giua cac man hinh
    val navController = rememberNavController()
    //ham chuyen man hinh
    fun gotoScreen(screen: String) {
        navController.navigate(screen)
    }
    NavHost(
        navController = navController,
        startDestination =  "home"

    ) {
        composable("home") { Home.Body3(goToScreen = {gotoScreen(it)}) }
        composable("detail/{value}") { backStackEntry -> ProductDetailActivity.Body4(
            backStackEntry.arguments?.getString("value")) }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Lab2Theme {
        Body5()
    }
}