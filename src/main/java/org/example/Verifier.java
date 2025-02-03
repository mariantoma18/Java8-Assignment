package org.example;


public class Verifier {

  public boolean verifyMonth(String dateOfBirth, int month) {

    if (dateOfBirth.split("\\.").length == 3) {

      String[] parts = dateOfBirth.split("\\.");
      if (Integer.parseInt(parts[1]) == month) {
        return true;
      }
    }

    return false;
  }
}
