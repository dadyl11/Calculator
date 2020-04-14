package com.calculator.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

  InputValidator inputValidator = new InputValidator();

  public List<String[]> readInputFile(String fileName) {
    List<String[]> instructions = new ArrayList<>();
    BufferedReader bufferedReader = null;
    InputStream inputStream = null;
    try {
      inputStream = getClass().getResourceAsStream(fileName);
      if (inputStream == null) {
        throw new IllegalArgumentException("File is empty or does not exist.");
      }
      bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      int count = 0;
      while ((line = bufferedReader.readLine()) != null) {
        inputValidator.validateInput(line);
        instructions.add(line.trim().toLowerCase().split("\\s+"));
        count++;
      }
      if (count == 0) {
        throw new IllegalArgumentException("File is empty or does not exist.");
      }
      inputValidator.validateApplyInstruction(instructions);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bufferedReader != null) {
          bufferedReader.close();
        }
      } catch (IOException e) {
      }
      try {
        if (inputStream != null) {
          inputStream.close();
        }
      } catch (IOException e) {
      }
    }
    return instructions;
  }
}
