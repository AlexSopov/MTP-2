package interactivity;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    // TODO split deaclaration and initialization
    private FileSearchViewModel fileSearchViewModel = new FileSearchViewModel();


    @FXML
    private Button button;

    @FXML
    private CheckBox checkBox1;
    @FXML
    private CheckBox checkBox2;

    @FXML
    private ListView listView;

    @FXML
    private TextField upperTextField;

    @FXML
    private TextField bottomTextField;

    @FXML
    public void initialize(){
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                // TODO: remove stub
                fileSearchViewModel.ExecuteSearch(null);

                if(checkBox2.isSelected()) {
                    button.setText(bottomTextField.getText());
                }
            }
        });

    }

}