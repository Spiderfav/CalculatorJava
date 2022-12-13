package calcmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import calculatortypes.InvalidExpression;

class CalcModelTests {

  @SuppressWarnings("unused")
  @Test
  void test_creation() {
    CalcModel calculator = new CalcModel();
  }
  
  @Test
  void test_evaluate_prefix() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("0", false), 0);
  }

  @Test
  void test_evaluate_infix() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("0", true), 0);
  }
  
  @Test
  void test_evaluate_prefix1() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("15", false), 15);
  }

  @Test
  void test_evaluate_infix1() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("15", true), 15);
  }

  @Test
  void test_evaluate_prefix2() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("5 3 +", false), 8);
  }

  @Test
  void test_evaluate_infix2() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("5 + 3", true), 8);
  }

  @Test
  void test_previous() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.getPreviousResult(), 0);
  }

  @Test
  void test_evaluate_infix_with_previous() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("5 + 3", true), 8);

    assertEquals(calculator.getPreviousResult(), 8);
  }

  @Test
  void test_evaluate_infix_with_previous2() throws InvalidExpression {
    CalcModel calculator = new CalcModel();

    assertEquals(calculator.evaluate("5 + 3", true), 8);

    assertEquals(calculator.getPreviousResult(), 8);

    assertEquals(calculator.evaluate("5 3 *", false), 15);

    assertEquals(calculator.getPreviousResult(), 15);
  }

}
