package com.veroanggra.composesubmission.catalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.veroanggra.composesubmission.catalog.data.CategoriesData

@Composable
fun CategoryMenu() {
    LazyRow(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp)) {
        items(CategoriesData.categories) { menu ->
            CategoryItem(modifier = Modifier, nameMenu = menu.menuCategory)
        }
    }
}

@Composable
fun CategoryItem(modifier: Modifier, nameMenu: String) {
    Row(
        modifier
            .padding(horizontal = 8.dp, vertical = 5.dp)
            .shadow(shape = RoundedCornerShape(20), elevation = 2.dp)
            .background(color = Color.LightGray)
    ) {
        Text(
            text = nameMenu,
            fontSize = 12.sp,
            modifier = modifier.padding(top = 5.dp, bottom = 5.dp, start = 15.dp, end = 15.dp).background(color = Color.LightGray)
        )
    }
}


//@Preview
//@Composable
//fun PreviewItem() {
//    CategoryItem(modifier = Modifier, )
//}
