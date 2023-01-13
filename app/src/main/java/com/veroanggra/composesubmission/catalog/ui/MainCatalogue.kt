package com.veroanggra.composesubmission

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.veroanggra.composesubmission.catalog.ui.CategoryMenu
import com.veroanggra.composesubmission.catalog.widget.ProductCatalogue

@Composable
fun MainCatalogue() {
    Column {
        TopChairScreen()
        CategoryMenu()
        ProductCatalogue()
    }
}
