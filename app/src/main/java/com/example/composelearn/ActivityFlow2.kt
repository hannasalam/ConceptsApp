package com.example.composelearn

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.composelearn.ui.theme.ComposeLearnTheme

class ActivityFlow2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Calling Oncreate [Activity 2]", Toast.LENGTH_SHORT).show()
        Log.d("--page1", "calling onCreate")
        setContent {
            ComposeLearnTheme {
                Text(text = "Welcome to second activity")
            }
        }
    }

    override fun onStart() {
        // call superclass constructor
        super.onStart();
        Toast.makeText(this, "Calling onStart [Activity 2]", Toast.LENGTH_SHORT).show()
        Log.d("--page2", "calling onStart")
    }

    override fun onRestart() {
        // call superclass constructor
        super.onRestart();
        Toast.makeText(this, "Calling onRestart [Activity 2]", Toast.LENGTH_SHORT).show()
        Log.d("--page2", "calling onRestart")
    }

    override fun onResume() {
        // call superclass constructor
        super.onResume();
        Toast.makeText(this, "Calling onResume [Activity 2]", Toast.LENGTH_SHORT).show()
        Log.d("--page2", "calling onResume")
    }

    override fun onDestroy() {
        // call superclass constructor
        super.onDestroy();
        Toast.makeText(this, "Calling onDestroy [Activity 2]", Toast.LENGTH_LONG).show()
        Log.d("--page2", "calling onDestroy")
    }
}