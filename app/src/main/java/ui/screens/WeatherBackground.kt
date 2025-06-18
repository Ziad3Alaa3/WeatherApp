package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxSize
import com.example.weatherapp.R

@Composable
fun WeatherBackground(backgroundResId: Int) {
    Image(
        painter = painterResource(id = backgroundResId),
        contentDescription = "Weather background",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}
