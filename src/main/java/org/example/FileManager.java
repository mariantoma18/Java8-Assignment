package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {

  Verifier verifier = new Verifier();
  UserInput user = new UserInput();

  public FileManager(UserInput user) {
    this.user = user;
  }

  public FileManager() {}

  /*
  This method reads the file content, processes it line by line,
  splits the content into parts using the "," separator,
  filters the people if all the data exists and if the birth month is correct,
  sorts the filtered people by name, and returns them in a list.
   */
  public List<String> collectPeopleWithSameMonthOfBirth(Path input) {
    List<String> peopleWithTheSameMonthOfBirth = new ArrayList<>();

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
      System.out.println("Error: " + e.getMessage());
    }
    return peopleWithTheSameMonthOfBirth;
  }

  /*
  Method used to write the list of people to a file.
   */
  public void writeToFile(Path output, List<String> peopleWithTheSameMonthOfBirth) {
    try {
      Files.write(output, peopleWithTheSameMonthOfBirth);
      System.out.println("\nThe list has been successfully written to the specified file.");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
