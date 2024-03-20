package com.example.composelearn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composelearn.ui.theme.ComposeLearnTheme



class ActivityFlow1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("--page1", "calling onCreate")
        Toast.makeText(this, "Calling Oncreate [Activity 1]",Toast.LENGTH_SHORT).show()
        setContent {
            ComposeLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    modifier = Modifier.,
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(onClick = {
                            val intent = Intent(this@ActivityFlow1, ActivityFlow2::class.java)
                            startActivity(intent)
                        }) {
                            Text(text = "Click to go to newPage",)
                        }
                    }

                }
            }
        }
    }
    override fun onStart() {
        // call superclass constructor
        super.onStart();
        Toast. makeText(this, "Calling onStart [Activity 1]", Toast.LENGTH_SHORT).show()
        Log.d("--page1", "calling onStart")
    }

    override fun onRestart() {
        // call superclass constructor
        super.onRestart();
        Toast. makeText(this, "Calling onRestart [Activity 1]", Toast.LENGTH_SHORT).show()
        Log.d("--page1", "calling onRestart")
    }

    override fun onResume() {
        // call superclass constructor
        super.onResume();
        Toast. makeText(this, "Calling onResume [Activity 1]", Toast.LENGTH_SHORT).show()
        Log.d("--page1", "calling onResume")
    }

    override fun onPause() {
        // call superclass constructor
        super.onPause();
        Toast. makeText(this, "Calling onPause [Activity 1]", Toast.LENGTH_SHORT).show()
        Log.d("--page1", "calling onPause")
    }

    override fun onStop() {
        // call superclass constructor
        super.onStop();
        Toast. makeText(this, "Calling onStop [Activity 1]", Toast.LENGTH_SHORT).show()
        Log.d("--page1", "calling onStop")
    }

    override fun onDestroy() {
        // call superclass constructor
        super.onDestroy();
        Toast. makeText(this, "Calling onDestroy [Activity 1]", Toast.LENGTH_SHORT).show()
        Log.d("--page1", "calling onDestroy")
    }
}

