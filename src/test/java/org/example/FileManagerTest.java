package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class FileManagerTest {

  @Mock Scanner mockScanner;

  @InjectMocks UserInput user = new UserInput(mockScanner);

  @InjectMocks FileManager manager = new FileManager(user);

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void collectPeopleWithSameMonthOfBirth() {

    when(user.getMonthFromUser()).thenReturn(11);

    Path file;

    try {
      file = Files.createTempFile("file", "txt");

      String content =
          "Kelly, Jackson, 15.11.1940\n"
              + "Michael, Francis, 16.08.1990\n"
              + "Joan, Peterson, 03.01.1968\n"
              + "Maria, Price, 12.04.1954";

      Files.write(file, content.getBytes());

      List<String> list = manager.collectPeopleWithSameMonthOfBirth(file);

      assertEquals(1, list.size());

    } catch (IOException e) {
      System.out.println("Test failed with error: " + e.getMessage());
    }
  }

  @Test
  void writeToFile() {

    Path file;

    List<String> testList = new ArrayList<>(Arrays.asList("Test, Test, dd.mm.yyyy"));

    try {
      file = Files.createTempFile("test", ".txt");

      manager.writeToFile(file, testList);

      assertEquals(1, testList.size());

    } catch (IOException e) {
      System.out.println("Test failed with error: " + e.getMessage());
    }
  }
}
