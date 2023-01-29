package com.veroanggra.composesubmission.catalog.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.veroanggra.composesubmission.ui.theme.GreenPickerColor
import com.veroanggra.composesubmission.ui.theme.YellowPickerColor

@Composable
fun DetailProduct(idProduct: Int, navigateUp: () -> Unit) {
    val product: Product? = remember(idProduct) {
        ProductRepo.getProduct(idProduct = idProduct)
    }
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (imageProduct, titleProduct, subTitleProduct, descProduct, priceProduct, space, colorTitle, colorSwatch1, colorSwatch2, colorSwatchShade1, colorSwatchShade2, space1, space2, space3, space4) = createRefs()
        val (space5, space6, colorSwatch3, colorSwatchShade3) = createRefs()
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
                Image(painter = painterResource(
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
                        })
                Box(
                    Modifier
                        .padding(end = 20.dp, top = 20.dp)
                        .background(color = Color.LightGray, shape = CircleShape)
                        .clip(CircleShape)
                        .constrainAs(favButton) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }) {
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
                Box(modifier = Modifier
                    .padding(start = 30.dp, top = 20.dp)
                    .background(color = Color.LightGray, shape = CircleShape)
                    .clickable { navigateUp() }
                    .clip(
                        CircleShape
                    )
                    .constrainAs(backButton) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }) {
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
                    .padding(start = 30.dp, end = 30.dp, top = 20.dp)
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
                    .padding(start = 30.dp, end = 30.dp, top = 5.dp)
                    .constrainAs(subTitleProduct) {
                        start.linkTo(parent.start)
                        top.linkTo(titleProduct.bottom)
                    },
                style = TextStyle(color = Color.DarkGray)
            )
        }
        product?.let {
            Text(text = "Rp ${it.priceProduct}",
                fontSize = 20.sp,
                style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(end = 30.dp)
                    .constrainAs(priceProduct) {
                        end.linkTo(parent.end)
                        top.linkTo(titleProduct.top)
                        bottom.linkTo(subTitleProduct.bottom)
                    })
        }
        product?.let {
            Text(text = it.desc,
                fontSize = 14.sp,
                style = TextStyle(color = Color.Gray),
                modifier = Modifier
                    .padding(start = 30.dp, top = 20.dp, end = 30.dp)
                    .constrainAs(descProduct) {
                        start.linkTo(parent.start)
                        top.linkTo(subTitleProduct.bottom)
                        end.linkTo(parent.end)
                    })
        }
        Spacer(modifier = Modifier
            .height(40.dp)
            .constrainAs(space) {
                top.linkTo(descProduct.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Text(text = "Color",
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(colorTitle) {
                    start.linkTo(parent.start)
                    top.linkTo(space.bottom)
                }
                .padding(start = 30.dp))
        Spacer(modifier = Modifier
            .width(50.dp)
            .constrainAs(space1) {
                start.linkTo(colorTitle.end)
                top.linkTo(colorTitle.top)
                bottom.linkTo(colorTitle.bottom)
            })
        Spacer(modifier = Modifier
            .width(48.dp)
            .constrainAs(space2) {
                start.linkTo(colorTitle.end)
                top.linkTo(colorTitle.top)
                bottom.linkTo(colorTitle.bottom)
            })
        Box(modifier = Modifier
            .height(34.dp)
            .width(34.dp)
            .background(color = DarkCream, shape = CircleShape)
            .clip(CircleShape)
            .constrainAs(colorSwatchShade1) {
                start.linkTo(space2.end)
                top.linkTo(space2.top)
                bottom.linkTo(space2.bottom)
            })
        Box(modifier = Modifier
            .height(30.dp)
            .width(30.dp)
            .background(color = Color.LightGray, shape = CircleShape)
            .clip(CircleShape)
            .constrainAs(colorSwatch1) {
                start.linkTo(space1.end)
                top.linkTo(space1.top)
                bottom.linkTo(space1.bottom)
            })
        Spacer(modifier = Modifier
            .width(10.dp)
            .constrainAs(space4) {
                start.linkTo(colorSwatch1.end)
                top.linkTo(colorSwatch1.top)
                bottom.linkTo(colorSwatch1.bottom)
            })
        Spacer(modifier = Modifier
            .width(8.dp)
            .constrainAs(space3) {
                start.linkTo(colorSwatchShade1.end)
                top.linkTo(colorSwatchShade1.top)
                bottom.linkTo(colorSwatchShade1.bottom)
            })
        Box(modifier = Modifier
            .height(34.dp)
            .width(34.dp)
            .background(color = DarkCream, shape = CircleShape)
            .clip(CircleShape)
            .constrainAs(colorSwatchShade2) {
                start.linkTo(space3.end)
                top.linkTo(space3.top)
                bottom.linkTo(space3.bottom)
            })
        Box(modifier = Modifier
            .height(30.dp)
            .width(30.dp)
            .background(color = GreenPickerColor, shape = CircleShape)
            .clip(CircleShape)
            .constrainAs(colorSwatch2) {
                start.linkTo(space4.end)
                top.linkTo(space4.top)
                bottom.linkTo(space4.bottom)
            })
        Spacer(modifier = Modifier
            .width(10.dp)
            .constrainAs(space5) {
                start.linkTo(colorSwatch2.end)
                top.linkTo(colorSwatch2.top)
                bottom.linkTo(colorSwatch2.bottom)
            })
        Spacer(modifier = Modifier
            .width(8.dp)
            .constrainAs(space6) {
                start.linkTo(colorSwatchShade2.end)
                top.linkTo(colorSwatchShade2.top)
                bottom.linkTo(colorSwatchShade2.bottom)
            })
        Box(modifier = Modifier
            .height(34.dp)
            .width(34.dp)
            .background(color = DarkCream, shape = CircleShape)
            .clip(CircleShape)
            .constrainAs(colorSwatchShade3) {
                start.linkTo(space6.end)
                top.linkTo(space6.top)
                bottom.linkTo(space6.bottom)
            })
        Box(modifier = Modifier
            .height(30.dp)
            .width(30.dp)
            .background(color = YellowPickerColor, shape = CircleShape)
            .clip(CircleShape)
            .constrainAs(colorSwatch3) {
                start.linkTo(space5.end)
                top.linkTo(space5.top)
                bottom.linkTo(space5.bottom)
            })
    }
}