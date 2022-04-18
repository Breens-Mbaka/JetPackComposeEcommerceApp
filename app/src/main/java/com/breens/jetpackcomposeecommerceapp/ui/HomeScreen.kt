package com.breens.jetpackcomposeecommerceapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.jetpackcomposeecommerceapp.DataProvider
import com.breens.jetpackcomposeecommerceapp.Product
import com.breens.jetpackcomposeecommerceapp.R
import com.breens.jetpackcomposeecommerceapp.ScreenTransitions
import com.breens.jetpackcomposeecommerceapp.ui.destinations.CartScreenDestination
import com.breens.jetpackcomposeecommerceapp.ui.theme.ColorBlack
import com.breens.jetpackcomposeecommerceapp.ui.theme.ColorGrey
import com.breens.jetpackcomposeecommerceapp.ui.theme.ColorLightGrey
import com.breens.jetpackcomposeecommerceapp.ui.theme.elmessri
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true, style = ScreenTransitions::class)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column {
            ProfileComponent(navigator)
            ProductTitle()
            ProductList(products = DataProvider.productList)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProfileComponent(navigator: DestinationsNavigator) {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.padding(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.shoppingcarticon),
                contentDescription = "Shopping Cart",
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(24.dp)
                    .clickable(enabled = true) {
                        navigator.navigate(CartScreenDestination)
                    }
            )
            Image(
                painter = painterResource(R.drawable.profileimage),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun ProductTitle() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = ColorBlack,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                ) {
                    append("New\n")
                }
                withStyle(
                    style = SpanStyle(
                        color = ColorGrey,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                ) {
                    append("Arrivals")
                }
            },
            fontFamily = elmessri
        )
        Icon(
            painter = painterResource(id = R.drawable.filetericon),
            contentDescription = "Filter",
            tint = ColorGrey,
            modifier = Modifier
                .size(30.dp)
                .padding(bottom = 10.dp)
        )
    }
}


@Composable
fun ProductList(products: List<Product>) {
    val productList = remember { products }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(productList.size) {
            ProductItem(
                product = products[it]
            )
        }
    }
}

@Composable
fun ProductItem(
    product: Product
) {
    Column(modifier = Modifier.padding(15.dp)) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ColorLightGrey)
        ) {
            Image(
                painter = painterResource(id = product.productImage),
                contentDescription = "Product Image",
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                contentScale = ContentScale.Fit
            )
            Icon(
                painter = painterResource(id = R.drawable.favoriteicon),
                contentDescription = "Add To Cart",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 15.dp, bottom = 20.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .fillMaxSize()
        ) {
            Text(
                text = product.productPrice,
                modifier = Modifier.align(Alignment.TopStart),
                fontSize = 20.sp,
                fontFamily = elmessri,
                fontWeight = FontWeight.Bold,
                color = ColorBlack
            )
            Text(
                text = product.productName,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(top = 30.dp),
                fontSize = 16.sp,
                fontFamily = elmessri,
                fontWeight = FontWeight.Medium,
                color = ColorGrey
            )
            Row(
                modifier = Modifier.align(Alignment.TopEnd),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.variety1),
                    contentDescription = "Variety 1",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.variety2),
                    contentDescription = "Variety 2",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
                Image(
                    painter = painterResource(id = R.drawable.variety3),
                    contentDescription = "Variety 3",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}