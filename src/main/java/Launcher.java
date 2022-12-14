import controller.CalcController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * This class is used to start the JavaFX framework. It is the base of the GUI app.
 * This is based on @author Dave's implementation.
 * @author Rui Favinha
 *
 */
public class Launcher extends Application {

  /**
   * Creating a new controller for the GUI app. 
   */
  private static CalcController myController;

  /**
   * The entry point to begin the JavaFX framework.
   * 
   * @param c as the controller that needs to be notified once the View is created
   * @param args as the arguments to actual main method in the Driver
   */
  public static void startJavaFX(CalcController c, String[] args) {
    myController = c;
    Launcher.main(args);
  }

  /**
   * A callback for JavaFX when the toolkit is initialised. Used to instantiate the scene and create
   * the View.
   * 
   * @param primaryStage the stage to attach the newly create scene.
   */
  @Override
  public void start(Stage primaryStage) {
    FXMLLoader loader = new FXMLLoader(Driver.class.getResource("MainView.fxml"));

    Scene scene = null;
    try {
      scene = new Scene(loader.load(), 600, 400);
    } catch (IOException e) {
      e.printStackTrace();
    }
    myController.addView(loader.getController());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * The main method needed by JavaFX in the Application class.
   * 
   * @param args as the arguments passed into the main method in Driver.
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
