package com.veroanggra.composesubmission.catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.veroanggra.composesubmission.catalog.data.CategoriesData

@Composable
fun CategoryMenu() {
    LazyRow(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 40.dp)) {
        items(CategoriesData.categories) { menu ->
            CategoryItem(modifier = Modifier, nameMenu = menu.menuCategory)

        }
    }
}

@Composable
fun CategoryItem(modifier: Modifier, nameMenu: String) {
    Card(

    ) {
        Text(
            text = nameMenu,
            fontSize = 12.sp,
            modifier = modifier.padding(top = 5.dp, bottom = 5.dp, start = 15.dp, end = 15.dp)
        )
    }
}


//@Preview
//@Composable
//fun PreviewItem() {
//    CategoryItem(modifier = Modifier, )
//}
