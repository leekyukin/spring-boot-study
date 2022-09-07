package com.group.librayapp.calculator

import com.group.libraryapp.calculator.Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class JunitCalculatorTest {

    @Test
    fun addTest() {
        // given
        val calculator = Calculator(5)

        // when
        calculator.add(5)

        // then
        Assertions.assertEquals(10, calculator.number)
    }

    @Test
    fun minusTest() {
        // given
        var calculator = Calculator(5);

        // when
        calculator.minus(3)

        // then
        Assertions.assertEquals(2, calculator.number)
    }

    @Test
    fun multiply() {
        // given
        var calculator = Calculator(5);

        // when
        calculator.multiply(10)

        // then
        Assertions.assertEquals(50, calculator.number)
    }

    @Test
    fun divideTest() {
        // given
        var calculator = Calculator(5);

        // when
        calculator.divide(2)

        // then
        Assertions.assertEquals(2, calculator.number)
    }

    @Test
    fun divideExceptionError() {
        // given
        var calculator = Calculator(5);

        // when
        var message = assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.apply {
            Assertions.assertEquals("0으로 나눌 수 없습니다.", message)
        }
    }
}