package com.mithrundeal.mclub.ui.composable.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mithrundeal.mclub.ui.composable.SignIn
import com.mithrundeal.mclub.ui.composable.SignUp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnboardingScreen() {
    val onboardingPages = listOf(
        //WelcomePage(),
        //FeaturesPage(),
        SignIn(),
        SignUp(),
        SignIn()
    )
    var currentPage by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        onboardingPages[currentPage]
        Spacer(modifier = Modifier.weight(1f))
        PageIndicator(currentPage, onboardingPages.size)
        Button(
            onClick = {
                if (currentPage < onboardingPages.lastIndex) {
                    currentPage++
                } else {
                    // onboarding tamamlandı, bir sonraki ekrana geç
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
        ) {
            Text(
                text = if (currentPage == onboardingPages.lastIndex) "Başla" else "İleri",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun PageIndicator(currentPage: Int, pageCount: Int) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)
        .wrapContentHeight()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.Center)
        ) {
            repeat(pageCount) {
                val color by animateColorAsState(
                    if (it == currentPage) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                )

                Box(
                    Modifier
                        .size(8.dp)
                        .background(color, CircleShape)
                )
            }
        }
    }
}
