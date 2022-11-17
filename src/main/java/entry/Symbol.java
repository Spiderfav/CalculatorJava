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
  
  /**
   * Function that takes in a given text and tries to convert to a Symbol.
   * @return Symbol representation of the string.
   */
  
  public static Symbol convertString(String value) {
    for (Symbol symbol : Symbol.values()) {
      
      if (value.equals(symbol.toString())) {
        
        return symbol;  
      }
    }
    
    return Symbol.INVALID;
      
  }
  
}
