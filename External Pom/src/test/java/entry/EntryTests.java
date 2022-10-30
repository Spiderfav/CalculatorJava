package entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


/**
 * The class to test all the operations that can be performed on an Entry.
 * @author Rui Favinha
 *
 */

class EntryTests {

  @Test // Test 5, Checking that the constructors are assigning right values.
  // To test this then, we are querying the getters of entry and checking for the right values.
  // Had to surround the asserts with try-catch blocks later for checking for invalid input.
  
  void creating_entry() {
    
    Symbol timesSymbol = Symbol.TIMES;
    
    Entry simpleFloat = new Entry(1.0f);
    Entry timesEntry = new Entry(timesSymbol);
    
    try {
      assertEquals(simpleFloat.getValue(), 1.0f);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    assertEquals(simpleFloat.getType(), Type.NUMBER);

    assertEquals(simpleFloat.getString(), "1.0");

    
    try {
      assertEquals(timesEntry.getSymbol(), timesSymbol);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    assertEquals(timesEntry.getType(), Type.SYMBOL);
    
    assertEquals(timesEntry.getString(), "*");
        
  }
  
  @Test // Test 6
  // Checking for invalid data to be retrieved as Entry does not contain given data.
  
  void test_outliers() {
    Symbol which = Symbol.TIMES;
    Entry efloat1 = new Entry(1.0f);
    Entry esymbol1 = new Entry(which);
    
    
    assertThrows(BadTypeException.class, 
        () -> {
          efloat1.getSymbol();
        });
    
    assertThrows(BadTypeException.class, 
        () -> {
          esymbol1.getValue();
        });

    
  }
  
  @Test // Test 7
  // Here we are testing the equals method of Entry as well as its hash code.
  
  void test_equals_and_hash() {
    
    Entry float1 = new Entry(1.0f);
    Entry float2 = new Entry(5.0f);
    
    assertFalse(float1.equals(float2));
    
    assertTrue(float1.equals(float1));
    
    assertEquals(float1.hashCode(), float1.hashCode()); 
    
    assertNotSame(float1.hashCode(), float2.hashCode());
    
    Symbol timesSymbol = Symbol.TIMES;
    Symbol leftbracketSymbol = Symbol.LEFT_BRACKET;
    
    Entry symbol1 = new Entry(timesSymbol);
    Entry symbol2 = new Entry(leftbracketSymbol);
    
    assertFalse(symbol1.equals(symbol2));
    
    assertTrue(symbol1.equals(symbol1));
    
    assertEquals(symbol1.hashCode(), symbol1.hashCode()); 
    
    assertNotSame(symbol1.hashCode(), symbol2.hashCode());
   
  }
  

}
