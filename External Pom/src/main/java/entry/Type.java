package entry;

/**
 * The enum "Type" contains all the available entries for the calculator.
 * @author Rui Favinha
 */

public enum Type {
    NUMBER,
    SYMBOL,
    STRING,
    INVALID;
  
  /**
   * ToString method of the enum.
   * @return The string representation of the type.
   */
  
  public String toString() {
    return name();
  }
}
