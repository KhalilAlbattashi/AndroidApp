package com.example.feedapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.feedapp.ui.theme.FeedAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Home"){
                    composable(route = "Home"){
                        HomeScreen(navController)
                    }
                    composable("About"){
                        AboutScreen(navController)
                    }
                }
            }
        }
    }
}


@Composable
fun HomeScreen(navController: NavController){
//    var clicked =  remember { mutableStateOf(Color(0xFFFFFFFF))}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Text(
            text = "Home Screen",
            fontSize = 30.sp,
            modifier = Modifier
                .clickable {
                navController.navigate(route = "About")
            }
        )
    }
}

@Composable
fun AboutScreen(navController: NavController){
//    var clicked =  remember { mutableStateOf(Color(0xFFFFFFFF))}
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
    ) {
        Text(
            text = "About Screen",
            fontSize = 30.sp,
            modifier = Modifier
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FeedAppTheme {
//        HomeScreen()
    }
}
