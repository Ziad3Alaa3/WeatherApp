package data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java


object RetrofitInstance {
    val apiService: WeatherApiService by lazy{ // يعني الكائن ده مش هيتبني إلا لما نطلبه
        Retrofit.Builder() // بنبني نسخة Retrofit
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)

    }

}