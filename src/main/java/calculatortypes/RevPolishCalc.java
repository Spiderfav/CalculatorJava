package calculatortypes;

/**
 * RevPolishCalc produces a mathematical result from a given Reverse Polish string expression.
 * @author Rui Favinha
 *
 */

public class RevPolishCalc implements Calculator {
  
  /**
   * Function to compute a mathematical answer, from a given string expression.
   * @param calculate given as the string to evaluate.
   */
  
  public float evaluate(String calculate) {

    return Float.valueOf(calculate);
  }

}
