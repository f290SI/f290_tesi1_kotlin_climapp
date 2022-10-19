package dev.esdras.f290_tesi1_kotlin_climapp.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

/*
{"temp":24,"date":"19/10/2022","time":"16:55","condition_code":"29","description":"Parcialmente nublado",
"currently":"dia","cid":"","city":"São Paulo, SP","img_id":"29","humidity":60,"cloudiness":40.0,"rain":0.0,
"wind_speedy":"5.14 km/h","wind_direction":330,"sunrise":"05:30 am","sunset":"06:12 pm","condition_slug":"cloud","city_name":"São Paulo",
"forecast":[{"date":"19/10","weekday":"Qua","max":25,"min":17,"cloudiness":100.0,"rain":5.64,"rain_probability":94,"wind_speedy":"3.46 km/h","description":"Chuvas esparsas","condition":"rain"}
,{"date":"20/10","weekday":"Qui","max":29,"min":18,"cloudiness":99.0,"rain":2.87,"rain_probability":92,"wind_speedy":"5.08 km/h","description":"Chuvas esparsas","condition":"rain"},{"date":"21/10","weekday":"Sex","max":24,"min":19,"cloudiness":100.0,"rain":2.69,"rain_probability":97,"wind_speedy":"7.65 km/h","description":"Chuvas esparsas","condition":"rain"},{"date":"22/10","weekday":"Sáb","max":20,"min":16,"cloudiness":100.0,"rain":0.74,"rain_probability":39,"wind_speedy":"4.76 km/h","description":"Chuvas esparsas","condition":"rain"},{"date":"23/10","weekday":"Dom","max":17,"min":15,"cloudiness":100.0,"rain":0.38,"rain_probability":35,"wind_speedy":"4.79 km/h","description":"Chuvas esparsas","condition":"rain"},{"date":"24/10","weekday":"Seg","max":18,"min":15,"cloudiness":99.0,"rain":0.64,"rain_probability":40,"wind_speedy":"4.54 km/h","description":"Chuvas esparsas","condition":"rain"},{"date":"25/10","weekday":"Ter","max":24,"min":15,"cloudiness":14.0,"rain":0.0,"rain_probability":5,"wind_speedy":"5.5 km/h","description":"Parcialmente nublado","condition":"cloudly_day"},{"date":"26/10","weekday":"Qua","max":29,"min":16,"cloudiness":0.0,"rain":0.0,"rain_probability":1,"wind_speedy":"3.67 km/h","description":"Tempo limpo","condition":"clear_day"},{"date":"27/10","weekday":"Qui","max":32,"min":19,"cloudiness":68.0,"rain":0.0,"rain_probability":0,"wind_speedy":"5.14 km/h","description":"Tempo nublado","condition":"cloudly_day"},{"date":"28/10","weekday":"Sex","max":32,"min":21,"cloudiness":100.0,"rain":0.12,"rain_probability":24,"wind_speedy":"5.03 km/h","description":"Chuvas esparsas","condition":"rain"}]}
 */

@JsonIgnoreProperties(ignoreUnknown = true)
data class Weather(
    var temp: Int?,
    var date: String?,
    var time: String?,
    @JsonProperty("condition_code")
    var conditionCode: String?,
    var description: String?,
    var currently: String?,
    var cid: String?,
    var city: String?,
    var humidity: Int?,
    @JsonProperty("wind_speedy")
    var windSpeedy: String?,
    var sunrise: String?,
    var sunset: String?,
    @JsonProperty("condition_slug")
    var conditionSlug: String?,
    @JsonProperty("city_name")
    var cityName: String?,

    // Lista de Previsoes
    var forecast: List<Forecast>?
)