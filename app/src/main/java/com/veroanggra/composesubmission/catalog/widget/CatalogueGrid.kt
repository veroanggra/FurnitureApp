package com.veroanggra.composesubmission.catalog.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.veroanggra.composesubmission.catalog.data.Product
import com.veroanggra.composesubmission.catalog.data.ProductRepo
import com.veroanggra.composesubmission.ui.theme.DarkCream
import com.veroanggra.composesubmission.ui.theme.DarkGreen

@Composable

fun ProductCatalogue(
    selectedProduct: (Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(top = 20.dp),
    ) {
        items(ProductRepo.getListProduct()) { product ->
            ItemProductCatalogue(
                selectedProduct = selectedProduct,
                products = product
            )
        }
    }
}

@Composable
fun ItemProductCatalogue(

    selectedProduct: (Int) -> Unit,
    products: Product
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = DarkCream),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clickable { selectedProduct(products.idProduct) }
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (imgProduct, favIcon, titleProduct, priceProduct, btnAddToChart, bottomSpace) = createRefs()
            Box(
                Modifier
                    .padding(end = 20.dp, top = 40.dp)
                    .background(color = Color.LightGray, shape = CircleShape)
                    .clip(CircleShape)
                    .constrainAs(favIcon) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }) {
                Icon(
                    Icons.Outlined.Favorite,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(5.dp)
                        .width(15.dp)
                        .height(15.dp)
                        .align(alignment = Alignment.Center)
                )
            }
            Image(
                modifier = Modifier
                    .width(200.dp)
                    .height(250.dp)
                    .padding(top = 40.dp)
                    .constrainAs(imgProduct) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
            painter = painterResource(id = products.imageProduct),
            contentDescription = null
            )
            Text(
                text = products.nameProduct,
            color = Color.DarkGray,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 20.dp)
                .constrainAs(titleProduct) {
                    top.linkTo(imgProduct.bottom)
                })

            Text(text = products.priceProduct,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(top = 10.dp, start = 20.dp)
                    .constrainAs(priceProduct) {
                        top.linkTo(titleProduct.bottom)

                    })
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
                modifier = Modifier
                    .padding(end = 20.dp, top = 30.dp)
                    .width(100.dp)
                    .height(40.dp)
                    .shadow(elevation = 20.dp, shape = RoundedCornerShape(30.dp))
                    .constrainAs(btnAddToChart) {
                        top.linkTo(titleProduct.bottom)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(text = "Add to Chart", fontSize = 8.sp)
            }

            Spacer(modifier = Modifier
                .height(20.dp)
                .constrainAs(bottomSpace) {
                    bottom.linkTo(parent.bottom)
                    top.linkTo(btnAddToChart.bottom)
                })
        }
    }
}

