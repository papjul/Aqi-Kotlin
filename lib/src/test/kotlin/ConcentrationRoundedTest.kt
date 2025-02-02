import aqikotlin.library.constants.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import aqikotlin.library.utils.ConcentrationRounded

class ConcentrationRoundedTest {
    @Test
    fun roundToInteger() {
        // given
        val pollutantCode = POLLUTANT_PM10
        val pollutantConcentration = 123.234
        val algorithm = EPA
        // when
        val result = ConcentrationRounded(pollutantCode, pollutantConcentration, algorithm).
                getRoundedConcentrationOnPollutantCode()
        // then
        assertEquals(123, result)
    }

    @Test
    fun roundToOneDecimalPlace() {
        // given
        val pollutantCode = POLLUTANT_CO_8H
        val pollutantConcentration = 10.76455
        val algorithm = EPA
        // when
        val result = ConcentrationRounded(pollutantCode, pollutantConcentration, algorithm).
                getRoundedConcentrationOnPollutantCode()
        // then
        assertEquals(10.8, result)
    }

    @Test
    fun roundToThreeDecimalPlace() {
        // given
        val pollutantCode = POLLUTANT_O3_1H
        val pollutantConcentration = 76.21231
        val algorithm = EPA
        // when
        val result = ConcentrationRounded(pollutantCode, pollutantConcentration, algorithm).
                getRoundedConcentrationOnPollutantCode()
        // then
        assertEquals(76, result)
    }

    @Test
    fun convertIfRequired() {
        // given
        val pollutantCode = POLLUTANT_O3_1H
        val pollutantConcentration = 150.0
        val algorithm = EPA
        // when
        val result = ConcentrationRounded(pollutantCode, pollutantConcentration, algorithm, true).
        getRoundedConcentrationOnPollutantCode()
        // then
        assertEquals(76, result)
    }
}