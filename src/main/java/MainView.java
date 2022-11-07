

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * The Model Class.
 *
 * 
 * @author Rui Favinha
 *
 */

public class MainView {
  
  @FXML
  private Pane mainPane;

  @FXML
  private Label numberLabel;
  
  @FXML
  private Button addOneButton;
  
  @FXML
  void isPressed(ActionEvent event) {
    int i = Integer.parseInt(numberLabel.getText());
    i += 1;
    numberLabel.setText(String.valueOf(i));
  }
  
}

