package com.example.lectureexamples.screens.composable

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun MyButton(isClicked: MutableState<Boolean>, icon: @Composable () -> Unit){

    Button( onClick = {isClicked.value = !isClicked.value}
    ){
        icon()
    }
}
