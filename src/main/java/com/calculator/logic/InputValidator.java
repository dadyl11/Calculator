package com.calculator.logic;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

  public void validateInput(String instruction) {
    String[] splittedInstruction = instruction.split("\\s+");
    if (!(splittedInstruction.length == 2)) {
      throw new IllegalArgumentException(
          "Incorrect format of the instruction. Instruction should contain two arguments separated by one or more spaces.");
    }
    if (!isNumeric(splittedInstruction[1])) {
      throw new IllegalArgumentException("The second part of the instruction should be a number.");
    }
    if (!isValidInstruction(splittedInstruction[0])) {
      throw new IllegalArgumentException(
          "The first part of the instruction needs to be one of the arithmetic operations: add, divide, subtract, multiply.");
    }
  }

  public void validateApplyInstruction(List<String[]> inputAsList) {
    String[] lastInstruction = inputAsList.get(inputAsList.size() - 1);
    if (!lastInstruction[0].equals("apply")) {
      throw new IllegalArgumentException("Input file should contain 'apply' instruction at the end.");
    }
  }

  private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

  private boolean isNumeric(String stringNumber) {
    if (stringNumber == null) {
      return false;
    }
    return pattern.matcher(stringNumber).matches();
  }

  private Pattern instructionPattern = Pattern.compile("\\badd|divide|subtract|multiply|apply\\b", Pattern.CASE_INSENSITIVE);

  private boolean isValidInstruction(String instructionText) {
    if (instructionText == null) {
      return false;
    }
    return instructionPattern.matcher(instructionText).matches();
  }
}
