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
class RevPolishCalcTests {

  // Testing the creation of a new Calculator
  @Test // Test 1
  void test_creation() {
    RevPolishCalc revPolish = new RevPolishCalc();
  }
  
  //Changed to account for throws declaration from no operator.
  // Testing the function to actually calculate the expression returns the result
  @Test // Test 2
  void test_calculate_result_plus_simple() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(6,0,"+"), 6.0); 
  }
  
  //Changed to account for throws declaration from no operator.  
  // Testing the function to see if it can add two numbers.
  @Test // Test 3
  void test_calculate_result_plus() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(6,5,"+"), 11.0); 
  }

  //Changed to account for throws declaration from no operator.
  // Testing the function to see if it can multiply. 
  @Test // Test 4
  void test_calculate_result_times_simple() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(6,1,"*"), 6.0); 
  }
  
  //Changed to account for throws declaration from no operator.
  //Testing the function to see if it can multiply two numbers.
  @Test // Test 5
  void test_calculate_result_times() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(6,5,"*"), 30.0); 
  }
  
  //Changed to account for throws declaration from no operator.
  // Simple subtraction.
  @Test // Test 6
  void test_calculate_result_minus_simple() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(6,0,"-"), 6.0); 
  }
  
  // Changed to account for throws declaration from no operator.
  // More advanced subtraction.
  @Test // Test 7
  void test_calculate_result_minus() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(6,5,"-"), 1.0); 
  }
  
  // Changed to account for throws declaration from no operator.
  // Simple division
  @Test // Test 8
  void test_calculate_result_divide_simple() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(10,1,"/"), 10.0); 
  }
  
  // Changed to account for throws declaration from no operator.
  // Advanced division
  @Test // Test 9 
  void test_calculate_result_divide() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.calculate(10,5,"/"), 2.0); 
  }
  
  // Testing that if given no operator, exception is thrown.
  @Test // Test 10
  void test_calculate_result_no_operator() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();

    assertThrows(InvalidExpression.class, 
        () -> {
          revPolish.calculate(10,5,"");
        });
  }
  
  // Checking that the function can account for large/small positive numbers.
  @Test // Test 11
  void test_calculate_result_large_numbers() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();

    assertEquals (revPolish.calculate(340282347000000000000000000000000000000f,2,"*"), Float.POSITIVE_INFINITY); 
  }
  
  //Checking that the function can account for large/small negative numbers.
  @Test // Test 12
  void test_calculate_result_large_negative_numbers() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();

    assertEquals (revPolish.calculate(340282347000000000000000000000000000000f,-2,"*"), Float.NEGATIVE_INFINITY); 
  }
   
  // Testing that we can correctly identify symbols.
  @Test // Test 13
  void test_type_symbol() {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.checkType("/"), 1); 
  }
  
  //Testing that we can correctly identify floats.
  @Test // Test 14
  void test_type_float() {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.checkType("1.0"), 2); 
  }
  
  //Testing that we can correctly identify non floats and non symbols.
  @Test // Test 15
  void test_wrong_type() {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.checkType("g"), 0); 
  }
  
  //Testing that we can correctly identify symbols.
  @Test // Test 16
  void test_type_symbol2() {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.checkType("*"), 1); 
  }
  
  //Testing that we can correctly identify symbols.
  @Test // Test 17
  void test_type_symbol3() {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.checkType("+"), 1); 
  }
  
  //Testing that we can correctly identify symbols.
  @Test // Test 18
  void test_type_symbol4() {
    RevPolishCalc revPolish = new RevPolishCalc();
    
    assertEquals (revPolish.checkType("-"), 1); 
  }
  
  //Testing that the calculator can return the results sent to the calculator.
  @Test // Test 19
  void test_evaluate() throws InvalidExpression {
   RevPolishCalc revPolish = new RevPolishCalc();
   String calculate = "6";
   
   assertEquals (revPolish.evaluate(calculate), 6.0);
  }
  
  // Testing the calculator can perform the calculations correctly.
  @Test // Test 20
  void test_evaluate_two_numbs() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "6 5 +";
    
    assertEquals (revPolish.evaluate(calculate), 11.0); 
  }
  
  // Testing that longer expressions still work on the calculator.
  @Test // Test 21
  void test_evaluate_long_expression() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "5 6 7 + * 2 -";
    
    assertEquals (revPolish.evaluate(calculate), 63.0);
  }
  
  // Testing that when typing two expressions, both are calculated correctly.
  @Test // Test 22
  void test_evaluate_two_expression() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "5 6 7 + * 2 -";
    
    assertEquals (revPolish.evaluate(calculate), 63.0);
    
    String calculate2 = "6 5 +";
    
    assertEquals (revPolish.evaluate(calculate2), 11.0); 
    
  }
  
  // Testing that after an expression has been calculated, its result does not stay on the array.
  @Test // Test 23
  void test_evaluate_two_expression_wrong() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "5 6 7 + * 2 -";
    
    assertEquals (revPolish.evaluate(calculate), 63.0);
    
    String calculate2 = "6 +";
        
    assertThrows(InvalidExpression.class, 
        () -> {
          revPolish.evaluate(calculate2);
       });
    
  }
  
  // Testing that an unfinished expression throws an exception.
  @Test // Test 24
  void test_evaluate_unfinished_expression() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "4 5 - 5 6 +";
    
    assertThrows(InvalidExpression.class, 
        () -> {
          revPolish.evaluate(calculate);
        });
    
  }
  
  // Testing that when dividing by 0, calculator produces result.
  @Test // Test 25
  void test_zero_expression() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "5 0 /";
    
    assertEquals (revPolish.evaluate(calculate), Float.POSITIVE_INFINITY);

  }
  
  // Testing that when multiplying by 0, calculator provides result.
  @Test // Test 26
  void test_zero_expression2() throws InvalidExpression {
    RevPolishCalc revPolish = new RevPolishCalc();
    String calculate = "5 0 *";
    
    assertEquals (revPolish.evaluate(calculate), 0.0);
    
  }
  

  
}
