package model

data class WeatherResponse(
    var _name: String,  // اسم المدينة
    var _main:Main,  // بيانات الطقس الرئيسية (حرارة - رطوبة)
    var _weather: List<Weather>,     // وصف الطقس (صافي - ممطر...)
    var _wind: Wind
// استخدمنا List عشان البيانات بتكون علي شكل قائمة
)

data class Main(
    val  _temp: Double, // درجة الحرارة
    val  _humidity: Int // الرطوبة
)

data class Weather(
    val  _description: String // وصف الطقس
)

data class Wind(
    val  _speed: Double
)


