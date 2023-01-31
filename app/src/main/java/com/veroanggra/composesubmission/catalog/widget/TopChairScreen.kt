package com.veroanggra.composesubmission

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.veroanggra.composesubmission.ui.theme.DarkCream
import com.veroanggra.composesubmission.ui.theme.NeonGreen

@Composable
fun TopChairScreen(navController: NavController) {
    ConstraintLayout(modifier = Modifier) {
        val (topLay, topDesc, topImageDesc, discTitle, discSubtitle, profile, textProfile) = createRefs()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                .constrainAs(topLay) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Find Your \nDream Furniture",
                fontSize = 25.sp,
                style = TextStyle(lineHeight = 1.3.em)
            )
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .height(60.dp)
                    .width(40.dp),
                contentPadding = PaddingValues(start = 6.dp, end = 6.dp)
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Box(
            Modifier
                .padding(start = 20.dp, top = 10.dp)
                .constrainAs(profile) {
                    top.linkTo(topLay.bottom)
                    start.linkTo(parent.start)
                }) {
            Button(
                onClick = { navController.navigate("about") },
                colors = ButtonDefaults.buttonColors(Color.LightGray),
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
                shape = CircleShape,
                contentPadding = PaddingValues(start = 6.dp, end = 6.dp)
            ) {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = null,
                    tint = DarkCream,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Text(
            text = "About",
            modifier = Modifier
                .padding(top = 10.dp, start = 10.dp)
                .clickable { navController.navigate("about") }
                .constrainAs(textProfile) {
                    start.linkTo(profile.end)
                    top.linkTo(profile.top)
                    bottom.linkTo(profile.bottom)
                }, color = Color.Gray
        )
        Box(
            Modifier
                .padding(start = 20.dp, end = 20.dp, top = 60.dp)
                .background(NeonGreen, shape = RoundedCornerShape(20))
                .fillMaxWidth()
                .height(150.dp)
                .constrainAs(topDesc) {
                    top.linkTo(topLay.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
        Image(painter = painterResource(id = R.drawable.img_top_list),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 30.dp, end = 20.dp)
                .width(180.dp)
                .height(180.dp)
                .constrainAs(topImageDesc) {
                    end.linkTo(topDesc.end)
                    bottom.linkTo(topDesc.bottom)
                })
        Text(text = "20% OFF",
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 90.dp, start = 50.dp)
                .constrainAs(discTitle) {
                    start.linkTo(topDesc.start)
                    top.linkTo(topDesc.top)
                })
        Text(text = "Until 24 Dec",
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 50.dp)
                .constrainAs(discSubtitle) {
                    top.linkTo(discTitle.bottom)
                    start.linkTo(topDesc.start)
                })
    }
}
