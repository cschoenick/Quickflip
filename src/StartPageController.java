

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class StartPageController {

    @FXML
    private Button exitBTN;

    @FXML
    private Button loadBTN;

    @FXML
    private Button newBTN;

    @FXML
    private ImageView logo;
        
    @FXML
    void exitProgram(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void enterNew(ActionEvent event) throws IOException {
        Quickflip.setRoot("NewCardPage");
    }
    @FXML
    void enterLoad(ActionEvent event) throws IOException {
        Quickflip.setRoot("LoadCardPage");
    }
    
}


