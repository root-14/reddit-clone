package com.mithrundeal.mclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mithrundeal.mclub.ui.composable.Greeting
import com.mithrundeal.mclub.ui.composable.SignIn
import com.mithrundeal.mclub.ui.composable.SignUp
import com.mithrundeal.mclub.ui.composable.onboarding.InfoComposable
import com.mithrundeal.mclub.ui.composable.onboarding.OnboardScreen
import com.mithrundeal.mclub.ui.composable.onboarding.RuleComposable
import com.mithrundeal.mclub.ui.theme.MclubTheme
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
                    val navController = rememberNavController()

                    //TODO: add anim(AnimatedVisibility) between composable
                    NavHost(navController = navController, startDestination = "onboarding_screen") {
                        composable("onboarding_screen") {
                            OnboardScreen(navController = navController, onboardingPages = listOf(
                                { RuleComposable() },
                                { InfoComposable() },
                                { SignIn() }
                            ))
                        }
                        composable("greeting") { Greeting() }
                        composable("sign_in") { SignIn() }
                        composable("sign_up") { SignUp() }
                    }

                    //TODO: read the login data from the shared pref. manage it accordingly. direct login screen or open the logged in main_feed(greeting) screen
                    navController.navigate("onboarding_screen")
                }
            }
        }
    }
}

