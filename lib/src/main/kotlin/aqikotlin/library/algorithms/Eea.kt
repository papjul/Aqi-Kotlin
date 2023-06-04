package aqikotlin.library.algorithms

import aqikotlin.library.constants.*

class Eea : Algorithm {

    private val aqi: List<Number> = listOf(
            0, 20,
            21, 40,
            41, 60,
            61, 80,
            81, 100,
            101, 200)

    private val pm25: List<Number> = listOf(
            0.0, 10.0,
            10.1, 20.0,
            20.1, 25.0,
            25.1, 50.0,
            50.1, 75.0,
            75.1, 800.0)

    private val pm10: List<Number> = listOf(
            0.0, 20.0,
            20.1, 40.0,
            40.1, 50.0,
            50.1, 100.0,
            100.1, 150.0,
            150.1, 1200.0)

    private val no2_1h: List<Number> = listOf(
            0.0, 40,
            41, 90,
            91, 120,
            121, 230,
            231, 340,
            340, 1000)

    private val so2_1h: List<Number> = listOf(
            0.0, 35,
            36, 75,
            76, 185,
            186, 304,
            305, 604,
            605, 804,
            805, 1004)

    private val o3_1h: List<Number> = listOf(
            0.0, 50,
            51, 100,
            101, 130,
            131, 240,
            241, 380,
            381, 800)

    override val lists: Map<String, List<Number>> = mapOf(
            AQI to aqi,
            POLLUTANT_PM25 to pm25,
            POLLUTANT_PM10 to pm10,
            POLLUTANT_NO2_1H to no2_1h,
            POLLUTANT_SO2_1H to so2_1h,
            POLLUTANT_O3_1H to o3_1h)
}