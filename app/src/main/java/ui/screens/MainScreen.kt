package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import utils.getBackgroundForWeather
import viewmodel.WeatherViewModel
import utils.getBackgroundForWeather
import viewmodel.FakeWeatherViewModel

/*
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMainScreen() {

    val fakeViewModel =
        FakeWeatherViewModel()

}

 */





@Composable

fun MainScreen(viewModel: WeatherViewModel = viewModel()) {

    var cityName by remember { mutableStateOf("") }

    val weatherData = viewModel.weatherData.value
    val isLoading = viewModel.isLoading.collectAsState().value
    val errorMessage = viewModel.errorMassage.collectAsState().value

    val condition = weatherData?._weather?.getOrNull(0)?._description ?: "Clear"
    val backgroundResId = getBackgroundForWeather(condition)

    Box(modifier = Modifier.fillMaxSize()) {

        // خلفية الطقس
        WeatherBackground(backgroundResId = backgroundResId)

        // محتوى الشاشة فوق الخلفية
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // إدخال اسم المدينة
            OutlinedTextField(
                value = cityName,
                onValueChange = { cityName = it },
                label = { Text("Enter city name") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // زر جلب الطقس
            Button(
                onClick = {
                    viewModel.getWeather(
                        cityName = cityName,
                        apiKey = "YOUR_API_KEY" // ✅ حط مفتاحك هنا
                    )
                }
            ) {
                Text("Get Weather")
            }

            Spacer(modifier = Modifier.height(32.dp))

            // حالة التحميل أو الخطأ أو عرض البيانات
            when {
                isLoading -> {
                    Text(
                        text = "Loading...",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                !errorMessage.isNullOrEmpty() -> {
                    Text(
                        text = "Error: $errorMessage",
                        color = Color.Red,
                        fontSize = 16.sp
                    )
                }

                weatherData != null -> {
                    Text(
                        text = "City: ${weatherData._name}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Temperature: ${weatherData._main._temp} °C")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Humidity: ${weatherData._main._humidity} %")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Wind Speed: ${weatherData._wind._speed} m/s")
                }
            }
        }
    }

}