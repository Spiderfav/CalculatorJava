package calculatortypes;

import entry.Symbol;
import specificstack.OpStack;

/**
 * StandardCalc produces a mathematical result from a given mathematical string expression.
 * It achieves this by converting a normal expression to a reverse polish and evaluating it.
 * @author Rui Favinha
 *
 */
public class StandardCalc implements Calculator {

  private RevPolishCalc rpCalc = new RevPolishCalc();

  private OpStack values = new OpStack();

  /**
   * Function to compute a mathematical answer, from a given string expression.
   * @param toEvaluate given as the string to calculate result from.
   * @return The answer calculated as a float.
   * @throws InvalidExpression when an expression cannot be calculated.
   */

  public float evaluate(String toEvaluate) throws InvalidExpression {
    return rpCalc.evaluate(convertPolish(toEvaluate));
  }

  /**
   * Function to convert an infix expression to reverse polish expression as a string.
   * @param infix given as the string to convert to reverse polish.
   * @return The string given formatted for reverse polish.
   * @throws InvalidExpression when an expression cannot be calculated.
   */

  public String convertPolish(String infix) throws InvalidExpression {

    String prefix = "";

    String[] array = infix.split(" ");
    
    if (checkType(array[array.length - 1]) == 1) {
      throw new InvalidExpression();
    }

    for (int i = 0; i < array.length; i++) {

      switch (checkType(array[i])) {

        case 0:
          throw new InvalidExpression();

        case 1:
          // If the symbol found is a right bracket, pop all in the stack until we find a left.
          // If no left bracket is found and it is the end of the stack, InvalidExpression thrown.

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


          // If the opStack is not empty, compare the current operation with the ones on stack.
          // Continue comparing until we reach an operation with a lower value or equal to current.

          if (values.isEmpty() == false) {


            Symbol onTop = null;

            try {
              onTop = values.pop();
              values.push(onTop);

            } catch (Exception e) {
              throw new InvalidExpression();
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
                throw new InvalidExpression();
              } 
            }

          }

          // If there are no symbols on the stack or it is a left bracket,
          // Or if the value of the current symbol is lower than on stack, it is added to string.

          if (Symbol.convertString(array[i]) != Symbol.RIGHT_BRACKET) {
            values.push(Symbol.convertString(array[i]));
          }
          break;

          // If it is a number, add it directly to the string to later evaluate. 
        case 2:
          prefix = prefix + array[i] + " ";
          break;


        // This default statement will never be executed as checkType function only returns 0,1,2.
        // However, default will sanity check and break out.
        default:
          break;

      }
    }

    // Once we reach the end of the string, we pop all the operators left in the stack.
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

    // Return the string it has been fully converted.

    return prefix;
  }

  /**
   * Function to check the type of a given string value.
   * Returns 1 if it is a valid symbol, 2 if it is a valid float and 0 if it is not valid.
   * @param evaluate given as the string to evaluate.
   * @return the type for the variable.
   */

  public int checkType(String evaluate) {


    // Symbol can always be evaluated, and as such we need to check against what we don't want.

    // Re-using the function from RevPolishCalc however, we need to check for brackets.
    Symbol symb = Symbol.convertString(evaluate);

    if (symb != Symbol.INVALID) {
      return 1;
    }

    return rpCalc.checkType(evaluate);
  }
}
