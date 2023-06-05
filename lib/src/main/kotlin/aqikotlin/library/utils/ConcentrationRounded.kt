package aqikotlin.library.utils

import aqikotlin.library.constants.*
import kotlin.math.round

class ConcentrationRounded(
    private val pollutantCode: String,
    private val pollutantConcentration: Double,
    private val algorithm: String,
    private val convertIfRequired: Boolean = false,
    private val temperature: Int = 25, // Celsius
    private val pressure: Int = 1013, // mb
) {
    // g/mol
    private val molecularWeights: Map<String, Number> = mapOf(
        "co" to 28.01,
        "no2" to 46.01,
        "o3" to 48,
        "so2" to 64.07
    )

    private fun convert(concentration: Double, pollutant: String): Double {
        return if (!convertIfRequired) concentration else round (
            concentration * molecularWeights[pollutant]!!.toDouble() /
                    (22.41 * ((273.15 + temperature) / 273.15) * 1 / (pressure / 1013.25))
        )
    }

    fun getRoundedConcentrationOnPollutantCode(): Number {
        if (algorithm == EPA) {
            return when (pollutantCode) {
                POLLUTANT_PM10 -> round(pollutantConcentration).toInt()
                POLLUTANT_NO2_1H -> round(convert(pollutantConcentration, "no2")).toInt()
                POLLUTANT_SO2_1H -> round(convert(pollutantConcentration, "so2")).toInt()
                POLLUTANT_PM25 -> round(pollutantConcentration * 10) / 10
                POLLUTANT_CO_8H -> round(convert(pollutantConcentration, "co") * 10) / 10
                POLLUTANT_O3_1H, POLLUTANT_O3_8H -> round(convert(pollutantConcentration, "o3")).toInt()
                else -> 0
            }
        } else if (algorithm == MEE || algorithm == EEA) {
            return round(pollutantConcentration).toInt()
        }
        return 0
    }
}

