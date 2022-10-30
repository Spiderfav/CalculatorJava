package entry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class EntryTests {

  @Test // Test 5, Checking that the class can be created.
  // Refactored due to the constructor changing.
  
  void creating_entry() {
    
    assert (new Entry(1.0f) != null);
  }
  
  @Test // Test 6, Checking for both constructors.
  
  void creating_correct_entry() {
    
    Symbol timesSymbol = Symbol.TIMES;
    
    assert (new Entry(1.0f) != null);
    assert (new Entry(timesSymbol) != null);
        
  }
  
  @Test // Test 7, Checking that the constructors are assigning right values.
  // To test this then, we are querying the getters of entry and checking for the right values.
  // Refactored to allow the correct data to be tested when getting type and string.
  // Refactored again to surround the asserts with try-catch blocks later for checking for invalid getter.
  
  void test_get_value() {
       
    Entry simpleFloat = new Entry(1.0f);
    
    
    try {
      assertEquals(simpleFloat.getValue(), 1.0f);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    assertEquals(simpleFloat.getType(), Type.NUMBER);

    assertEquals(simpleFloat.getString(), "1.0");
        
  }
  
  @Test // Test 8, Checking that the getters retrieve right values, making sure they are not the same.
  //Refactored again to surround the asserts with try-catch blocks later for checking for invalid getter.
  
  void test_get_value2() {
       
    Entry simpleFloat = new Entry(1.0f);
    
    Entry simpleFloat2 = new Entry(5.0f);
    
    
    try {
      assertEquals(simpleFloat.getValue(), 1.0f);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    assertEquals(simpleFloat.getType(), Type.NUMBER);

    assertEquals(simpleFloat.getString(), "1.0");
    
    try {
      assertEquals(simpleFloat2.getValue(), 5.0f);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    assertEquals(simpleFloat2.getType(), Type.NUMBER);

    assertEquals(simpleFloat2.getString(), "5.0");
        
  }
  
  @Test // Test 9, Similar to test above however, this time checking for data when created with Symbol.
  // Refactored to allow to retrieve the correct symbol.
  // Refactored for the throws clause.
  
  void test_getters_symbol() {
    Symbol timesSymbol = Symbol.TIMES;

    
    Entry timesEntry = new Entry(timesSymbol);
    
    try {
      assertEquals(timesEntry.getSymbol(), timesSymbol);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    assertEquals(timesEntry.getType(), Type.SYMBOL);
    
    assertEquals(timesEntry.getString(), "*");
  }
  
  @Test // Test 10, retrieving data from two entries, making sure they are not the same.
  // Refactored for the throws clause.
  
  void test_getters_symbol2() {
    Symbol timesSymbol = Symbol.TIMES;

    Symbol divideSymbol = Symbol.DIVIDE;
    
    Entry timesEntry = new Entry(timesSymbol);
    Entry divideEntry = new Entry(divideSymbol);
    
    try {
      assertEquals(timesEntry.getSymbol(), timesSymbol);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }
    
    try {
      assertEquals(divideEntry.getSymbol(), divideSymbol);
    } catch (BadTypeException e) {
      e.printStackTrace();
    }

  }
  
  @Test // Test 11
  // Checking for invalid data to be retrieved as Entry does not contain given data with each constructor.
  
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
  
  @Test // Test 12
  // Here we are testing the equals method of Entry with a float constructor.
  
  void test_equals_float() {
    
    Entry float1 = new Entry(1.0f);
    
    assertTrue(float1.equals(float1));
   
  }
  
  @Test // Test 13
  // Here we are testing the equals method of Entry with a float constructor, making sure does not always equal.
  
  void test_not_equals_float() {
    
    Entry float1 = new Entry(1.0f);
    Entry float2 = new Entry(5.0f);
    
    assertFalse(float1.equals(float2));
    
    assertTrue(float1.equals(float1));
   
  }
  
  @Test // Test 14
  // Here we are testing the equals method of Entry with a Symbol constructor.
  
  void test_equals_symbol() {

    Symbol timesSymbol = Symbol.TIMES;
    Symbol leftbracketSymbol = Symbol.LEFT_BRACKET;
    
    Entry symbol1 = new Entry(timesSymbol);
    Entry symbol2 = new Entry(leftbracketSymbol);
    
    assertFalse(symbol1.equals(symbol2));
    
    assertTrue(symbol1.equals(symbol1));

  }
  
  @Test // Test 15
  // Here we are testing the hash code of each object; created by a float.
  
  void test_hash_float() {
    
    Entry float1 = new Entry(1.0f);
    
    assertEquals(float1.hashCode(), float1.hashCode()); 
    
  }
  
  @Test // Test 16
  // Here we are testing the hash code of each Entry; created with a float, not being equal.
  
  void test_hash_not_equal_float() {
    
    Entry float1 = new Entry(1.0f);
    Entry float2 = new Entry(5.0f);
    
    assertEquals(float1.hashCode(), float1.hashCode()); 
    
    assert (float1.hashCode() != float2.hashCode());
    
  }

  
  @Test // Test 17
  //Here we are testing the hash code of each Entry; created with a Symbol.
  
  void test_hash_symbol() {
    
    Symbol timesSymbol = Symbol.TIMES;
    
    Entry symbol1 = new Entry(timesSymbol);
    
    assertEquals(symbol1.hashCode(), symbol1.hashCode()); 
    
   
  }

  @Test // Test 18
  //Here we are testing the hash code of each Entry; created with a Symbol, not being equal.
  
  void test_hash_not_equal_symbol() {
    
    Symbol timesSymbol = Symbol.TIMES;
    Symbol leftbracketSymbol = Symbol.LEFT_BRACKET;
    
    Entry symbol1 = new Entry(timesSymbol);
    Entry symbol2 = new Entry(leftbracketSymbol);
    
    assertEquals(symbol1.hashCode(), symbol1.hashCode()); 
    
    assert (symbol1.hashCode() != symbol2.hashCode());
   
  }
  
  @Test // Test 19
  //Here we are testing the hash code of an Entry, making sure they cannot be equal.
  
  void test_hash_float_and_symbol() {
    
    Entry float1 = new Entry(0.0f);
    
    Symbol leftbracketSymbol = Symbol.LEFT_BRACKET;
    Entry symbol1 = new Entry(leftbracketSymbol);

    assert (symbol1.hashCode() != float1.hashCode());
   
  }
  

}
