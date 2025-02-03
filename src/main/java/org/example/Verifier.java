package org.example;


public class Verifier {

  /*
  It verifies if the month is complete, then splits it into parts and returns true if it corresponds with the input month
   */
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
