package com.calculator.logic

import spock.lang.Specification

import static TestParameters.*

class InputReaderTest extends Specification {

    private InputReader inputReader = new InputReader();

    def "Should read input file and return a list of arrays"() {
        when: "The readInputFile method is ran"
        def actualListOfInstructions = inputReader.readInputFile(fileName)
        then: "result should be as #expectedResult"
        actualListOfInstructions == expectedResult
        where:
        fileName       || expectedResult
        "/input1.txt"  || instructions1
        "/input2.txt"  || instructions2
        "/input3.txt"  || instructions3
        "/input4.txt"  || instructions4
        "/input5.txt"  || instructions5
        "/input6.txt"  || instructions6
        "/input7.txt"  || instructions7
        "/input8.txt"  || instructions8
        "/input9.txt"  || instructions9
        "/input10.txt" || instructions10
        "/input11.txt" || instructions11
        "/input12.txt" || instructions12
    }

    def "Should throw an Illegal argument exception from validation class when putting more than two words in the instruction line"() {
        given: "A file name"
        def fileName = "/exception1.txt"
        when: "The readInputFile method is ran"
        inputReader.readInputFile(fileName)
        then:
        IllegalArgumentException e = thrown()
        e.message == "Incorrect format of the instruction. Instruction should contain two arguments separated by one or more spaces."
    }

    def "Should throw an Illegal argument exception when putting one word in the instruction line"() {
        given: "A file name"
        def fileName = "/exception2.txt"
        when: "The readInputFile method is ran"
        inputReader.readInputFile(fileName)
        then:
        IllegalArgumentException e = thrown()
        e.message == "Incorrect format of the instruction. Instruction should contain two arguments separated by one or more spaces."
    }

    def "Should throw an Illegal argument exception when putting non numeric value as a second argument in the instruction line"() {
        given: "A file name"
        def fileName = "/exception3.txt"
        when: "The readInputFile method is ran"
        inputReader.readInputFile(fileName)
        then:
        IllegalArgumentException e = thrown()
        e.message == "The second part of the instruction should be a number."
    }

    def "Should throw an Illegal argument exception when putting wrong first argument in the instruction line"() {
        given: "A file name"
        def fileName = "/exception4.txt"
        when: "The readInputFile method is ran"
        inputReader.readInputFile(fileName)
        then:
        IllegalArgumentException e = thrown()
        e.message == "The first part of the instruction needs to be one of the arithmetic operations: add, divide, subtract, multiply."
    }

    def "Should throw an Illegal argument exception when putting empty file or file does not exist"() {
        given: "A file name"
        def fileName = "/exception5.txt"
        when: "The readInputFile method is ran"
        inputReader.readInputFile(fileName)
        then:
        IllegalArgumentException e = thrown()
        e.message == "File is empty or does not exist."
    }
}
