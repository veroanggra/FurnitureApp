package com.veroanggra.composesubmission

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.veroanggra.composesubmission.ui.theme.Green
import com.veroanggra.composesubmission.ui.theme.YellowPickerColor

@Composable
fun AboutScreen(navigateUp: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val (profileImage, profileName, profileEmail, emailIcon, topScreen, profileJob, editButton, infoTitle, phoneIcon, profilePhone, privacyIcon, profilePrivacy, switchAccount, signOut) = createRefs()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 20.dp, end = 20.dp)
                .constrainAs(topScreen) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }) {
            Icon(
                Icons.Outlined.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { navigateUp() })
            Text(
                text = "About",
                fontSize = 20.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1F)
                    .padding(start = 20.dp)
            )
            Icon(
                Icons.Outlined.Settings,
                contentDescription = null,
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .clickable { })
        }
        Box(modifier = Modifier
            .padding(start = 30.dp, top = 40.dp)
            .constrainAs(profileImage) {
                start.linkTo(parent.start)
                top.linkTo(topScreen.bottom)
            }) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .width(80.dp)
                    .height(80.dp)
            )
        }
        Text(
            text = "Veronica Putri A.", fontSize = 18.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 60.dp)
                .constrainAs(profileName) {
                    start.linkTo(profileImage.end)
                    top.linkTo(profileImage.top)
                })
        Text(
            text = "Software Engineer",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier
                .padding(start = 20.dp)
                .constrainAs(profileJob) {
                    top.linkTo(profileName.bottom)
                    start.linkTo(profileImage.end)
                }
        )
        Icon(
            Icons.Outlined.Edit,
            tint = Color.LightGray,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 60.dp, end = 30.dp)
                .constrainAs(editButton) {
                    end.linkTo(parent.end)
                    top.linkTo(profileImage.top)
                    bottom.linkTo(profileImage.bottom)
                })
        Text(
            text = "My Info",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 40.dp)
                .constrainAs(infoTitle) {
                    start.linkTo(parent.start)
                    top.linkTo(profileImage.bottom)
                }
        )
        Box(
            modifier = Modifier
                .constrainAs(emailIcon) {
                    start.linkTo(parent.start)
                    top.linkTo(infoTitle.bottom)
                }
                .padding(start = 30.dp, top = 20.dp)
        ) {
            Icon(
                Icons.Filled.Email,
                tint = Green,
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
        Text(
            text = "veronicaputri497@gmail.com",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .constrainAs(profileEmail) {
                    start.linkTo(emailIcon.end)
                    top.linkTo(emailIcon.top)
                    bottom.linkTo(emailIcon.bottom)
                })
        Box(
            modifier = Modifier
                .constrainAs(phoneIcon) {
                    start.linkTo(parent.start)
                    top.linkTo(emailIcon.bottom)
                }
                .padding(start = 30.dp, top = 20.dp)
        ) {
            Icon(
                Icons.Filled.Phone,
                tint = YellowPickerColor,
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
        Text(
            text = "+62647348291276",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .constrainAs(profilePhone) {
                    start.linkTo(phoneIcon.end)
                    top.linkTo(phoneIcon.top)
                    bottom.linkTo(phoneIcon.bottom)
                })
        Box(
            modifier = Modifier
                .constrainAs(privacyIcon) {
                    start.linkTo(parent.start)
                    top.linkTo(phoneIcon.bottom)
                }
                .padding(start = 30.dp, top = 20.dp)
        ) {
            Icon(
                Icons.Filled.Lock,
                tint = Color.Gray,
                contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
        Text(
            text = "Privacy",
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .constrainAs(profilePrivacy) {
                    start.linkTo(privacyIcon.end)
                    top.linkTo(privacyIcon.top)
                    bottom.linkTo(privacyIcon.bottom)
                })
        Text(
            text = "Switch to Other Account",
            color = Color.Blue,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 60.dp)
                .constrainAs(switchAccount) {
                    start.linkTo(parent.start)
                    top.linkTo(privacyIcon.bottom)
                }
        )
        Text(
            text = "Log Out",
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp)
                .constrainAs(signOut) {
                    start.linkTo(parent.start)
                    top.linkTo(switchAccount.bottom)
                }
        )
    }
}