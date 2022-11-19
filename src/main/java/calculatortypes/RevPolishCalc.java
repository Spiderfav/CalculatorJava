package calculatortypes;

import entry.Symbol;
import specificstack.NumStack;

/**
 * RevPolishCalc produces a mathematical result from a given Reverse Polish string expression.
 * @author Rui Favinha
 *
 */

public class RevPolishCalc implements Calculator {
    
  private NumStack numberStack = new NumStack();
  
  /**
   * Function to compute a mathematical answer, from a given string expression.
   * @param calculate given as the string to calculate result from.
   * @return The answer calculated as a float.
   * @throws InvalidExpression when an expression cannot be calculated.
   */
  
  public float evaluate(String calculate) throws InvalidExpression {
          
    String toEvaluate;
    int validity;
    
    String[] array = calculate.split(" ");
    
    // If user just gives one value, return the value to the user as the answer. 
    
    if (array.length == 1) {
      return Float.valueOf(array[0]);
    }
    
    // Checking if the last item is an operation.
    // Checking that length is odd as all operations have odd length.
    
    if (Symbol.convertString(array[array.length - 1]) == Symbol.INVALID || array.length % 2 == 0) {
      throw new InvalidExpression();
    }
    
    for (int i = 0; i < array.length; i++) {
      
      toEvaluate = array[i];
      validity = checkType(toEvaluate);
      
      switch (validity) {
        
        case 0:
          
          throw new InvalidExpression();

      
        case 1:
          
          try {
            float temp1 = numberStack.pop();
            
            float temp2 = numberStack.pop();

            numberStack.push(calculate(temp2, temp1, toEvaluate));
            
          } catch (Exception e) {
            throw new InvalidExpression();
          }
   
          break;
        
        case 2:
               
          numberStack.push(Float.valueOf(toEvaluate));
          break;
        
          
        // This default statement will never be executed as checkType function only returns 0,1,2.
        // However, default will sanity check and break out.
        default:
          break;
          
      }
      
    }
     
    // Result is at the bottom of the list so we pop once to get result.
    
    try {
        
      return (numberStack.pop());
      
    } catch (Exception e) {
      
      throw new InvalidExpression();
    }
      
    
    
  }
  
  /**
   * Function to compute a mathematical answer, from a given string expression.
   * Returns 1 if it is a valid symbol, 2 if it is a valid float and 0 if it is not valid.
   * @param evaluate given as the string to evaluate.
   * @return the type for the variable.
   */
  
  public int checkType(String evaluate) {
    
    // Symbol is always evaluated and as such we need to check against the symbols we don't want.
        
    Symbol symb = Symbol.convertString(evaluate);

    if (symb != Symbol.INVALID && symb != Symbol.LEFT_BRACKET && symb != Symbol.RIGHT_BRACKET) {
      return 1;
    }
    
    try {
      
      // Checking if it can be converted to a float.
      
      float numb = Float.valueOf(evaluate);
      
      return 2;
          
    } catch (Exception e) {
            
      // Cannot be converted to symbol or float.
      
      return 0;
    }
    
  }
  
  /**
   * Function to compute an answer by applying the operator given to the two given numbers.
   * @param number1 as the first number, below number2 in the stack.
   * @param number2 as the second number, the top of the stack.
   * @param operator as the operator to perform the operation.
   * @return the result of the given calculation.
   * @throws InvalidExpression if no operation is given.
   */
  
  public float calculate(float number1, float number2, String operator) throws InvalidExpression {
    Symbol symb = Symbol.convertString(operator);
        
    switch (symb) {
      case TIMES:
        return (number1 * number2);
      
      case DIVIDE:
        return (number1 / number2);
        
      case PLUS:
        return (number1 + number2);
        
      case MINUS:
        return (number1 - number2);
      
      default: 
        throw new InvalidExpression();

    }
    
  }

}
