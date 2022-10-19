package dev.esdras.f290_tesi1_kotlin_climapp.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

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