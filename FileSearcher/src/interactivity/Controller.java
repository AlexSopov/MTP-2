package interactivity;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Button button;

    @FXML
    private CheckBox checkbox1;
    @FXML
    private CheckBox checkbox2;
    @FXML
    private CheckBox checkbox3;

    @FXML
    private ListView listview;

    @FXML
    private TextField textfield;

    @FXML
    public void initialize(){
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(checkbox3.isSelected()) {
                    button.setText(textfield.getText());
                }
            }
        });

    }

}