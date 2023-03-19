package com.example.lectureexamples.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.lectureexamples.ui.theme.Purple200
import com.example.lectureexamples.ui.theme.Purple500

@Composable
fun TopAppBar(){

    val isClicked = remember { mutableStateOf(false) }

    Card(
    ) {
        Column(){

            DropDownMenu(isClicked)

            if (isClicked.value) {
                DropDownItem()
            }
        }
    }
}


@Composable
fun DropDownItem() {
    Row(
        Modifier
            .background(Purple200)
            .fillMaxWidth()
            .height(58.dp)
            .padding(15.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Icon( tint = Color.Black,
            imageVector = Icons.Default.Favorite,
            contentDescription = "Show favorites")
        Text("Favorites",
            fontSize = 6.em,
            color = Color.Black,
            fontWeight = FontWeight(650),
            textAlign = TextAlign.Right)
    }
}

    @Composable
    fun DropDownMenu(isClicked: MutableState<Boolean>){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple500)
                .height(75.dp)
                .padding(10.dp)
            ,horizontalArrangement = Arrangement.SpaceBetween
            ,verticalAlignment = Alignment.CenterVertically
        ){
            Text("Movies",
                color = Color.White,
                fontSize = 6.em,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Center)

            MyButton(isClicked = isClicked,
                icon = {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "Show favorites")
                })
        }
    }
