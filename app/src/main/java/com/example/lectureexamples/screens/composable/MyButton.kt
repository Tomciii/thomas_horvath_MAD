package com.example.lectureexamples.screens.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier

@Composable
fun MyButton(isClicked: MutableState<Boolean>, icon: @Composable () -> Unit){
    Button( onClick = {isClicked.value = !isClicked.value}
    ){
        icon()
    }
}

@Composable
fun MyButton(onItemClick: () -> Unit, icon: @Composable () -> Unit, text: @Composable () -> Unit){
       Card(modifier = Modifier.clickable(onClick = onItemClick)){
           Row(){
               icon()
               text()
           }
       }
}


