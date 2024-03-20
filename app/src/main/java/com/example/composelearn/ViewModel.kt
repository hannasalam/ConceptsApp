package com.example.composelearn





import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.composelearn.ui.theme.ComposeLearnTheme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MyViewModel : ViewModel() {
    private val _counter = MutableLiveData(0)
    val counter: LiveData<Int> get() = _counter

    fun incrementCounter() {
        _counter.value = (_counter.value ?: 0) + 1
    }

    fun decrementCounter() {
        _counter.value = (_counter.value ?: 0) - 1
    }
}


class ViewModel : ComponentActivity() {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2(viewModel)
                }
            }
        }
    }
}


@Composable
fun Greeting2(viewModel: MyViewModel = viewModel) {
    val counterState by viewModel.counter.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Counter: $counterState")
        Button(onClick = { viewModel.incrementCounter() }) {
            Text("Increment")
        }
        Button(onClick = { viewModel.decrementCounter() }) {
            Text(text = "Decrement") 
        }
    }
}

