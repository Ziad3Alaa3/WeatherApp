package viewmodel

import kotlinx.coroutines.flow.StateFlow
import model.WeatherResponse
import androidx.compose.runtime.State


interface IWeatherViewModel {
    val weatherData: State<WeatherResponse?>
    val isLoading: StateFlow<Boolean>
    val errorMassage: StateFlow<String?>
}
