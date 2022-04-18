package com.breens.jetpackcomposeecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavGraph
import com.breens.jetpackcomposeecommerceapp.ui.HomeScreen
import com.breens.jetpackcomposeecommerceapp.ui.NavGraphs
import com.breens.jetpackcomposeecommerceapp.ui.theme.JetpackComposeEcommerceAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.spec.NavGraphSpec

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeEcommerceAppTheme {
                DestinationsNavHost(navGraph = NavGraphs.root)
            }
        }
    }
}