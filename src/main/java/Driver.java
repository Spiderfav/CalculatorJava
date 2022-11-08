import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Driver class deals creating the given view unto the monitor.
 * @author Rui Favinha
 */


public class Driver extends Application {

  /**
   * Launches a view with the given passed arguments.
   */
  
  public static void main(String[] args) {
    launch(args);
  }
  
  /**
   * Creates view from given fxml file.
   */
  
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
    Scene scene = new Scene(root, 600, 400);
    primaryStage.setScene(scene);
    primaryStage.show();    
  }

}
