package calcmodel;

import calculatortypes.InvalidExpression;
import calculatortypes.RevPolishCalc;
import calculatortypes.StandardCalc;


/*
 *  UPDATED: 12-12-2022

 *  Lines 27 till 49 were taken from @author Dave's implementation of the calculator.
 *  This is so that the implementation is now fully correct.
 *  @author Rui Favinha
 *
 */

/**
 * CalcModel is the main calculator program that runs.
 * It requires a String and a boolean to work.
 * @author Rui Favinha
 */
public final class CalcModel {

  private RevPolishCalc prefix = new RevPolishCalc();
  private StandardCalc infix = new StandardCalc();

  private float previousAnswers = 0;

  /**
   * Constructor must be final so that only one instance of the class can be created.
   */
  public CalcModel() {}

  /**
   * Creation of the instance of the class.
   */
  private static CalcModel instance = null;

  /**
   * The hook to access this Singleton Calculator. The first time it is called it does the actual
   * instantiation - this is called lazy.
   * 
   * @return The calculator instance
   */
  public static CalcModel getInstance() {
    if (instance == null) {
      instance = new CalcModel();
    }
    return instance;
  }

  /**
   * Function to return the last result calculated by the calculator.
   * @return The last answer calculated as a float.
   */

  public float getPreviousResult() {
    return this.previousAnswers;
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
      return (this.previousAnswers = infix.evaluate(expression));
    }
    return (this.previousAnswers = prefix.evaluate(expression));
  }

}
