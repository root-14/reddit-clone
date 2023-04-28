package com.mithrundeal.mclub.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mithrundeal.mclub.R

/**
 * Created by ilkay on 28,April, 2023
 */

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailPost() {
    Surface(color = Color.Black) {
        Column {
            Text(
                text = "Post",
                fontSize = 24.sp,
                style = TextStyle(fontFamily = FontFamily.SansSerif),
                color = Color.White,
                modifier = Modifier.padding(top = 12.dp, start = 8.dp)
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
                style = TextStyle(fontFamily = FontFamily.SansSerif, color = Color.Red),
                modifier = Modifier.padding(start = 8.dp)
            )

            //TODO: make the card post view a separate object
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp, top = 12.dp),
            ) {
                Row() {
                    Column(modifier = Modifier.weight(9f)) {
                        Row() {
                            val painter: Painter = painterResource(id = R.drawable.place_holder_pp)
                            Image(
                                painter = painter,
                                contentDescription = "My Image",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(64.dp),
                                contentScale = ContentScale.Fit
                            )
                            Column() {
                                Text(text = "nick - eru")
                                Text(text = "treachery")
                                Text(text = "41.475")
                            }
                        }
                        Text(
                            modifier = Modifier.padding(start = 16.dp),
                            text = "lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. "
                        )
                        val painter: Painter = painterResource(id = R.drawable.place_holder_photo)
                        Image(
                            painter = painter,
                            contentDescription = "My Image",
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(16.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Column(modifier = Modifier.align(alignment = Alignment.CenterVertically)) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowUp,
                            contentDescription = "Up Arrow",
                            tint = Color.White,
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            text = "145", modifier = Modifier.align(Alignment.CenterHorizontally)
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Up Arrow",
                            tint = Color.White,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                val items = listOf(
                    "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
                )

                items(items.count()) {
                    CommentSection()
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CommentSection() {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 12.dp, top = 12.dp, end = 12.dp, start = 12.dp)
    ) {
        Row() {
            Column(modifier = Modifier.weight(9f)) {
                Row() {
                    val painter: Painter = painterResource(id = R.drawable.place_holder_pp)
                    Image(
                        painter = painter,
                        contentDescription = "My Image",
                        modifier = Modifier
                            .padding(16.dp)
                            .size(64.dp),
                        contentScale = ContentScale.Fit
                    )
                    Column() {
                        Text(text = "nick - eru")
                    }
                }
                Text(
                    modifier = Modifier.padding(start = 16.dp, bottom = 12.dp),
                    text = "lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. lorem ipsum dolar sit amet. ",
                    maxLines = 2
                )
            }
        }
    }
}