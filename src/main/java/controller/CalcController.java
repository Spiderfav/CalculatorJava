package controller;

import calcmodel.CalcModel;
import calculatortypes.InvalidExpression;
import view.OpType;
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
    String expression = newView.getExpression();

    Double a = (double) model.evaluate(expression, isInfix);
    newView.setAnswer(a.toString());
  }
  
  /**
   * A Constructor to provide a Singleton instance of the class.
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
   * Function that, depending on the OpType set from a button, will update for expression.
   *
   */
  private void changeType(OpType t) {
    if (t.equals(OpType.REVPOLISH)) {
      isInfix = false;
      
    } else if (t.equals(OpType.STANDARD)) {
      isInfix = true;
    }
  }

  /**
   * Function that attaches the observers to the required input and text fields.
   * It then sends the data to the required functions when changes are made in the app.
   *
   */
  public void addView(ViewInterface v) {
    newView = v;
    v.addCalcObserver(() -> {
      try {
        calculate();
      } catch (InvalidExpression e) {
        newView.setAnswer(e.getMessage());
      }
    });
    v.addTypeObserver(this::changeType);
  }
}
