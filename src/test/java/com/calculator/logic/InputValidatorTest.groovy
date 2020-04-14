package com.calculator.logic


import spock.lang.Specification

class InputValidatorTest extends Specification {

    private InputValidator inputValidator = new InputValidator();

    def "Should throw an Illegal argument exception when put more than two words in the instruction line"() {
        given: "Instruction line"
        def instructionLine = "add 45 add"
        when: "The validateInput method is ran"
        inputValidator.validateInput(instructionLine)
        then:
        IllegalArgumentException e = thrown()
        e.message == "Incorrect format of the instruction. Instruction should contain two arguments separated by one or more spaces."
    }

    def "Should throw an Illegal argument exception when putting one word in the instruction line"() {
        given: "Instruction line"
        def instructionLine = "add "
        when: "The validateInput method is ran"
        inputValidator.validateInput(instructionLine)
        then:
        IllegalArgumentException e = thrown()
        e.message == "Incorrect format of the instruction. Instruction should contain two arguments separated by one or more spaces."
    }

    def "Should throw an Illegal argument exception when putting non numeric value as a second argument in the instruction line"() {
        given: "Instruction line"
        def instructionLine = "divide add"
        when: "The validateInput method is ran"
        inputValidator.validateInput(instructionLine)
        then:
        IllegalArgumentException e = thrown()
        e.message == "The second part of the instruction should be a number."
    }

    def "Should throw an Illegal argument exception when putting wrong first argument in the instruction line"() {
        given: "Instruction line"
        def instructionLine = "testinstruction 4"
        when: "The validateInput method is ran"
        inputValidator.validateInput(instructionLine)
        then:
        IllegalArgumentException e = thrown()
        e.message == "The first part of the instruction needs to be one of the arithmetic operations: add, divide, subtract, multiply."
    }

    def "Should throw an Illegal argument exception when 'apply' function is missing at the end of the collection"() {
        given: "Instruction line"
        def instructionsFromFile = Arrays.asList(new String[]{"add", "2"}, new String[]{"multiply", "3"}, new String[]{"divide", "2"});
        when: "The validateApplyInstruction method is ran"
        inputValidator.validateApplyInstruction(instructionsFromFile)
        then:
        IllegalArgumentException e = thrown()
        e.message == "Input file should contain 'apply' instruction at the end."
    }
}
