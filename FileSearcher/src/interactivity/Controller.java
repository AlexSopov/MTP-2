package interactivity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import validators.FileValidationRequest;

public class Controller {

    private FileSearchViewModel fileSearchViewModel;

    @FXML
    private Button executeSearchButton;

    @FXML
    private CheckBox searchInFileInfoButton;
    @FXML
    private CheckBox searchInDescriptionButton;

    @FXML
    private ListView foundItems;

    @FXML
    private TextField searchForValue;

    @FXML
    private TextField searchFromValue;

    @FXML
    public void initialize(){
        fileSearchViewModel = new FileSearchViewModel();
        foundItems = new ListView();

        executeSearchButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                ObservableList<String> items =FXCollections.observableArrayList (
                        "Single", "Double", "Suite", "Family App");
                foundItems.setItems(items);

                fileSearchViewModel.ExecuteSearch(searchForValue.getText(), searchFromValue.getText());
            }
        });
    }
}