import java.io.IOException;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.OpType;
import view.ViewInterface;

/**
 * Provides the Main view of the app; a GUI for a user.
 * This code was adapted from @author Dave's implementation.
 * @author Rui Favinha
 *
 */

public class MainView extends Application implements ViewInterface {

  @FXML
  private ToggleGroup calculatorType;

  @FXML
  private TextField expressionField;

  @FXML
  private RadioButton infixToggle;

  @FXML
  private Button resultButton = null;

  @FXML
  private Label resultText;

  @FXML
  private RadioButton reversePolishToggle;

  /**
   * Create an instance variable of the GUI for other parts of the program to use.
   *
   */
  private static volatile MainView instance = null;

  /**
   * Initialises an instance.
   *
   */
  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Retrieves the expression from the field.
   *
   */
  @Override
  public String getExpression() {
    return expressionField.getText();

  }

  /**
   * Sets an expression to the field.
   *
   */
  @Override
  public void setAnswer(String str) {
    resultText.setText(str);
  }

  /**
   * Adds an observer to the result button action to capture user input.
   *
   */
  @Override
  public void addCalcObserver(Runnable f) {
    resultButton.setOnAction(event -> f.run());
  }

  /**
   * Adds an observer to the OpType toggle to check for the chosen OpType.
   *
   */
  @Override
  public void addTypeObserver(Consumer<OpType> i) {
    reversePolishToggle.setOnAction(event -> i.accept(OpType.REVPOLISH));
    infixToggle.setOnAction(event -> i.accept(OpType.STANDARD));
  }
  
  /**
   * Starts the GUI application.
   *
   */
  @Override
  public void start(Stage primaryStage) throws IOException {
    GridPane page = (GridPane) FXMLLoader.load(MainView.class.getResource("MainView.fxml"));
    Scene scene = new Scene(page);
    primaryStage.setScene(scene);
    primaryStage.setTitle("MVC/Observer/fxml");
    primaryStage.show();

  }

  /**
   * Activates all the required buttons.
   *
   */
  public void menu() {
    resultButton.setDisable(false);
    reversePolishToggle.setDisable(false);
    infixToggle.setDisable(false);
  }
  
  /**
   * Retrieves the current running instance.
   *
   */
  public static synchronized MainView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(MainView.class)).start();
      while (instance == null) {
      }
    }

    return instance;
  }

 
}



