/**
 * 
 */
package calculatortypes;

import org.junit.jupiter.api.Test;

/**
 * @author Rui Favinha
 *
 */
class StandardCalcTests {

  @Test // Test 1
  void test_creation() {
    StandardCalc calculator = new StandardCalc();
  }
  
  @Test // Test 2
  void evaluate_simple() {
    StandardCalc calculator = new StandardCalc();
    
    assert (calculator.evaluate("0") == 0);
  }
  
  @Test // Test 3
  void evaluate_simple_return() {
    StandardCalc calculator = new StandardCalc();
    
    assert (calculator.evaluate("0") == 0);
  }
  
  

}
