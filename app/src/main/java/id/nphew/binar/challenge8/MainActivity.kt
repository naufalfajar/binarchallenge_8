package id.nphew.binar.challenge8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.nphew.binar.challenge8.ui.theme.Challenge8Theme
import id.nphew.binar.challenge8.ui.theme.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Challenge8Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
        }
    }
}

@Composable
fun Greeting(name: String) {
//    Text(text = "Hello $name!")
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(12.dp)) {


    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    Challenge8Theme {
//        Greeting("Android")
//    }
    RegisterScreen()

}