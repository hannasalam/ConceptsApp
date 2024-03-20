package com.example.composelearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composelearn.ui.theme.ComposeLearnTheme

class Navigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Screen1"){
                        composable("Screen1"){
                            Screen1({
                                navController.navigate("Screen2")
                            })
                        }
                        
                        composable("Screen2"){
                            Screen2({
                                navController.navigate("Screen3")
                            })
                        }

                        composable("Screen3"){
                            Screen3({
                                navController.popBackStack("Screen1", false)
                            })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Screen1(onclick: ()-> Unit,  modifier: Modifier = Modifier) {
    Text(
        text = "Screen 1",
        modifier = modifier
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onclick) {
            Text(text = "Go to next")
        }
    }

}

@Composable
fun Screen2(onclick: ()-> Unit, modifier: Modifier = Modifier) {
    Text(
        text = "Screen 2",
        modifier = modifier
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onclick) {
            Text(text = "Go to next")
        }
    }


}

@Composable
fun Screen3(onclick: ()-> Unit, modifier: Modifier = Modifier) {
    Text(
        text = "Screen 3",
        modifier = modifier
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onclick) {
            Text(text = "Go back to first")
        }
    }
}


