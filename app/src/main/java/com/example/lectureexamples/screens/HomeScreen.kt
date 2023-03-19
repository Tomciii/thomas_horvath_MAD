package com.example.lectureexamples.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lectureexamples.screens.composable.MyList
import com.example.lectureexamples.screens.composable.TopAppBar

@Composable
fun HomeScreen(navController: NavController)  {

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                Column {

                  TopAppBar(navController)
                    Text(
                        style = MaterialTheme.typography.h6,
                        text= "Movie List"
                    )
                    MyList(navController)
                }
            }
}

@Preview
@Composable
fun Greeting() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember {
            mutableStateOf("")
        }

        Text(text = "Hello ${name}!")

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it},
            label = { Text("Name")}
        )
    }}

@Preview
@Composable
fun WelcomeText(modifier: Modifier = Modifier, text: String = "default") {
    Row(
        modifier = modifier
            .padding(16.dp)
            .background(Color.Blue)
            .fillMaxWidth()
    ) {
        Text(modifier = modifier, text = "Hola")
        Text(text = text)
    }
}