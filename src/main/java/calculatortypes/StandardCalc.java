package calculatortypes;

/**
 * @author ruifavinha
 *
 */
public class StandardCalc implements Calculator {
  
  public float evaluate(String toEvaluate) {
    
    return Float.valueOf(toEvaluate);
    
  }
}
