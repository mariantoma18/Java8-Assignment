package org.example;

import java.util.Scanner;

public class UserInput {

  public Scanner scanner;

  public UserInput(Scanner scanner) {
    this.scanner = scanner;
  }

  public UserInput() {
    this.scanner = new Scanner(System.in);
  }

  /*
  Method used to get a month from the user;
   */
  public int getMonthFromUser() {

    System.out.print("\nWhat month should we look for?" + "\nAnswer:");
    return scanner.nextInt();
  }
}
