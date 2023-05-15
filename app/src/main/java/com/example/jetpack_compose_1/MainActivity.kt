package com.example.jetpack_compose_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_1.ui.theme.Jetpack_compose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//           HomeScreen()
            ResultScreen(bmi = 35.0)
        }
    }
}

@Composable
fun HomeScreen() {
    val (height, setHeight) = rememberSaveable{
        mutableStateOf("")
    }
    val (weight, setWeight) = rememberSaveable{
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "비만도 계산기")}
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            OutlinedTextField(
                value = height,
                onValueChange = setHeight,
                label = { Text(text = "키")},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            OutlinedTextField(
                value = weight,
                onValueChange = setWeight,
                label = { Text(text = "몸무게")},
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {},
                modifier = Modifier.align(Alignment.End),
            ) {
              Text("결과")
            }
        }
    }
}

@Composable
fun ResultScreen(bmi: Double) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "비만도 계산기")}
            )
        }
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text("과체중", fontSize = 30.sp)
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.baseline_sentiment_dissatisfied_24),
                contentDescription = null,
                modifier = Modifier.size(100.dp),
                colorFilter = ColorFilter.tint(
                     color = Color.Black,
                )
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    ResultScreen(bmi = 35.0)
}