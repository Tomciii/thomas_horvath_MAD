package com.example.bizcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcardapp.models.Project
import com.example.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BizCard()
                }
            }
        }
    }
}

@Composable
fun BizCard() {
    val showProjects = remember {
        mutableStateOf(false)
    }

    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp) {
            Column(modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {

                ProfileImage()

                Divider()

                ProfileInfo()

                Button(
                    onClick = {
                        showProjects.value = !showProjects.value
                    }
                ) {
                    Text("Show Portfolio",
                        style = MaterialTheme.typography.button)

                }

                if (showProjects.value) {
                    ProjectContents()
                }else {
                    Box {}
                }
            }
        }
    }
}

@Composable
fun ProjectContents() {
    Surface(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(width = 2.dp,
            color = Color.LightGray)
    ) {
        Portfolio(projects = listOf(Project("Project1","Coool"),Project("Project2","Nice"),))
    }

}

@Composable
fun Portfolio(projects: List<Project>){
    LazyColumn{
        items(projects) { project ->
            Card(modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                shape = RectangleShape,
                elevation = 4.dp) {

                Row(modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp)) {

                    ProfileImage(modifier = Modifier.size(100.dp))

                    Column( modifier = Modifier
                        .padding(7.dp)
                        .align(alignment = Alignment.CenterVertically)) {

                        Text(text = project.name, fontWeight = FontWeight.Bold)
                        Text(text = project.description,
                            style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileInfo() {
    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Fuma Kotaro", style = MaterialTheme.typography.h3, color = Color.Red)
        Text(text = "Android Compose Programmer @nightNinja", modifier = Modifier.padding(3.dp))
      }
}

@Composable
private fun ProfileImage(modifier: Modifier = Modifier) {
    Surface(modifier = modifier
        .size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)) {

        Image(painter = painterResource(id = R.drawable.robot),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop)

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardAppTheme {
        BizCard()
    }
}