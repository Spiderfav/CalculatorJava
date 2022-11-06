package specificstack;

import entry.BadTypeException;
import entry.Entry;
import entry.Symbol;
import stack.EmptyStackExtension;
import stack.Stack;

/**
 * @author Rui Favinha
 *
 * 
 */


public class OpStack {

  private Stack opStack = new Stack();
  
  public void push(Symbol s) {
    Entry converted = new Entry(s);
    opStack.push(converted);
  }

  public Symbol pop() throws EmptyStackExtension, BadTypeException {
    Entry toPop = opStack.pop();
    return toPop.getSymbol();
  }

  public boolean isEmpty() {
    return (opStack.size() == 0);
  }

}
