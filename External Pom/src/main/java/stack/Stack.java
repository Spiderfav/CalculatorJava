package stack;

import entry.Entry;
import java.util.ArrayList;

/**
 * Stack class creates a LIFO data structure with Entry objects.
 * @author Rui Favinha
 */

public class Stack {
  
  private int size;
  private ArrayList<Entry> entries = new ArrayList<Entry>();
  
  /**
   * Function to return the size of the current stack.
   * @return The size of the stack
   */

  public int size() {
    return this.size;
  }

  /**
   * Function to push an entry to the stack.
   * @param newEntry given as the entry to add to the stack.
   */
  
  public void push(Entry newEntry) {
    this.size += 1;
    this.entries.add(newEntry);
  }

  /**
   * Function to return the top of the current stack.
   * @return The entry at the top of the stack.
   * @throws EmptyStackExtension if size of the stack is 0.
   */
  
  public Entry top() throws EmptyStackExtension {
    checkSize();
    return this.entries.get(this.size - 1);
  }

  /**
   * Function to check the size of the current stack.
   * @throws EmptyStackExtension if size of the stack is 0.
   */
  
  private void checkSize() throws EmptyStackExtension {
    if (this.size == 0) {
      throw new EmptyStackExtension();
    }
    
  }

  /**
   * Function to pop the item on top of the current stack.
   * @return The entry at the top of the stack.
   * @throws EmptyStackExtension if size of the stack is 0.
   */
  
  public Entry pop() throws EmptyStackExtension {
    Entry ontop = top();
    this.size -= 1;
    this.entries.remove(ontop);
    return ontop;
  }

}
