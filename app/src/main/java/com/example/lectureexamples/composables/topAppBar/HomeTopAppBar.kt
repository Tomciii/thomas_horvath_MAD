package com.example.lectureexamples.composables.topAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.example.lectureexamples.composables.MyButton
import com.example.lectureexamples.screens.Screen
import com.example.lectureexamples.ui.theme.Purple500

@Composable
fun HomeTopAppBar(navController: NavController?){
    val isClicked = remember { mutableStateOf(false) }

    Card(
    ) {
        Column(){

            DropDownMenu(navController, isClicked)

            if (isClicked.value) {
                DropDownItem(navController, isClicked)
            }
        }
    }
}
@Composable
fun DropDownItem(navController: NavController?, isClicked: MutableState<Boolean>) {
    Row(
        Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(58.dp)
            .padding(15.dp),
        horizontalArrangement = Arrangement.End
    ) {
        MyButton(onItemClick = {
            isClicked.value = !isClicked.value
            navController?.navigate(route = Screen.Favorites.route)
        },
            icon = { Icon( tint = Color.Black,
                imageVector = Icons.Default.Favorite,
                contentDescription = TopAppBarConstants.SHOW_FAVORITES.value) }
        ) {
            Text(
                TopAppBarConstants.FAVORITES.value,
                fontSize = 6.em,
                color = Color.Black,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Right
            )
        }
    }
}

@Composable
fun DropDownMenu(navController: NavController?, isClicked: MutableState<Boolean>){
    Card(modifier = Modifier.clickable { navController.to(Screen.Favorites.route) }){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Purple500)
                .height(75.dp)
                .padding(10.dp)
            ,horizontalArrangement = Arrangement.SpaceBetween
            ,verticalAlignment = Alignment.CenterVertically
        ){
            Text(TopAppBarConstants.Movies.value,
                color = Color.White,
                fontSize = 6.em,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Center)

            MyButton(isClicked = isClicked,
                icon = {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = TopAppBarConstants.SHOW_FAVORITES.value)
                })
        }
    }
}