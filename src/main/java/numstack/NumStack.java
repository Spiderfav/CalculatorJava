package numstack;

import entry.BadTypeException;
import entry.Entry;
import stack.EmptyStackExtension;
import stack.Stack;

/**
 * @author Rui Favinha
 *
 * 
 */


public class NumStack {
  
  private Stack numStack = new Stack();
  
  public void push(float f) {
    Entry converted = new Entry(f);
    numStack.push(converted);
  }

  public float pop() throws EmptyStackExtension, BadTypeException {
    Entry toPop = numStack.pop();
    return toPop.getValue();
  }

  public boolean isEmpty() {
    return (numStack.size() == 0);
  }

}
