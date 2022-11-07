package specificstack;

import entry.BadTypeException;
import entry.Entry;
import entry.Symbol;
import stack.EmptyStackExtension;
import stack.Stack;

/**
 * OpStack class is a facade of the Stack class that deals with Symbol objects.
 * @author Rui Favinha
 */


public class OpStack {

  private Stack opStack = new Stack();
  
  /**
   * Function to append a value to the OpStack.
   * @param s as the Symbol to be added to the stack.
   */

  
  public void push(Symbol s) {
    Entry converted = new Entry(s);
    opStack.push(converted);
  }
  
  /**
   * Function remove a value and return it from a OpStack.
   * @return The value popped from the OpStack as a Symbol.
   * @throws EmptyStackExtension if size of the stack is 0.
   * @throws BadTypeException if it could not return a Symbol.
   */
  
  public Symbol pop() throws EmptyStackExtension, BadTypeException {
    Entry toPop = opStack.pop();
    return toPop.getSymbol();
  }
  
  /**
   * Function to return the size of the OpStack at the current time.
   * @return The Size of the OpStack.
   */

  public boolean isEmpty() {
    return (opStack.size() == 0);
  }

}
