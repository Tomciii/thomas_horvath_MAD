package com.example.lectureexamples.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.lectureexamples.ui.theme.Purple500

@Composable
fun DropDownMenu(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .background(Purple500)
                .padding(15.dp)
            , horizontalArrangement = Arrangement.SpaceBetween,
        ){
            Text("Movies",
                color = Color.White,
                fontSize = 6.em,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Center)
            Icon(
                tint = Color.White,
                imageVector = Icons.Default.MoreVert,
                contentDescription = "Show favorites"
            )
        }
    }
}

@Composable
fun DropDownItem(){

}