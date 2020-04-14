package logic.spock

import calculator.logic.Calculator
import spock.lang.Shared
import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.Stream

class CalculatorTest extends Specification {

    @Shared List<String[]> list1 = Arrays.asList(new String[]{"add", "4"}, new String[]{"apply", "4"});
    @Shared List<String[]> list2 = Arrays.asList(new String[]{"add", "5"}, new String[]{"apply", "7"});



    def "Should calculate result of given list of instructions"() {
        given: "An instance of Calculator"
            def calculator = new Calculator();
        when: "The calculateResult method is ran"
            def result = calculator.calculateResult(testInstructions)
        then: "result should be as #expectedResult"
            result == expectedResult
        where:
            testInstructions ||   expectedResult
            list1     ||   8
            list2     ||  12
    }

}
