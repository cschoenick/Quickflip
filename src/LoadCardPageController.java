import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class LoadCardPageController {

    @FXML
    private ImageView backArrow;

    @FXML
    void backToStart(MouseEvent event) {
        Parent root;
        try{
        root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
       } catch (IOException e){
       }
    }

}