package data.api

import androidx.compose.ui.unit.TextUnit
import model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    // دي دالة بتسأل موقع الطقس وتاخد منه البيانات

    @GET("data/2.5/weather")

    suspend fun getDataWeather(
        @Query("q") city : String, // اسم المدينة (مثلاً: Cairo)

        @Query("appid") apiKey : String, // مفتاح API بتاعنا

        @Query("units") units: String = "metric" // وحدة الحرارة
    ) : WeatherResponse


}
