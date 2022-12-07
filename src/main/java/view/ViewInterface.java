package view;

import java.util.function.Consumer;

/**
 * This interface determines the basis for what the GUIView and AsciiView must provide.
 * 
 * @author Rui Favinha
 *
 */

public interface ViewInterface {

  /**
   * Function to retrieve the expression to be calculated from the view.
   * @return the string to calculate.
   */
  public String getExpression();
  
  
  /**
   * Function to update the answer field for the given expression.
   * @param str as the string answer calculated.
   */
  public void setAnswer(String str);
  
  
  /**
   * Function to add a thread to the running view to keep checking for updated values.
   * @param f as the thread to observe the changes.
   */
  public void addCalcObserver(Runnable f);
  
  
  /**
   * Function to add a thread to to the running view to keep checking for an OpType change.
   * @param i as the OpType of the given calculation
   */
  public void addTypeObserver(Consumer<OpType> i);
}


