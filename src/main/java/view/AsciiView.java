package view;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * This class takes care of the text based view of the calculator if launched through the terminal.
 * Code was based on @author Dave's implementation
 * @author Rui Favinha
 */
public class AsciiView implements ViewInterface {

  private String expression;
  public Runnable thread = null;
  public Consumer<OpType> currentType;
  private String answer;
  @SuppressWarnings("unused")
  private String prevAnswer;

  /**
   * Function to provide the main menu for the text based version of the calculator.
   */
  public void menu() {
    helpScreen();
    Scanner sc = new Scanner(System.in);  

    while (true) {
      System.out.println("Enter chosen command:");
      String command = sc.nextLine();  

      if (whichCommand(command, sc)) {
        break;
      }
    }
    sc.close();

  }

  /**
   * Function that processes a user-entered command.
   * @param command to process.
   * @param sc as the Scanner object used to read user input.
   * @return true if the command was "E" (exit) and to break the loop, false otherwise.
   */
  public boolean whichCommand(String command, Scanner sc) {
    if (command.toUpperCase().equals("C")) {
      toCalculate(sc);
      if (thread != null) {
        thread.run();      
      }

      System.out.println("Answer: " + answer);

    } else if (command.toUpperCase().equals("H")) {
      helpScreen();

    } else if (command.toUpperCase().equals("E")) {
      return true;

    } else {
      System.out.println("Not a valid command!");
      System.out.println("");
      System.out.println("Type H for the help screen!");
      System.out.println("");
    }

    return false;
  }

  /**
   * Function to take user input and provide answer to given expression.
   */
  private void toCalculate(Scanner sc) {
    System.out.println("Enter the expression to calculate:");
    expression = sc.nextLine();  
    System.out.println("Use in Reverse Polish? Y or N");
    String inReverse = sc.nextLine();  
    if (inReverse.equals("N")) {
      currentType.accept(OpType.STANDARD);
    } else {
      currentType.accept(OpType.REVPOLISH);
    }
  }

  /**
   * Function to print to the user all commands that are available on the calculator.
   */
  private void helpScreen() {
    System.out.println("Welcome to the help screen!");
    System.out.println("");
    System.out.println("C to begin the calculation");
    System.out.println("");
    System.out.println("H for the help screen messages");
    System.out.println("");
    System.out.println("E to exit the calculator");
    System.out.println("");
  }

  /**
   * Function to retrieve the expression to be calculated from the view.
   * @return the string to calculate.
   */
  @Override
  public String getExpression() {
    return expression;
  }

  /**
   * Function to update the answer field for the given expression.
   * @param str as the string answer calculated.
   */
  @Override
  public void setAnswer(String str) {
    answer = str;
  }

  /**
   * Function to add a thread to the running view to keep checking for updated values.
   * @param f as the thread to observe the changes.
   */
  @Override
  public void addCalcObserver(Runnable f) {
    thread = f;
  }

  /**
   * Function to add a thread to to the running view to keep checking for an OpType change.
   * @param i as the OpType of the given calculation
   */
  @Override
  public void addTypeObserver(Consumer<OpType> i) {
    currentType = i;
  }


}

