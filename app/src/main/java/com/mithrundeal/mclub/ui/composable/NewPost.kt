package com.mithrundeal.mclub.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mithrundeal.mclub.R

/**
 * Created by ilkay on 28,April, 2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NewPost() {
    Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {
        Column {
            Text(
                text = "New Post",
                fontSize = 24.sp,
                style = TextStyle(fontFamily = FontFamily.SansSerif),
                color = Color.White
            )

            val levelWithNumber = "5";
            val rank = "TREACHERY"
            Text(
                text = buildAnnotatedString {
                    append("Katman")
                    append(" ")
                    append(levelWithNumber)
                    append(" ")
                    append("-")
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold, color = Color.Red
                        )
                    ) {
                        append(rank)
                    }
                },
                fontSize = 12.sp,
                style = TextStyle(fontFamily = FontFamily.SansSerif, color = Color.Red)
            )
            Text(
                modifier = Modifier.padding(top = 12.dp, start = 8.dp),
                text = "Quisque sed dui in libero tincidunt sodales nec euismod leo.",
                fontSize = 12.sp,
                color = Color.Gray
            )

            TextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
                    .padding(top = 12.dp, start = 8.dp, end = 8.dp),
                label = { },
            )
            val painter: Painter = painterResource(id = R.drawable.place_holder_sign_screen)
            Button(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.End)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painter,
                        contentDescription = "insert photo",
                        modifier = Modifier
                            .size(12.dp)
                    )
                    Text(text = "Add Image", modifier = Modifier.padding(start = 4.dp))
                }
            }
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "Post",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }
        }
    }
}