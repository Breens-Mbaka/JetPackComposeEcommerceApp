package com.breens.jetpackcomposeecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.breens.jetpackcomposeecommerceapp.ui.theme.JetpackComposeEcommerceAppTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeEcommerceAppTheme {
            }
        }
    }
}