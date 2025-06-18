package utils

import com.example.weatherapp.R


fun getBackgroundForWeather(condition : String): Int{

    return when(condition){

        "Clear" ->  R.drawable.sunnysky_background
        "Clouds" -> R.drawable.cloudy_background
        "Rain" -> R.drawable.rain_background
        "Snow" -> R.drawable.snow_background
        else -> R.drawable.default_background
    }
}