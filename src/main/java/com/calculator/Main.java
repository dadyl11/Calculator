package com.calculator;

import com.calculator.logic.Calculator;
import com.calculator.logic.InputReader;
import com.calculator.logic.InputValidator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    final List<String> FILE_NAMES = Arrays.asList(
        "/input1.txt",
        "/input2.txt",
        "/input3.txt",
        "/input4.txt",
        "/input5.txt",
        "/input6.txt",
        "/input7.txt",
        "/input8.txt",
        "/input9.txt",
        "/input10.txt",
        "/input11.txt",
        "/input12.txt"
    );
    InputReader inputReader = new InputReader();
    InputValidator inputValidator = new InputValidator();
    Calculator calculator = new Calculator();
    List<String[]> instructionLines;
    int result;
    for (String fileName:FILE_NAMES) {
      instructionLines = inputReader.readInputFile(fileName);
      inputValidator.validateApplyInstruction(instructionLines);
      result = calculator.calculateResult(instructionLines);
      System.out.println(fileName.substring(1) + " result = " +result);
    }
  }
}
