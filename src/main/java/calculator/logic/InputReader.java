package calculator.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

  InputValidator inputValidator = new InputValidator();

  public List<String[]> readInputFile(String path) {
    List<String[]> instructions = new ArrayList<>();
    String[] splitLine = null;
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = br.readLine()) != null) {
        inputValidator.validateInput(line);
        instructions.add(line.split("\\s+"));
      }
      inputValidator.validateApplyInstruction(instructions);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return instructions;
  }
}
