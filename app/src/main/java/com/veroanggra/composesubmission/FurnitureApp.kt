package com.veroanggra.composesubmission

import androidx.compose.runtime.Composable

import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.veroanggra.composesubmission.AppDestinations.PRODUCT_DETAIL_ID_KEY
import com.veroanggra.composesubmission.catalog.ui.DetailProduct

@Composable
fun FurnitureApp() {
    val navController = rememberNavController()
    val action = remember(navController) {
        AppActions(navController)
    }
    NavHost(navController = navController, startDestination = AppDestinations.LANDING_ROUTE) {
        composable(route = AppDestinations.LANDING_ROUTE) {
            Landing(navController)
        }
        composable(route = AppDestinations.PRODUCT_ROUTE) {
            MainCatalogue(selectedProduct = action.selectedProduct, navController = navController)
        }
        composable(route = AppDestinations.ABOUT_ROUTE) {
            AboutScreen(navigateUp = action.navigateUp)
        }
        composable(
            route = "${AppDestinations.PRODUCT_DETAIL_ROUTE}/{$PRODUCT_DETAIL_ID_KEY}",
            arguments = listOf(navArgument(
                PRODUCT_DETAIL_ID_KEY
            ) {
                type = NavType.IntType
            })
        ) {
            val arguments = requireNotNull(it.arguments)
            DetailProduct(
                idProduct = arguments.getInt(PRODUCT_DETAIL_ID_KEY),
                navigateUp = action.navigateUp
            )
        }
    }
}

class AppActions(navController: NavController) {
    val selectedProduct: (Int) -> Unit = { idProduct: Int ->
        navController.navigate("detail/$idProduct")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}

private object AppDestinations {
    const val LANDING_ROUTE = "landing"
    const val PRODUCT_ROUTE = "catalogue"
    const val PRODUCT_DETAIL_ROUTE = "detail"
    const val ABOUT_ROUTE = "about"
    const val PRODUCT_DETAIL_ID_KEY = "idProduct"
}