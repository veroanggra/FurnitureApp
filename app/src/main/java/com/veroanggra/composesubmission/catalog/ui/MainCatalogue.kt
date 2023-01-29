package com.veroanggra.composesubmission

import android.widget.Scroller
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.veroanggra.composesubmission.catalog.ui.CategoryMenu
import com.veroanggra.composesubmission.catalog.widget.ProductCatalogue

@Composable

fun MainCatalogue(selectedProduct: (Int) -> Unit) {
    Column() {
            TopChairScreen()
            CategoryMenu()
            ProductCatalogue(selectedProduct = selectedProduct)
    }
}
