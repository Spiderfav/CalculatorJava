package calculatortypes;

import entry.Symbol;
import specificstack.OpStack;

/**
 * @author ruifavinha
 *
 */
public class StandardCalc implements Calculator {

  private RevPolishCalc rpCalc = new RevPolishCalc();

  private OpStack values = new OpStack();



  public float evaluate(String toEvaluate) throws InvalidExpression {
    return rpCalc.evaluate(convertPolish(toEvaluate));
  }



  public String convertPolish(String infix) throws InvalidExpression {

    String prefix = "";

    String[] array = infix.split(" ");

    for (int i = 0; i < array.length; i++) {

      if (checkType(array[i]) == 0) {
        throw new InvalidExpression();
      } 

      if (checkType(array[i]) == 1) {

        if (Symbol.convertString(array[i]) == Symbol.RIGHT_BRACKET) {
          
          while (true) {

            try {
              Symbol justPopped = values.pop();
              
              if (justPopped == Symbol.LEFT_BRACKET) {
                break;
              }

              prefix = prefix + justPopped + " ";

            } catch (Exception e) {
              throw new InvalidExpression();
            } 
          }          
        }
        
        
        if (values.isEmpty() == false) {
          
          
          Symbol onTop = null;
          
          try {
            onTop = values.pop();
            values.push(onTop);
            
          } catch (Exception e) {
            e.printStackTrace();
          }
          
          Symbol toAdd = Symbol.convertString(array[i]);
          
          while (onTop.ordinal() < toAdd.ordinal()) {
            
            if (toAdd == Symbol.LEFT_BRACKET || onTop == Symbol.LEFT_BRACKET) { 
              break; 
            }

            try {
              onTop = values.pop();
              
              if (onTop == Symbol.LEFT_BRACKET) {
                values.push(onTop);
                break;
              }
              
              prefix = prefix + onTop.toString() + " ";
              
              if (values.isEmpty()) {
                break;
              }              
            } catch (Exception e) {
              e.printStackTrace();
              break;
            } 
          }
                    
        }
        
        if (Symbol.convertString(array[i]) != Symbol.RIGHT_BRACKET) {
          values.push(Symbol.convertString(array[i]));
        }
      }

      if (checkType(array[i]) == 2) {

        prefix = prefix + array[i] + " ";

      }

    }


    while (values.isEmpty() == false) {
      try {

        Symbol onList = values.pop();
        
        if (onList == Symbol.LEFT_BRACKET) {
          throw new InvalidExpression();
        }
        
        prefix = prefix + onList + " ";

      } catch (Exception e) {
        throw new InvalidExpression();
      } 
    }


    return prefix;

    // Need to check if no other operations and 
  }

  /**
   * Function to check the type of a given string value.
   * Returns 1 if it is a valid symbol, 2 if it is a valid float and 0 if it is not valid.
   * @param evaluate given as the string to evaluate.
   * @return the type for the variable.
   */

  public int checkType(String evaluate) {

    
    // Symbol can always be evaluated, and as such we need to check against what we don't want.

    Symbol symb = Symbol.convertString(evaluate);

    if (symb != Symbol.INVALID) {
      return 1;
    }
    
    return rpCalc.checkType(evaluate);
  }
}
