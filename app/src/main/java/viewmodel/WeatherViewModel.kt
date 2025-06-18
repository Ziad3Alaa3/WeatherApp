package viewmodel

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.common.api.internal.ApiKey
import data.repository.WeatherRepository
import kotlinx.coroutines.launch
import model.WeatherResponse
import androidx.compose.runtime.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class WeatherViewModel: ViewModel() , IWeatherViewModel {

    private val repository = WeatherRepository()

    private val _weatherData = mutableStateOf<WeatherResponse?>(null)

   override val weatherData: State<WeatherResponse?> = _weatherData

    private val _isLoading = MutableStateFlow(false)
  override  val isLoading = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
  override  val errorMassage = _errorMessage.asStateFlow()


    fun getWeather(cityName: String, apiKey: String) {

        viewModelScope.launch {
            try {

                _isLoading.value = true
                _errorMessage.value = null

                val response = repository.getWeatherData(cityName, apiKey)
                _weatherData.value = response
            }
            catch
                (e:Exception){
                _errorMessage.value = "Error: ${e.message}"
            }
            finally
            {
                _isLoading.value = false
            }

        }
    }
}
// viewModelScope.launch -> بيشتغل في الخلفية من غير م يبطأ البرنامج مش لازم يستني النت يكون سريع عشان يشتغل يشغل عادي في الخلفية