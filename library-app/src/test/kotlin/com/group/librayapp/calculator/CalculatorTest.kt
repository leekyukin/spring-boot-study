package com.group.librayapp.calculator

import com.group.libraryapp.calculator.Calculator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.nio.channels.IllegalChannelGroupException

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

    fun divideTest() {
        // given
        var calculator = Calculator(5);

        // when
        calculator.divide(2)

        // then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }

    fun divideExceptionError() {
        // given
        var calculator = Calculator(5);

        // when
        try {
            calculator.divide(0)
        } catch (e: IllegalArgumentException) {
            if (e.message != "0으로 나눌 수 없습니다.") {
                throw IllegalStateException("메세지가 다릅니다.")
            }
            return
        } catch (e: Exception) {
            throw IllegalStateException()
        }

        throw IllegalStateException("기대하는 예외 발생하지 않음")
    }
}