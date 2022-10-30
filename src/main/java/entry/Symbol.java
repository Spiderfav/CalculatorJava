package entry;

/**
 * The enum "Symbol" contains all the available operations that can be performed on the calculator.
 * @author Rui Favinha
 *
 */
public enum Symbol {
  
  /**
   * Left Bracket: "(".
   */
  LEFT_BRACKET("("),
  
  /**
   * Right Bracket: ")".
   */
  RIGHT_BRACKET(")"),
  
  /**
   * Multiplication Symbol: "*".
   */
  TIMES("*"),
  
  /**
   * Division Symbol: "/".
   */
  DIVIDE("/"),
  
  /**
   * Addition Symbol: "+".
   */
  PLUS("+"),
  
  /**
   * Subtraction Symbol: "-".
   */
  MINUS("-"),
  
  /**
   * Invalid left blank.
   */
  INVALID("");
  
  private final String text;

  /**
   * The constructor is automatically called when creating an Enum.
   * @param text given from the Enum.
   */
  Symbol(final String text) {
    this.text = text;
  }

  /**
   * Function to return the text representation of Symbol.
   * @return String representation the symbol.
   */
  
  public String toString() {
    return text;
  }
  
  
}
