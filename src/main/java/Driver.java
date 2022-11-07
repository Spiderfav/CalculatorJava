import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Driver class deals with the modelling of the app.
 * @author Rui Favinha
 */


public class Driver extends Application {

  /**
   * Creates a view with the given passed arguments.
   */
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
    Scene scene = new Scene(root, 800, 800);
    primaryStage.setScene(scene);
    primaryStage.show();    
  }

}
