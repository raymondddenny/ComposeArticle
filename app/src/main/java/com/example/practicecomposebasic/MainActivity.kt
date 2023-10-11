package com.example.practicecomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicecomposebasic.ui.theme.PracticeComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeBasic(
                        firstText = "Jetpack Compose tutorial",
                        secondText = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                        thirdText = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
                    )
                }
            }
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

@Composable
fun ComposeBasic(firstText: String, secondText: String, thirdText: String, modifier: Modifier=Modifier){
    Column {
        ComposeBasicImage()
        ComposeBasicText(
            first = firstText,
            second = secondText,
            third = thirdText
        )
    }
}

@Composable
fun ComposeBasicImage(){

    val image = painterResource(id = R.drawable.bg_compose_background)

    Image(
        painter = image,
        contentDescription = "Compose Basic Image",
        contentScale = ContentScale.FillWidth,
        )


}

@Composable
fun ComposeBasicText(first:String,second:String,third:String){
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        ) {
        ComposeBasicTextItem(text=first, fontSize=24, modifier=Modifier.padding(16.dp))
        ComposeBasicTextItem(text=second, modifier=Modifier.padding(16.dp))
        ComposeBasicTextItem(text=third, modifier=Modifier.padding(16.dp))

    }
}

@Composable
fun ComposeBasicTextItem(text:String, fontSize:Int = 14, modifier: Modifier){
    Text(text = text,
        fontSize=fontSize.sp,
        textAlign=TextAlign.Justify,
        modifier=modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticeComposeBasicTheme {
        ComposeBasic(
            firstText = "Jetpack Compose tutorial",
            secondText = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            thirdText = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.",
            )
    }
}