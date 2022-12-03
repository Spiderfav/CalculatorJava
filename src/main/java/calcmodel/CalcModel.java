package calcmodel;

import calculatortypes.InvalidExpression;
import calculatortypes.RevPolishCalc;
import calculatortypes.StandardCalc;

/**
 * CalcModel is the main calculator program that runs.
 * It requires a String and a boolean to work.
 * @author Rui Favinha
 *
 */

public class CalcModel {

  private RevPolishCalc prefix = new RevPolishCalc();
  private StandardCalc infix = new StandardCalc();
  
  private float previousResult = 0;
  
  /**
   * Function to return the last result calculated by the calculator.
   * @return The last answer calculated as a float.
   */
  
  public float getPreviousResult() {
    return this.previousResult;
  }
  
  /**
   * Function to compute a mathematical answer, given the type of calculator.
   * @param expression given as the string to calculate result from.
   * @param infixOrNot as a boolean value to check if it is to calculate in infix or prefix.
   * @return The answer calculated as a float.
   * @throws InvalidExpression when an expression cannot be calculated.
   */
  
  public float evaluate(String expression, boolean infixOrNot) throws InvalidExpression {

    if (infixOrNot) {
      return (this.previousResult = infix.evaluate(expression));
    }
    return (this.previousResult = prefix.evaluate(expression));
  }
  
}
