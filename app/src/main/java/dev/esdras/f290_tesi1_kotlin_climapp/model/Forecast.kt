package dev.esdras.f290_tesi1_kotlin_climapp.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class Forecast(
    var date: String?,
    var weekday: String?,
    var max: String?,
    var min: String?,
    var description: String?,
    var condition : String?
)