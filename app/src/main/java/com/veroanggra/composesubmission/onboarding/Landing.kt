package com.veroanggra.composesubmission

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.veroanggra.composesubmission.ui.theme.DarkCream
import com.veroanggra.composesubmission.ui.theme.DarkGreen

@Composable
fun Landing(navController: NavController) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (imgLanding, textTitle, line, firstText, btnStarted) = createRefs()
        Text(
            text = "emko shop", modifier = Modifier
                .padding(top = 80.dp)
                .constrainAs(firstText) {
                    start.linkTo(parent.start)
                }
                .rotate(-90f), fontSize = 20.sp
        )
        Box(modifier = Modifier
            .padding(top = 80.dp, start = 70.dp)
            .width(5.dp)
            .height(100.dp)
            .background(color = Color.Gray)
            .constrainAs(line) {
                start.linkTo(firstText.start)
                top.linkTo(firstText.top)
                bottom.linkTo(firstText.bottom)
            })
        Text(text = "Furniture \nin your \nstyle", modifier = Modifier
            .padding(start = 10.dp, top = 45.dp)
            .constrainAs(textTitle) {
                start.linkTo(line.end)
                top.linkTo(line.top)
                bottom.linkTo(line.bottom)
            }
            .padding(top = 30.dp), style = TextStyle(lineHeight = 1.0.em), fontSize = 35.sp)
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = DarkCream,
                center = Offset(x = canvasWidth / 2 + 470, y = canvasHeight / 2),
                radius = size.minDimension / 2
            )
        }
        circleImageStroke(radius = 8, width = -550, height = -300, color = DarkCream, stroke = 5f)
        circleImageStroke(radius = 8, width = +500, height = -800, color = DarkCream, stroke = 5f)
        Image(painter = painterResource(id = R.drawable.landingpict),
            contentDescription = null,
            modifier = Modifier
                .height(500.dp)
                .width(300.dp)
                .padding(end = 30.dp)
                .constrainAs(imgLanding) {
                    end.linkTo(parent.end)
                })
        Button(
            onClick = { navController.navigate("catalogue")  },
            colors = ButtonDefaults.buttonColors(containerColor = DarkGreen),
            modifier = Modifier
                .padding(10.dp)
                .width(200.dp)
                .height(65.dp)
                .shadow(elevation = 20.dp, shape = RoundedCornerShape(30.dp))
                .constrainAs(btnStarted) {
                    top.linkTo(imgLanding.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "GET STARTED", fontSize = 20.sp)
                Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "Start")
            }
        }
    }
}

@Composable
fun circleImageStroke(radius: Int, width: Int, height: Int, color: Color, stroke: Float) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawCircle(
            color = color,
            center = Offset(x = canvasWidth / 2 + width, y = canvasHeight / 2 + height),
            radius = size.minDimension / radius,
            style = Stroke(stroke)
        )
    }
}
