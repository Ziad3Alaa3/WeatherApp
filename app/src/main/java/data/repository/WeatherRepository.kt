package data.repository

import data.api.RetrofitInstance
import model.WeatherResponse

class WeatherRepository {

    suspend fun getWeatherData(cityName: String,apiKey: String): WeatherResponse{

return RetrofitInstance.apiService.getDataWeather(cityName,apiKey)
    }

}