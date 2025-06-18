package viewmodel

import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.flow.MutableStateFlow
import model.WeatherResponse
import model.Main
import model.Wind
import model.Weather

class FakeWeatherViewModel : IWeatherViewModel {
    override val weatherData = mutableStateOf(
        WeatherResponse(
            _name = "Cairo",
            _main = Main(_temp = 30.0, _humidity = 60),
            _wind = Wind(_speed = 5.0),
            _weather = listOf(Weather(_description = "Clear Sky"))
        )
    )

    override val isLoading = MutableStateFlow(false)
    override val errorMassage = MutableStateFlow("")
}
