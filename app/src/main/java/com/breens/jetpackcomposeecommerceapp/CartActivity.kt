package com.breens.jetpackcomposeecommerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.breens.jetpackcomposeecommerceapp.ui.CartScreen
import com.breens.jetpackcomposeecommerceapp.ui.theme.JetpackComposeEcommerceAppTheme

class CartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeEcommerceAppTheme {
                CartScreen()
            }
        }
    }
}