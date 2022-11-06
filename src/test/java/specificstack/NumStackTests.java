/**
 * 
 */
package specificstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import entry.BadTypeException;
import stack.EmptyStackExtension;

/**
 * @author Rui Favinha
 *
 */
class NumStackTests {

  @Test // Test 1
  // Tests the creation of a new NumStack.
  
  void create_num_stack() {
    assert (new NumStack()) != null;
   }
  
  @Test // Test 2
  // Tests if the stack is empty.
  void empty_stack() {
    NumStack testStack = new NumStack();
    assertTrue(testStack.isEmpty());
   }
  
  @Test // Test 3
  // Tests if we can push a float unto a stack.
  
  void push_num_stack() {
    NumStack testStack = new NumStack();
    testStack.push(10.0f);
   }
  
  @Test // Test 4
  // Tests if we can push a float unto a stack and size changes.
  
  void push_change_size_num_stack() {
    NumStack testStack = new NumStack();
    testStack.push(10.0f);
    assertFalse(testStack.isEmpty());
   }
  
  @Test // Test 5
  // Tests we can pop NumStack and a value is returned.
  void push_pop_num_stack() throws EmptyStackExtension, BadTypeException {
    NumStack testStack = new NumStack();
    testStack.push(10.0f);
    assertEquals(testStack.pop(), 10.0f);
   }
  
  @Test // Test 6
  // Tests that NumStack cannot be empty and popped.
  void pop_empty_num_stack() throws EmptyStackExtension, BadTypeException {
    NumStack testStack = new NumStack();
    
    assertThrows(EmptyStackExtension.class, 
        () -> {
          testStack.pop();
        });
 
   }
  
  
  
}
