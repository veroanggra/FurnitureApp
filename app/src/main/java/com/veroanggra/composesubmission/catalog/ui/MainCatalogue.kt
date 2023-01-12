package com.veroanggra.composesubmission

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.veroanggra.composesubmission.catalog.ui.CategoryMenu

@Composable
fun MainCatalogue() {
    Column {
        TopChairScreen()
        CategoryMenu()
    }
}
