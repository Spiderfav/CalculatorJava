package entry;

/**
 * The enum "Symbol" contains all the available operations that can be performed on the calculator.
 * @author Rui Favinha
 *
 */
public enum Symbol {
  
  LEFT_BRACKET("("),
  RIGHT_BRACKET(")"),
  TIMES("*"),
  DIVIDE("/"),
  PLUS("+"),
  MINUS("-"),
  INVALID("");
  
  private final String text;

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
