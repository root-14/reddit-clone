package com.mithrundeal.mclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Observer
import com.mithrundeal.mclub.ui.theme.MclubTheme
import com.mithrundeal.mclub.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
fun Greeting(mainViewModel: MainViewModel = hiltViewModel()) {
    val lifecycleOwner = LocalLifecycleOwner.current
    var dummy=mainViewModel

    Scaffold(topBar = {
        TopAppBar(title = {
            Column() {
                Text(
                    text = "Senatus",
                    fontSize = 24.sp,
                    style = TextStyle(fontFamily = FontFamily.SansSerif)
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
                    }, fontSize = 12.sp, style = TextStyle(fontFamily = FontFamily.SansSerif)
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
                                onClick = {
                                    mainViewModel.res.observe(
                                        lifecycleOwner,
                                        Observer { println("hello world") })
                                },
                                contentPadding = ButtonDefaults.TextButtonContentPadding,
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Start,
                                ) {
                                    Icon(
                                        Icons.Default.Build,
                                        contentDescription = "TOP",
                                        modifier = Modifier.size(12.dp)
                                    )
                                    Text(
                                        text = "TOP",
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
                                    horizontalArrangement = Arrangement.Start,
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
        Column() {
            //TODO: move to string.xml
            val levels = listOf(
                "Limbo", "Lust", "Gluttony", "Greed", "Anger"
            )
            LazyRow(
                modifier = Modifier.padding(top = 12.dp, start = 12.dp),
                contentPadding = innerPadding,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(levels.count()) {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = levels[it])
                    }
                }
            }


            val items = listOf(
                "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                items(items.count()) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 12.dp, end = 12.dp, top = 12.dp)
                    ) {
                        Row() {
                            Column(modifier = Modifier.weight(9f)) {
                                Row() {
                                    val painter: Painter =
                                        painterResource(id = R.drawable.place_holder_pp)
                                    Image(
                                        painter = painter,
                                        contentDescription = "My Image",
                                        modifier = Modifier
                                            .padding(16.dp)
                                            .size(64.dp),
                                        contentScale = androidx.compose.ui.layout.ContentScale.Fit
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
                                val painter: Painter =
                                    painterResource(id = R.drawable.place_holder_photo)
                                Image(
                                    painter = painter,
                                    contentDescription = "My Image",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp),
                                    contentScale = androidx.compose.ui.layout.ContentScale.Fit
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
                                    text = "145",
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
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