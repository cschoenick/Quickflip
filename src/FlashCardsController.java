
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FlashCardsController  {

    @FXML
    private ImageView backLogo;

    @FXML
    void backToStart(MouseEvent event) {
        try {
            Quickflip.setRoot("StartPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
