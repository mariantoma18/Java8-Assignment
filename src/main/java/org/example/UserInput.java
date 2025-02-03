package org.example;

import java.util.Scanner;

public class UserInput {

  public int getMonthFromUser() {

    Scanner scanner = new Scanner(System.in);
    System.out.print("\nWhat month should we look for?" + "\nAnswer:");
    return scanner.nextInt();
  }
}
