package entry;

import java.util.Objects;

/**
 * Entry class models the input of the user by breaking down symbols and numbers to objects.
 * @author Rui Favinha
 *
 */

public class Entry {
  
  private Float number;
  private Symbol other;
  private String str;
  private Type type;
  
  /**
   * Constructor for entry; using a float.
   * @param newFloat for the number taken from user input.
   */

  public Entry(float newFloat) {
    this.number = newFloat;
    this.str = (String.valueOf(newFloat));
    this.type = Type.NUMBER;
    this.other = Symbol.INVALID;
  }

  /**
   * Constructor for entry; using a Symbol.
   * @param newSymbol for the Symbol taken from user input.
   */

  public Entry(Symbol newSymbol) {
    this.number = null;
    this.other = newSymbol;
    this.str = newSymbol.toString();
    this.type = Type.SYMBOL;
  }
 
  /**
   * Function to return the type of the Entry.
   * @return Type of the Entry
   */
  
  public Type getType() {
    return this.type;
  }

  /**
   * Function to get the string value of Entry.
   * @return The String value of the entry.
   */
  
  public String getString() {
    return this.str;
  }

  /**
   * Function to retrieve the Symbol of the Entry; throws exception.
   * @return The given Symbol of the Entry.
   * @throws BadTypeException if the symbol of the entry is INVALID as it therefore has no symbol.
   */
  
  public Symbol getSymbol() throws BadTypeException {
    if (this.other == Symbol.INVALID) { 
      throw new BadTypeException(); 
    }
        
    return this.other;
  }

  /**
   * Function to get the float value of Entry; throws exception.
   * @return The float value of the entry.
   * @throws BadTypeException if the number is not initialised.
   */
  
  public Float getValue() throws BadTypeException {
    if (this.number == null) { 
      throw new BadTypeException(); 
    }
    return this.number;
  }
  
  /**
   * Function to compare to entry to check if they are identically equal.
   * @param secondEntry as the Entry to compare with.
   * @return True if the given entry is identically equal to self entry.
   */
  
  public boolean equals(Entry secondEntry) { 
    return (this.type == secondEntry.getType() && this.str == secondEntry.getString());
  }

  /**
   * Function to generate a hash code from all the attributes of entry.
   */
  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

}
