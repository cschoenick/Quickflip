import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;

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
        Parent root;
        try{
        root = FXMLLoader.load(getClass().getResource("NewCardPage.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       } catch (IOException e){
       }
    }
    @FXML
    void enterLoad(ActionEvent event) throws IOException {
        Parent root;
        try{
        root = FXMLLoader.load(getClass().getResource("LoadCardPage.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       } catch (IOException e){
       }
    }
    
}


