package controller;

import calcmodel.CalcModel;
import calculatortypes.Calculator;
import calculatortypes.InvalidExpression;
import view.ViewInterface;

/**
* CalcController is the controller for the views of the calculator.
* It observes changes in the answers of the views, updates and displays results.
* This is a modified implementation of @author Dave's work.
* @author Rui Favinha
*/

public class CalcController {
  
  public CalcModel model = CalcModel.getInstance();
  public ViewInterface newView;
  public boolean isInfix;
  
  /**
   * Function that sends the data to the CalcModel and retrieves a calculation.
   * It then sends the answer to display to the user.
   *
   */
  public void calculate() throws InvalidExpression {
    String[] expression = newView.getExpression().split("v");
    boolean isInfix = Boolean.parseBoolean(expression[1]);
    
    Double a = (double) model.evaluate(expression[0], isInfix);
    newView.setAnswer(a.toString());
  }
  
  /**
   * Constructor to provide a Singleton instance of the class.
   *
   */
  public CalcController(ViewInterface v) {
    addView(v);
  }

  /**
   * Empty constructor for already running class.
   *
   */
  public CalcController() {}

  /**
   * Function that sends the data to the CalcModel and retrieves a calculation.
   * It then sends the answer to display to the user.
   *
   */
  public void addView(ViewInterface v) {
    newView = v;
    v.addCalcObserver(this::calculateAction);
    v.addTypeObserver(this::changeType);
  }
}
