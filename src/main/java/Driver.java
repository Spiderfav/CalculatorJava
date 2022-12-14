import controller.CalcController;
import view.AsciiView;


/**
 * Driver class deals creating the given view unto the monitor.
 * Can create a terminal view or a GUI depending on how it was launched.
 * @author Rui Favinha
 */


public class Driver {

  /**
   * Launches a view with the given passed arguments.
   * If launched through the terminal, will create a terminal view.
   * Else it will launch a GUI calculator.
   */

  public static void main(String[] args) {
    
    if (System.console() != null) {
      AsciiView v = new AsciiView();
      new CalcController(v);
      v.menu();
    } else {
      Launcher.startJavaFX(new CalcController(), args);
    }
  }


}
