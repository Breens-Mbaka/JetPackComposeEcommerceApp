package com.breens.jetpackcomposeecommerceapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.breens.jetpackcomposeecommerceapp.DataProvider
import com.breens.jetpackcomposeecommerceapp.Product
import com.breens.jetpackcomposeecommerceapp.R
import com.breens.jetpackcomposeecommerceapp.ui.theme.ColorBlack
import com.breens.jetpackcomposeecommerceapp.ui.theme.ColorGrey
import com.breens.jetpackcomposeecommerceapp.ui.theme.ColorLightGrey
import com.breens.jetpackcomposeecommerceapp.ui.theme.elmessri
import com.ramcosta.composedestinations.annotation.Destination

@Preview
@Composable
@Destination
fun CartScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column {
            CartItemList(products = DataProvider.productList)
        }

    }
}

@Composable
fun CartItemList(products: List<Product>) {
    val productList = remember { products }
    Column(modifier = Modifier.padding(15.dp)) {
        Icon(
            painter = painterResource(id = R.drawable.backicon),
            contentDescription = "Back Icon",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 20.dp)
        )
        Spacer(modifier = Modifier.padding(top = 30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "My Cart",
                fontFamily = elmessri,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                color = ColorBlack
            )
            Text(
                text = "(2)",
                fontFamily = elmessri,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                color = ColorGrey
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            items(productList.size) {
                CartItem(
                    product = products[it]
                )
            }
        }
        CheckoutComponent()
    }
}

@Composable
fun CartItem(product: Product) {
    var count by remember {
        mutableStateOf(1)
    }
    Column(modifier = Modifier.padding(bottom = 15.dp)) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(ColorLightGrey),
        ) {
            Image(
                painter = painterResource(id = product.productImage),
                contentDescription = "Product Image",
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                contentScale = ContentScale.Fit
            )
            Box(modifier = Modifier
                .padding(start = 15.dp, bottom = 15.dp)
                .align(Alignment.BottomStart)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(65.dp)
                        .height(25.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.removeicon),
                        contentDescription = "Remove Product",
                        modifier = Modifier.clickable {
                            count--
                        }
                    )
                    Text(
                        text = count.toString(),
                        fontSize = 12.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.addicon),
                        contentDescription = "Add Product",
                        modifier = Modifier.clickable {
                            count++
                        }
                    )
                }
            }
            Column(modifier = Modifier
                .padding(end = 15.dp, bottom = 15.dp)
                .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(ColorBlack),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "M",
                        fontSize = 10.sp,
                        fontFamily = elmessri,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.variety3),
                    contentDescription = "Random Variety",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                )
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = product.productName,
                fontSize = 16.sp,
                fontFamily = elmessri,
                fontWeight = FontWeight.Medium,
                color = ColorGrey
            )
            Text(
                text = product.productPrice,
                fontSize = 20.sp,
                fontFamily = elmessri,
                fontWeight = FontWeight.Bold,
                color = ColorBlack
            )
        }
    }
}

@Preview
@Composable
fun CheckoutComponent() {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total Price(2 items)",
                fontSize = 16.sp,
                fontFamily = elmessri,
                fontWeight = FontWeight.Medium,
                color = ColorGrey
            )
            Text(
                text = "$5.56",
                fontSize = 20.sp,
                fontFamily = elmessri,
                fontWeight = FontWeight.Bold,
                color = ColorBlack
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(80.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ColorLightGrey),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$",
                        fontSize = 12.sp,
                        fontFamily = elmessri,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.dropdownicon),
                        contentDescription = "Dropdown Icon"
                    )
                }
            }

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(ColorBlack),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Checkout",
                        fontFamily = elmessri,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.continueicon),
                        contentDescription = "Checkout Icon",
                        tint = Color.White
                    )
                }
            }
        }
    }
}