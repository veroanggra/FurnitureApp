package com.veroanggra.composesubmission

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.veroanggra.composesubmission.ui.theme.ComposeSubmissionTheme
import com.veroanggra.composesubmission.ui.theme.DarkCream

@Composable
fun Landing() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (imgLanding, textTitle, line) = createRefs()
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height
            drawCircle(
                color = DarkCream,
                center = Offset(x = canvasWidth / 2 + 470, y = canvasHeight / 2),
                radius = size.minDimension / 2
            )
        }
        circleImageStroke(radius = 8, width = - 550, height = -300 , color = DarkCream, stroke = 5f)
        circleImageStroke(radius = 8, width = + 500, height = -800 , color = DarkCream, stroke = 5f)
        Image(painter = painterResource(id = R.drawable.landingpict),
            contentDescription = null,
            modifier = Modifier
                .height(500.dp)
                .width(300.dp)
                .padding(end = 30.dp)
                .constrainAs(imgLanding) {
                    end.linkTo(parent.end)
                })
        Text(text = "Furniture \nin your \nstyle", modifier = Modifier
            .constrainAs(textTitle) {
                start.linkTo(line.end)
                top.linkTo(parent.top)
            }
            .padding(top = 30.dp), style = TextStyle(lineHeight = 1.0.em), fontSize = 35.sp)
        Box(modifier = Modifier.width(10.dp).height(100.dp).background(Color.Gray).padding(top = 100.dp, start = 50.dp).constrainAs(line){
            end.linkTo(textTitle.start)
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
    }
}

@Composable
fun circleImageStroke(radius: Int, width : Int, height: Int, color: Color, stroke: Float) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        drawCircle(
            color = color,
            center = Offset(x = canvasWidth / 2 + width , y = canvasHeight / 2 + height),
            radius = size.minDimension / radius,
            style = Stroke(stroke)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreLanding() {
    ComposeSubmissionTheme() {
        Landing()
    }
}