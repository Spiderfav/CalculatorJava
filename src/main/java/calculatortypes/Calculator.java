package calculatortypes;

/**
 * The calculator interface provides the skeleton method for the types of calculator..
 * @author Rui Favinha
 *
 */

public interface Calculator {
  
  /**
   * The evaluate function,given a string expression, produces a result from the given string.
   * @param expression is the given String expression to calculate the result from.
   * @return the result of the given expression
   * @throws InvalidExpression if the string contains invalid characters or cannot be calculated.
   */
  
  public float evaluate(String expression) throws InvalidExpression;
  
  /**
   * Function to check the type of a given string value.
   * Returns 1 if it is a valid symbol, 2 if it is a valid float and 0 if it is not valid.
   * @param evaluate given as the string to evaluate.
   * @return the type for the variable.
   */
  public int checkType(String evaluate);
}
