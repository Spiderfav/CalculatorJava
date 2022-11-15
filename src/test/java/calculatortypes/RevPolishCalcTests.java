/**
 * 
 */
package calculatortypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Rui Favinha
 *
 */
class RevPolishCalcTests {

  @Test // 1
  void test_creation() {
    RevPolishCalc revPolish = new RevPolishCalc();
  }
  
  @Test // 2
  void test_evaluate() {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "6";
    
    assertEquals (revPolish.evaluate(calculate), 6.0);
  }
  
}
