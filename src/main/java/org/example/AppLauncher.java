package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
Class used to start the app
 */
public class AppLauncher {

  public static void appStart() {
    FileManager manager = new FileManager();

    Path input = Paths.get("input.txt");
    Path output = Paths.get("output.txt");

    List<String> peopleWithTheSameMonthOfBirth = manager.collectPeopleWithSameMonthOfBirth(input);

    manager.writeToFile(output, peopleWithTheSameMonthOfBirth);
  }
}
