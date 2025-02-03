package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {

  Verifier verifier = new Verifier();
  UserInput user = new UserInput();

  public List<String> collectPeopleWithSameMonthOfBirth(Path input) {
    List<String> peopleWithTheSameMonthOfBirth;
    try (Stream<String> lines = Files.lines(input)) {

      int targetMonth = user.getMonthFromUser();

      peopleWithTheSameMonthOfBirth =
          lines
              .map(line -> line.split(","))
              .filter(parts -> parts.length == 3)
              .filter(parts -> verifier.verifyMonth(parts[2], targetMonth))
              .map(parts -> parts[0].trim() + " " + parts[1].trim())
              .sorted(String::compareTo)
              .collect(Collectors.toList());

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return peopleWithTheSameMonthOfBirth;
  }

  public void writeToFile(Path output, List<String> peopleWithTheSameMonthOfBirth) {
    try {
      Files.write(output, peopleWithTheSameMonthOfBirth);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
