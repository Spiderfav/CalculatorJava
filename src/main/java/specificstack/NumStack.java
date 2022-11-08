package specificstack;

import entry.BadTypeException;
import entry.Entry;
import stack.EmptyStackExtension;
import stack.Stack;

/**
 * NumStack class is a facade of the Stack class that deals with float objects.
 * @author Rui Favinha
 */


public class NumStack {
  
  private Stack numStack = new Stack();
  
  /**
   * Function to append a value to the NumStack.
   * @param f as the float to be added to the stack.
   */

  public void push(float f) {
    Entry converted = new Entry(f);
    numStack.push(converted);
  }
  
  /**
   * Function remove a value and return it from a NumStack.
   * @return The value popped from the NumStack as a float.
   * @throws EmptyStackExtension if size of the stack is 0.
   * @throws BadTypeException if it could not return a float.
   */

  public float pop() throws EmptyStackExtension, BadTypeException {
    Entry toPop = numStack.pop();
    return toPop.getValue();
  }

  /**
   * Function to return the size of the NumStack at the current time.
   * @return The Size of the NumStack.
   */
  
  public boolean isEmpty() {
    return (numStack.size() == 0);
  }

}
