package entry;

/**
 * This Exception is thrown by the Entry Class. 
 * If the user tries to retrieve data that doesn't exist in type enum, it throws exception.
 * 
 * @author Rui Favinha
 * 
 */


public class BadTypeException extends Exception {

  private static final long serialVersionUID = -7150735557483201101L;

  /**
   * Allows specific error messages to be printed.
   *
   */
  
  public BadTypeException() {
    super("Cannot retrieve required data type.");
  }
}
