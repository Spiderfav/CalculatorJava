package stack;

/**
 * This Exception is thrown by the Stack Class. 
 * If the user tries remove or retrieve a value from an empty stack, error is thrown.
 * 
 * @author Rui Favinha
 *
 */


public class EmptyStackExtension extends Exception {
  
  private static final long serialVersionUID = 412732860281654750L;

  /**
   * Allows specific error messages to be printed. 
   *
   */
  public EmptyStackExtension() {
    super("Cannot retrieve required data type.");
  }
}
