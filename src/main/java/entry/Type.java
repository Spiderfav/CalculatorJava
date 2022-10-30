package entry;

/**
 * The enum "Type" contains all the available entries for the calculator.
 * 
 * @author Rui Favinha
 */

public enum Type {

  /**
   * Object given as number.
   */
  NUMBER, 
  
  /**
   * Object given as symbol. See Symbol Enum for more.
   */
  SYMBOL, 
  
  /**
   * Object given as String..
   */
  STRING, 
  
  /**
   * Invalid left blank.
   */
  INVALID;

  /**
   * ToString method of the enum.
   * 
   * @return The string representation of the type.
   */

  public String toString() {
    return name();
  }
}
