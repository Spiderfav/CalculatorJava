package specificstack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import entry.BadTypeException;
import entry.Symbol;
import stack.EmptyStackExtension;

/**
 * @author Rui Favinha
 *
 */

public class OpStackTests {

  @Test // Test 1
  // Tests the creation of a new NumStack.
  
  void create_op_stack() {
    assert (new OpStack()) != null;
   }
  
  @Test // Test 2
  // Tests if the stack is empty.
  void empty_stack() {
    OpStack testStack = new OpStack();
    assertTrue(testStack.isEmpty());
   }
  
  @Test // Test 3
  // Tests if we can push a Symbol unto a OpStack.
  
  void push_op_stack() {
    OpStack testStack = new OpStack();
    Symbol testSymbol = Symbol.LEFT_BRACKET;
    testStack.push(testSymbol);
   }
  
  @Test // Test 4
  // Tests if we can push a Symbol unto a OpStack and size changes.
  
  void push_change_size_op_stack() {
    OpStack testStack = new OpStack();
    Symbol testSymbol = Symbol.LEFT_BRACKET;
    testStack.push(testSymbol);
    assertFalse(testStack.isEmpty());
   }
  
  @Test // Test 5
  // Tests we can pop OpStack and a value is returned.
  void push_pop_op_stack() throws EmptyStackExtension, BadTypeException {
    OpStack testStack = new OpStack();
    Symbol testSymbol = Symbol.LEFT_BRACKET;
    testStack.push(testSymbol);
    assertEquals(testStack.pop(),Symbol.LEFT_BRACKET);
   }
  
  @Test // Test 6
  // Tests that OpStack cannot be empty and popped.
  void pop_empty_op_stack() throws EmptyStackExtension, BadTypeException {
    OpStack testStack = new OpStack();
    
    assertThrows(EmptyStackExtension.class, 
        () -> {
          testStack.pop();
        });
 
   }
  
  
  
}
