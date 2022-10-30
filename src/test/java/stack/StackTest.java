package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import entry.Entry;
import entry.Symbol;

class StackTest {
  
  @Test // Test 20
  // Tests the creation of a new Stack.
  
  void create_stack() {
   assert (new Stack()) != null;
  }

  @Test // Test 21
  // Testing if floats can be inserted into the stack.
  
  void test_push_float() {
    
    Stack classicStack = new Stack();
    
    Entry testEntry = new Entry(5.0f);   
   
    classicStack.push(testEntry);
  }
  
  @Test // Test 22
  // Testing that the size changes.
  
  void test_push_float_size() {
    
    Stack classicStack = new Stack();
    
    Entry testEntry = new Entry(5.0f);   
    
    assertTrue(classicStack.size() == 0);
    classicStack.push(testEntry);
    assertTrue(classicStack.size() == 1);
  }
  
  @Test // Test 23
  // Test that we can push to a stack and the size changes.
  void test_push_symbol() {
    
    Stack classicStack = new Stack();
    
    Entry testEntry = new Entry(Symbol.LEFT_BRACKET);
    
    assertTrue(classicStack.size() == 0);
    classicStack.push(testEntry);
    assertTrue(classicStack.size() == 1);
    
  }
  
  @Test // Test 24
  // Making sure that the stack size changes according to the new code.
  
  void test_push_both() {
    
    Stack classicStack = new Stack();
    
    Entry testEntry = new Entry(5.0f);   
    
    assertTrue(classicStack.size() == 0);
    classicStack.push(testEntry);
    assertTrue(classicStack.size() == 1);
    
    Entry newEntry = new Entry(Symbol.LEFT_BRACKET);
    classicStack.push(newEntry);
    assertTrue(classicStack.size() == 2);
    
  }
  
  @Test // Test 25
  // Making sure that the stack size changes according to the new code.
  void test_push_200items() {
    
    Stack classicStack = new Stack();
    
    Entry testEntry = new Entry(5.0f);   
    
    Entry newEntry = new Entry(Symbol.LEFT_BRACKET);
    
    for (int i = 0; i < 100; i++) {
      classicStack.push(newEntry);
    }

    for (int i = 0; i < 100; i++) {
      classicStack.push(testEntry);
    }
    
    assertTrue(classicStack.size() == 200);
  }
  
  @Test // Test 26
  // Testing that Entries can be pushed onto the stack and that the size changes when popped.
  // Refactored to include the "try-catch" block
  
  void test_pop() {
    
    Stack classicStack = new Stack();
    Entry testEntry = new Entry(5.0f);
    
    classicStack.push(testEntry);
    
    try {
      assertEquals(classicStack.pop(), testEntry);
    } catch (EmptyStackExtension e) {
      e.printStackTrace();
    }
    assertTrue(classicStack.size() == 0);
  }
  

  @Test // Test 27
  // Testing that when adding new entries, top changes to the new head.

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
  
  @Test // Test 28
  // Testing that when adding and removing entries, top changes the head accordingly.

  void test_top_and_pop() {
    
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
    
    try {
      assertEquals(classicStack.pop(), newEntry);
    } catch (EmptyStackExtension e) {
      e.printStackTrace();
    }
    
    try {
      assertEquals(classicStack.top(), testEntry);
    } catch (EmptyStackExtension e) {
      e.printStackTrace();
    }
    
    assertTrue(classicStack.size() == 1);
    
  }
  
  
  @Test // Test 29
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
