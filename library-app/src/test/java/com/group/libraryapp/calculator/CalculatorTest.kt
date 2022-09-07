package com.group.libraryapp.calculator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    fun addTest() {
        // given
        var calculator = Calculator(5);

        // when
        calculator.add(10)

        // then
        if (calculator.number != 15) {
            throw IllegalStateException()
        }
    }

    fun minusTest() {
        // given
        var calculator = Calculator(5);

        // when
        calculator.minus(3)

        // then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }

    @Test
    fun multiply() {
        // given
        var calculator = Calculator(5);

        // when
        calculator.multiply(10)

        // then
        if (calculator.number != 50) {
            throw IllegalStateException()
        }
    }


}