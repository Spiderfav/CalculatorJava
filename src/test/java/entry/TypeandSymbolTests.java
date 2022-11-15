package entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


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
  
  
  // NEW TESTS FOR COURSEWORK 2
  
  @Test // Test 1
  //Test that toString method works for a Symbol
  
  void convert_to_symbol() {
    String symbol = "*";
    
    assertEquals (Symbol.convertString(symbol), Symbol.TIMES);
  }
  
  @Test // Test 2
  //Test that toString method shows invalid for non symbol
  
  void convert_to_symbol_invalid_letter() {
    String symbol = "g";
    
    assertEquals (Symbol.convertString(symbol), Symbol.INVALID);
  
  }
  
  @Test // Test 3
  //Test that toString method shows invalid for non symbol
  
  void convert_to_symbol_invalid_number() {
    String symbol = "9";
    
    assertEquals (Symbol.convertString(symbol), Symbol.INVALID);
  
  
  }
}
