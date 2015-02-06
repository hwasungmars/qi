package info.technicallycorrect.qi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ArraysAndStringsTest {

  @Test
  public void uniqueChars() {
    assertEquals(ArraysAndStrings.uniqueChars("unique"),
                 ArraysAndStrings.uniqueCharsWithoutExtraDataStructure("unique"));
    assertTrue(ArraysAndStrings.uniqueChars("unique"));
  }

}
