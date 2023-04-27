package com.mithrundeal.mclub.ui.composable.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mithrundeal.mclub.ui.composable.Utility

//preview is not suitable because it is data from property
@Composable
fun OnboardScreen(onboardingPages: List<@Composable () -> Unit>, navController: NavController) {
    var currentPage by remember { mutableStateOf(0) }
    var offsetX by remember { mutableStateOf(0f) }

    Column(//TODO:improve gesture sensitivity
        modifier = Modifier
            .fillMaxSize()
            .draggable(
                state = rememberDraggableState { delta ->
                    //offsetX += delta
                    //println("state -> $offsetX")
                },
                onDragStarted = { onDragStarted -> offsetX += onDragStarted.x },
                onDragStopped = {
                    val isDraggedLeftToRight = offsetX <= Utility.DRAG_THRESHOLD

                    if (isDraggedLeftToRight) {
                        if (currentPage > 0) {
                            currentPage--
                        }
                    } else {
                        if (currentPage < onboardingPages.size - 1) {
                            currentPage++
                        }
                    }
                    offsetX = 0f
                },
                orientation = Orientation.Vertical
            )
    ) {
        Box(modifier = Modifier.weight(1f)) {
            onboardingPages[currentPage]()
        }
        PageIndicator(currentPage, onboardingPages.size)
        Button(
            onClick = {
                if (currentPage < onboardingPages.lastIndex) {
                    currentPage++
                } else {//TODO: save second opening shared pref
                    navController.navigate("greeting")
                }
            }, modifier = Modifier
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
    Box(
        modifier = Modifier
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
                    if (it == currentPage) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface.copy(
                        alpha = 0.3f
                    )
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
