import java.util.ArrayList;
import java.util.List;
import logic.Calculator;
import logic.InputReader;
import logic.InputValidator;

public class Demo {

  public static void main(String[] args) {

    final String FILE_PATH = "src/main/resources/input.txt";
    InputReader inputReader = new InputReader();
    InputValidator inputValidator = new InputValidator();
    Calculator calculator = new Calculator();
    List<String[]> lines = inputReader.readInputFile(FILE_PATH);
    inputValidator.validateApplyInstruction(lines);
    int result = calculator.calculateResult(lines);
    System.out.println(result);
  }
}
