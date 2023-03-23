package com.example.lectureexamples.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.example.lectureexamples.screens.Screen
import com.example.lectureexamples.ui.theme.Purple500

@Composable
fun MyTopAppBar(screen:String, movieTitle:String = "", navController: NavController?){

    if(screen.equals(Screen.Home.route)){
        HomeTopAppBar()
    } else if(screen.equals(Screen.Favorites.route))
        {
        FavoritesTopAppBar(navController = navController)
        }
    else {
        DetailTopAppBar(movieTitle, navController)
    }
}

@Composable
fun FavoritesTopAppBar(navController: NavController?){
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
                    contentDescription = "Show favorites")
            })

        if (isClicked.value) {
            if (navController != null) {
                isClicked.value = !isClicked.value
                navController.popBackStack()
            }
        }

        Card(){
            Text("Favorites",
                color = Color.White,
                fontSize = 6.em,
                fontWeight = FontWeight(650),
                textAlign = TextAlign.Center)
        }

    }
}

@Composable
fun HomeTopAppBar(){
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
fun DetailTopAppBar(movieTitle: String, navController: NavController?){
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
                    contentDescription = "Show favorites")
            })

        if (isClicked.value) {
            if (navController != null) {
                isClicked.value = !isClicked.value
                navController.popBackStack()
            }
        }

        Text(movieTitle,
            color = Color.White,
            fontSize = 6.em,
            fontWeight = FontWeight(650),
            textAlign = TextAlign.Center)
    }
}


    @Composable
fun DropDownItem() {
    Row(
        Modifier
            .background(Color.White)
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
