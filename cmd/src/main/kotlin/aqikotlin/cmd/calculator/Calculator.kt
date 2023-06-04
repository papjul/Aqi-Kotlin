package aqikotlin.cmd.calculator

import aqikotlin.library.Calculator
import aqikotlin.library.constants.*
import aqikotlin.cmd.utils.Algorithms
import aqikotlin.cmd.utils.Operations

class Calculator {

    fun calculate(operations: Operations, algorithm: Algorithms, pollutantCode: String, value: Number): Number {
        val algorithmSelected: String = when (algorithm) {
            Algorithms.EPA -> EPA
            Algorithms.MEE -> MEE
            else -> EPA
        }

        if (operations == Operations.AQI) {
            val result = Calculator().getAqi(pollutantCode, value, algorithmSelected)
            when (result == 0) {
                true -> println("$pollutantCode data is not valid. ")
                false -> println("$pollutantCode:$result ")
            }
            return result
        } else if (operations == Operations.CONCENTRATION) {
            val result = Calculator().getConcentration(pollutantCode, value, algorithmSelected)
            when (result == 0) {
                true -> println("$pollutantCode data is not valid. ")
                false -> println("$pollutantCode:$result ")
            }
            return result
        }
        return 0
    }
}