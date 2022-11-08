import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * Provides the GUI view of the app.
 * @author Rui Favinha
 *
 */



public class MainView {
  
  @FXML
  private ToggleGroup calculatorType;
  
  @FXML
  private TextField expressionField;

  @FXML
  private RadioButton infixToggle;

  @FXML
  private Button resultButton;

  @FXML
  private Label resultText;

  @FXML
  private RadioButton reversePolishToggle;
  
}

  


