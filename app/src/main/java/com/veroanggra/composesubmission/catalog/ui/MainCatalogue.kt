package com.veroanggra.composesubmission

import android.widget.Scroller
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.google.accompanist.insets.LocalWindowInsets
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.veroanggra.composesubmission.catalog.ui.CategoryMenu
import com.veroanggra.composesubmission.catalog.widget.ProductCatalogue
import com.veroanggra.composesubmission.utils.AppBarCollapsedHeight
import com.veroanggra.composesubmission.utils.AppBarExpendedHeight
import kotlin.math.min

@Composable

fun MainCatalogue(selectedProduct: (Int) -> Unit, navController: NavController) {
    val scrollStateGrid = rememberLazyGridState()

    Box(Modifier.background(color = Color.White)) {
        ProductCatalogue(selectedProduct = selectedProduct, scrollStateGrid)
        TopMainScreen(navController = navController, scrollState = scrollStateGrid)
    }
}

@Composable
fun TopMainScreen(navController: NavController, scrollState: LazyGridState) {
    val columnHeight = AppBarExpendedHeight - AppBarCollapsedHeight
    val maxOffset =
        with(LocalDensity.current) { columnHeight.roundToPx() } - LocalWindowInsets.current.systemBars.layoutInsets.top
    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)
    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset { IntOffset(x = 0, y = -offset) },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {
            TopChairScreen(navController)
            CategoryMenu()
        }
    }
}

