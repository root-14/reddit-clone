package com.mithrundeal.mclub.ui.composable.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mithrundeal.mclub.R

/**
 * Created by ilkay on 15,April, 2023
 */


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RuleComposable() {
    val rules = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Fusce at erat finibus tortor suscipit congue vitae vitae dui.",
        "Aliquam laoreet molestie lectus, et vehicula velit iaculis at.",
        "Cras pulvinar ullamcorper ullamcorper.",
        "Aliquam vitae elementum ante.",
        "Etiam neque lacus, sollicitudin sed mi id, porttitor mattis odio."
    )

    Box(modifier = Modifier.background(Color.LightGray))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.place_holder_sign_screen),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Title", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        rules.forEachIndexed { index, rule ->
            Text(
                text = "${index + 1} - $rule",
                modifier = Modifier.padding(top = 12.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}