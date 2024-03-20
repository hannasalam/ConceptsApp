package com.example.composelearn

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composelearn.ui.theme.ComposeLearnTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", this@MainActivity)

                }
            }
        }
    }

}

@Composable
fun Greeting(name: String,context: Context, modifier: Modifier = Modifier) {
//    var applicationContext = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Button(onClick = {
            val intent = Intent(context,ActivityFlow1::class.java)
            context.startActivity(intent)

        }) {
            Text(text = "Android Lifecycle")
        }

        Button(onClick = {
            val intent = Intent(context,BroadcastRecievers::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Broadcast Receivers")
        }

        Button(onClick = {
            val serviceIntent = Intent(context, BackgroundServices::class.java)
            context.startService(serviceIntent)
        }) {
            Text(text = "Services")
        }

        Button(onClick = {
            val intent = Intent(context, ContactProvider::class.java)
            context.startActivity(intent)
        }) {
            Text(text = "Get Contacts : Content Providers")
        }
        
        Button(onClick = {
            val intent = Intent(context, Navigation::class.java)
            context.startActivity(intent)
        }){
            Text(text = "Navigation")
        }

        Button(onClick = {
            val intent = Intent(context, ViewModel::class.java)
            context.startActivity(intent)
        }){
            Text(text = "View Model + LiveData")
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeLearnTheme {
//        Greeting("Android")
//    }
//}