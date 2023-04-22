package com.mithrundeal.mclub.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mithrundeal.mclub.R

/**
 * Created by ilkay on 15,April, 2023
 */


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignInUp() {
    Box(modifier = Modifier.background(Color.White))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column() {
            val painter: Painter = painterResource(id = R.drawable.place_holder_sign_screen)
            Image(
                painter = painter,
                contentDescription = "My Image",
                modifier = Modifier
                    .size(128.dp)
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "Register",
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                value = "Username",
                onValueChange = {})
            Text(modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                fontSize = 12.sp,
                text = buildAnnotatedString {
                    append("Username belirlerken Email veya telefon gibi verilinizi")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                        )
                    ) {
                        append("kullanmayın!")
                    }
                })
            TextField(modifier = Modifier.fillMaxWidth(), value = "Password", onValueChange = {})
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 4.dp
                ), onClick = { /*TODO*/ }) {
                Text(text = "Register")
            }
            Button(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
                Text(text = "Register")
            }
        }
    }
}