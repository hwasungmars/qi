package info.technicallycorrect.qi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ArraysAndStringsTest {

  @Test
  public void uniqueChars() {
    assertFalse(ArraysAndStrings.uniqueChars("Melanie"));
    assertTrue(ArraysAndStrings.uniqueChars("Hwasung"));

  }

}
