package com.breens.jetpackcomposeecommerceapp

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.core.view.WindowInsetsControllerCompat
import com.breens.jetpackcomposeecommerceapp.ui.NavGraphs
import com.breens.jetpackcomposeecommerceapp.ui.theme.JetpackComposeEcommerceAppTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeEcommerceAppTheme {
                DestinationsNavHost(
                    navGraph = NavGraphs.root,
                    engine = rememberAnimatedNavHostEngine()
                )
            }
        }
        transparentStatusBar()
    }

    @RequiresApi(Build.VERSION_CODES.R)
    @Suppress("DEPRECATION")
    private fun transparentStatusBar() {
        val window = this.window
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor =
            this.resources.getColor(R.color.white)
    }
}