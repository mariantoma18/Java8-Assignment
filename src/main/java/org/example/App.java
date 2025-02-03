package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
  public static void main(String[] args) {

    FileManager manager = new FileManager();

    Path input = Paths.get("input.txt");
    Path output = Paths.get("output.txt");

    List<String> peopleWithTheSameMonthOfBirth = manager.collectPeopleWithSameMonthOfBirth(input);
    manager.writeToFile(output, peopleWithTheSameMonthOfBirth);
  }
}
