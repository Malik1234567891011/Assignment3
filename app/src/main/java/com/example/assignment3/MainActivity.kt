package com.example.assignment3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment3.ui.theme.Assignment3Theme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                    test()
                }
            }
        }


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment3Theme {
        Greeting("Android")
    }
}

fun test   () = runBlocking {  // Starts a new coroutine that blocks the main thread until all its child routines complete
    launch {                // Launches a new coroutine (in same context as runBlocking) and then continues to next command
        //  This coroutine runs concurrently with the rest of runBlocking
        delay(1000L)              // Suspends only this new coroutine for 1 second (1000 ms)
        println("World!")         // Prints after the delay
    }
    println("Hello")       // Runs immediately after the launch command starts its couroutine
}
