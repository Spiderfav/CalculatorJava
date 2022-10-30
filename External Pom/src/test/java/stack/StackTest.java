package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import entry.Entry;
import entry.Symbol;
import org.junit.jupiter.api.Test;


/**
 * Contained in this file are all the tests for the Stack Class.
 * @author Rui Favinha
 */

class StackTest {

  @Test // Test 8
  // Testing if both types of entries can be inserted into the stack and that size changes.
  
  void test_push() {
    
    Stack classicStack = new Stack();
    
    Entry testEntry = new Entry(5.0f);   
    
    assertTrue(classicStack.size() == 0);
    classicStack.push(testEntry);
    assertTrue(classicStack.size() == 1);
    
    Entry newEntry = new Entry(Symbol.LEFT_BRACKET);
    classicStack.push(newEntry);
    assertTrue(classicStack.size() == 2);
    
  }
  
  
  
  @Test // Test 9
  // Testing that Entries can be pushed onto the stack and that the size changes when popped.
  
  void test_pop() {
    
    Stack classicStack = new Stack();
    Entry testEntry = new Entry(5.0f);
    
    classicStack.push(testEntry);
    
    try {
      assertEquals(classicStack.top(), testEntry);
    } catch (EmptyStackExtension e) {
      e.printStackTrace();
    }
    
    try {
      assertEquals(classicStack.pop(), testEntry);
    } catch (EmptyStackExtension e) {
      e.printStackTrace();
    }
    assertTrue(classicStack.size() == 0);
  }
  
  @Test // Test 10
  // Testing that when adding new entries, top changes to the new head.
  // In test 9, the function was built so that it always retrieved item at position 0.

  void test_top() {
    
    Stack classicStack = new Stack();
    Entry testEntry = new Entry(5.0f);
    Entry newEntry = new Entry(Symbol.LEFT_BRACKET);
    
    classicStack.push(testEntry);
    classicStack.push(newEntry);
    
    try {
      assertEquals(classicStack.top(), newEntry);
    } catch (EmptyStackExtension e) {
      e.printStackTrace();
    }
  }
  
  
  @Test // Test 11
  // Tests that the stack cannot be popped if the Stack is empty.
  // Also tests that top throws exception when Stack is empty.
  
  void test_invalid_pop_and_top() {
    Stack classicStack = new Stack();
      
    assertThrows(EmptyStackExtension.class, 
        () -> {
          classicStack.top();
        });
 
    assertThrows(EmptyStackExtension.class, 
        () -> {
          classicStack.pop();
        });  
   
  }

}
