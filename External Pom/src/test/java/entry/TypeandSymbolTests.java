package entry;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Class to test all operations that can be performed in the Enums.
 * @author Rui Favinha
 *
 */

class TypeandSymbolTests {
  
  @Test // Test 1 
  // Test creation of object Type
  
  void create_type() { 
    Type testType = Type.NUMBER;
    assertTrue(testType.equals(Type.NUMBER));
    
  }
  
  @Test // Test 2
  //Test creation of object Symbol
  
  void create_symbol() {
    Symbol testSymb = Symbol.TIMES;
    assertTrue(testSymb.equals(Symbol.TIMES));
  }
  
  @Test // Test 3
  //Test that toString method works for a Type
  
  void string_type() {
    Type testType = Type.NUMBER;
    assert (testType.toString() == "NUMBER");
  }
  
  @Test // Test 4
  //Test that toString method works for a Symbol
  
  void string_symbol() {
    Symbol testSymb = Symbol.TIMES;
    assert (testSymb.toString() == "*");
  }

}
