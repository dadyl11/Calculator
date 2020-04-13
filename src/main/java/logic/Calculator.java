package logic;

import java.util.List;

public class Calculator {

  private int currentNumber;

  public int calculateResult(List<String[]> instructions){
    int currentNumber = getStartNumber(instructions);
    int result = 0;
    for (int i = 0; i < instructions.size()-1; i++){
      result = executeInstruction(instructions.get(i), currentNumber);
      currentNumber = result;
    }
    return result;
  }

  private int getStartNumber(List<String[]> instructions){
    String startNumberText = instructions.get(instructions.size()-1)[1];
    return Integer.parseInt(startNumberText);
  }
  private int executeInstruction(String[] instruction, int currentNumber){
    this.currentNumber = currentNumber;
    int instructionNumber = Integer.parseInt(instruction[1]);
    switch (instruction[0]){
      case "add":
        currentNumber += instructionNumber;
        break;
      case "divide":
        currentNumber /= instructionNumber;
        break;
      case "subtract":
        currentNumber -= instructionNumber;
        break;
      case "multiply":
        currentNumber *= instructionNumber;
        break;
    }
    return currentNumber;
  }
}
