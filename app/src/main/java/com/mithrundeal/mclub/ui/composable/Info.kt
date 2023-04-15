package com.mithrundeal.mclub.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mithrundeal.mclub.R

/**
 * Created by ilkay on 15,April, 2023
 */


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Info() {
    val painter: Painter = painterResource(id = R.drawable.place_holder_sign_screen)
    Image(
        painter = painter,
        contentDescription = "My Image",
        modifier = Modifier
            .size(128.dp)
            .padding(16.dp),
        contentScale = ContentScale.Fit
    )
}