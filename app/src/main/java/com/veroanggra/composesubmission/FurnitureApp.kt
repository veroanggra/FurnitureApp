package com.veroanggra.composesubmission

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FurnitureApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing") {
        composable(route = "landing") {
            Landing(navController)
        }
        composable(route = "catalogue") {
            MainCatalogue()
        }
    }
}