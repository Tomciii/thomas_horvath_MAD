package com.example.lectureexamples.composables.topAppBar

sealed class TopAppBarConstants(val value:String){

    object FAVORITES : TopAppBarConstants("Favorites")
    object SHOW_FAVORITES : TopAppBarConstants("Show Favorites")
    object Movies : TopAppBarConstants("Movies")
}
