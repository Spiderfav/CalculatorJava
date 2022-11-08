package calculatortypes;

/**
 * This Exception is thrown by the Calculator interface and any that implement it. 
 * If the user gives an expression that can't be calculated, this Exception is thrown.
 * 
 * @author Rui Favinha
 * 
 */

public class InvalidExpression extends Exception {

  private static final long serialVersionUID = 8291372463335368752L;
  
  /**
   * Allows specific error messages to be printed.
   *
   */

  public InvalidExpression() {
    super("Invalid Expression Given.");
  }
}
