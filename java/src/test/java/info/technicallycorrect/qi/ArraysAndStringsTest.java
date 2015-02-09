package info.technicallycorrect.qi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ArraysAndStringsTest {

  @Test
  public void uniqueChars() {
    assertTrue(assertUniqueEquals("Hwasung"));
    assertFalse(assertUniqueEquals("Melanie"));
  }
  
  private static boolean assertUniqueEquals(final String input) {
    assertEquals(ArraysAndStrings.uniqueChars(input),
                 ArraysAndStrings.uniqueCharsWithoutExtraDataStructure(input));
    return ArraysAndStrings.uniqueChars(input);
  }

}
