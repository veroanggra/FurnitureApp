package com.veroanggra.composesubmission.catalog.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.veroanggra.composesubmission.R
import com.veroanggra.composesubmission.catalog.data.Product
import com.veroanggra.composesubmission.catalog.data.ProductRepo
import com.veroanggra.composesubmission.ui.theme.DarkCream

@Composable
fun DetailProduct(idProduct: Int) {
    val product: Product? = remember(idProduct) {
        ProductRepo.getProduct(idProduct = idProduct)
    }
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (imageProduct, titleProduct, subTitleProduct, descProduct, priceProduct) = createRefs()
        Card(
            modifier = Modifier
                .height(380.dp)
                .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp)
                .constrainAs(imageProduct) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            colors = CardDefaults.cardColors(containerColor = DarkCream),
            shape = RoundedCornerShape(15.dp)
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val (imgProduct, backButton, favButton) = createRefs()
                Image(
                    painter = painterResource(
                        id = product?.imageProduct ?: R.drawable.img_top_list
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(top = 20.dp)
                        .constrainAs(imgProduct) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(backButton.bottom)
                            bottom.linkTo(parent.bottom)
                        }
                )
                Box(
                    Modifier
                        .padding(end = 20.dp, top = 30.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .clip(CircleShape)
                        .constrainAs(favButton) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }
                ) {
                    Icon(
                        Icons.Outlined.Favorite,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(10.dp)
                            .width(35.dp)
                            .height(35.dp)
                            .align(alignment = Alignment.Center)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(start = 30.dp, top = 20.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .clip(
                            CircleShape
                        )
                        .constrainAs(backButton) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        }
                ) {
                    Icon(
                        Icons.Outlined.ArrowBack,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(10.dp)
                            .width(35.dp)
                            .height(35.dp)
                            .align(alignment = Alignment.Center)
                    )
                }

            }

        }
        product?.let {
            Text(
                text = it.nameProduct,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                    .constrainAs(titleProduct) {
                        start.linkTo(parent.start)
                        top.linkTo(imageProduct.bottom)
                    },
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
            )
        }
        product?.let {
            Text(
                text = it.subTitle,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp)
                    .constrainAs(subTitleProduct) {
                        start.linkTo(parent.start)
                        top.linkTo(titleProduct.bottom)
                    },
                style = TextStyle(color = Color.DarkGray)
            )
        }
        product?.let {
            Text(
                text = "Rp ${it.priceProduct}",
                fontSize = 20.sp,
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(end = 20.dp)
                    .constrainAs(priceProduct) {
                        end.linkTo(parent.end)
                        top.linkTo(titleProduct.top)
                        bottom.linkTo(subTitleProduct.bottom)
                    }
            )
        }
    }
}