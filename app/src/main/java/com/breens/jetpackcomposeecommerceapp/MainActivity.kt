package com.breens.jetpackcomposeecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavGraph
import com.breens.jetpackcomposeecommerceapp.ui.HomeScreen
import com.breens.jetpackcomposeecommerceapp.ui.NavGraphs
import com.breens.jetpackcomposeecommerceapp.ui.theme.JetpackComposeEcommerceAppTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.spec.NavGraphSpec

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeEcommerceAppTheme {
                DestinationsNavHost(navGraph = NavGraphs.root, engine = rememberAnimatedNavHostEngine())
            }
        }
    }
}