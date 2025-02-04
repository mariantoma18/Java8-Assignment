package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VerifierTest {

  Verifier verifier = new Verifier();

  @Test
  void verifyMonthWithValidData() {

    assertTrue(verifier.verifyMonth("25.07.1999",7));
  }

  @Test
  void verifyMonthWithNoValidData() {

    assertFalse(verifier.verifyMonth("25.07", 7));
  }
}
