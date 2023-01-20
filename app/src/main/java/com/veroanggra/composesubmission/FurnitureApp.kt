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
import kotlin.contracts.contract

@Composable
fun FurnitureApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "landing") {
        composable(route = "landing") {
            Landing(navController)
        }
        composable(route = "catalogue") {
//            MainCatalogue(selectedProduct = )
        }
    }
    val action = remember(navController) {
        AppActions(navController)
    }
    NavHost(navController = navController, startDestination = AppDestinations.LANDING_ROUTE) {
        composable(route = AppDestinations.LANDING_ROUTE) {
            Landing(navController)
        }
        composable(route = AppDestinations.PRODUCT_ROUTE) {
            MainCatalogue(selectedProduct = action.selectedProduct)
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
            DetailProduct(idProduct = arguments.getInt(PRODUCT_DETAIL_ID_KEY))
        }
    }
}

class AppActions(navController: NavController) {
    val selectedProduct: (Int) -> Unit = { idProduct: Int ->
        navController.navigate("detail/$idProduct")
    }
}

private object AppDestinations {
    const val LANDING_ROUTE = "landing"
    const val PRODUCT_ROUTE = "catalogue"
    const val PRODUCT_DETAIL_ROUTE = "detail"
    const val PRODUCT_DETAIL_ID_KEY = "idProduct"
}