package com.mithrundeal.mclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mithrundeal.mclub.ui.theme.MclubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MclubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Column() {
                Text(
                    text = "Senatus",
                    fontSize = 24.sp,
                    style = TextStyle(fontFamily = FontFamily.SansSerif)
                )
                Text(
                    text = "katman 5 - treachery",
                    fontSize = 12.sp,
                    style = TextStyle(fontFamily = FontFamily.SansSerif)
                )
            }
        }, actions = {
            Surface(
                color = Color.Gray.copy(0.5f),
                modifier = Modifier.clip(RoundedCornerShape(128.dp)),
            ) {
                Row(
                ) {
                    Box(modifier = Modifier.padding(start = 4.dp, end = 4.dp)) {
                        Row() {
                            Button(
                                onClick = { /* TODO: onclick event */ },
                                contentPadding = ButtonDefaults.TextButtonContentPadding,
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start, // icon'ın sola dayalı hale getirilmesi
                                ) {
                                    Icon(
                                        Icons.Default.Favorite,
                                        contentDescription = "TOP",
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Text(
                                        text = "NEW",
                                        fontSize = 12.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.size(2.dp))
                            Button(
                                onClick = { /* TODO: onclick event */ },
                                contentPadding = ButtonDefaults.TextButtonContentPadding,
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start, // icon'ın sola dayalı hale getirilmesi
                                ) {
                                    Icon(
                                        Icons.Default.Favorite,
                                        contentDescription = "NEW",
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Text(
                                        text = "NEW",
                                        fontSize = 12.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }

                    }
                }
            }
        })
    }, content = { innerPadding ->

        //TODO: move to string.xml
        val levels = listOf(
            "Limbo", "Lust", "Gluttony", "Greed", "Anger"
        )
        LazyRow(
            modifier = Modifier.padding(top = 12.dp),
            contentPadding = innerPadding,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(levels.count()) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = levels[it])
                }
            }
        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MclubTheme {
        Greeting()
    }
}