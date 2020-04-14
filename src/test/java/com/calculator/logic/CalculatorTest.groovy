package com.calculator.logic

import spock.lang.Specification

import static TestParameters.*

class CalculatorTest extends Specification {

    def "Should calculate result of given list of instructions"() {
        given: "An instance of Calculator"
        def calculator = new Calculator();
        when: "The calculateResult method is ran"
        def result = calculator.calculateResult(testInstructions)
        then: "result should be as #expectedResult"
        result == expectedResult
        where:
        testInstructions || expectedResult
        instructions1    || 55
        instructions2    || 300
        instructions3    || 7
        instructions4    || 24
        instructions5    || 2
        instructions6    || 0
        instructions7    || -5
        instructions8    || 175
        instructions9    || 24
        instructions10   || 1100
        instructions11   || 6
        instructions12   || 20
    }
}
