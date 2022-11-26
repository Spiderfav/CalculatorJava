/**
 * 
 */
package calculatortypes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
  void evaluate_simple() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assert (calculator.evaluate("0") == 0);
  }
  
  @Test // Test 3
  void evaluate_simple_return() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assert (calculator.evaluate("1") == 1);
  }
  
  @Test // Test 4
  void check_type_regular_type() {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.checkType("+"), 1);
  }
  
  @Test // Test 4
  void check_type_bracket() {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.checkType("("), 1);
    assertEquals(calculator.checkType(")"), 1);
  }
  
  @Test // Test 4
  void check_convert_digit() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.convertPolish("5"), "5 ");
  }
  
  @Test // Test 4
  void check_convert_simple() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.convertPolish("5 + 3"), "5 3 + ");
  }
  
  @Test // Test 4
  void check_convert_wrong() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assertThrows(InvalidExpression.class, 
        () -> {
          calculator.convertPolish("g");
        });
  }
  
  @Test // Test 5
  void check_convert_medium() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.convertPolish("5 * 3 + 2"), "5 3 * 2 + ");
  }
  
  @Test // Test 5
  void check_convert_long() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.convertPolish("2 * ( 4 + 2 * 5 ) + 10"), "2 4 2 5 * + * 10 + ");
  }
  
  @Test // Test 5
  void check_convert_brackets() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.convertPolish("( 5 * 3 + ( 2 * 4 ) - 3 ) + 6"), "5 3 * 2 4 * + 3 - 6 + ");
  }
  
  @Test // Test 5
  void check_evaluate() throws InvalidExpression {
    StandardCalc calculator = new StandardCalc();
    
    assertEquals(calculator.evaluate("( 5 * 3 + ( 2 * 4 ) - 3 ) + 6"), 26);
  }
  
}
