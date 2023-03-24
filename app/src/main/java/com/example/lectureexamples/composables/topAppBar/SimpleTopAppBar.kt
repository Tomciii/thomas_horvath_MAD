package com.example.lectureexamples.composables.topAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.lectureexamples.composables.MyButton
import com.example.lectureexamples.ui.theme.Purple500

@Composable
fun SimpleTopAppBar(topAppBarText: String, navController: NavController?){
    val isClicked = remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple500)
            .height(75.dp)
            .padding(10.dp)
        ,horizontalArrangement = Arrangement.SpaceBetween
        ,verticalAlignment = Alignment.CenterVertically
    ){

        MyButton(isClicked = isClicked,
            icon = {
                Icon(
                    tint = Color.White,
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = TopAppBarConstants.SHOW_FAVORITES.value)
            })

        if (isClicked.value) {
            if (navController != null) {
                isClicked.value = !isClicked.value
                navController.popBackStack()
            }
        }

        Text(topAppBarText,
            color = Color.White,
            fontSize = 6.em,
            fontWeight = FontWeight(650),
            textAlign = TextAlign.Center)
    }
}