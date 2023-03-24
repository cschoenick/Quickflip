import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

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
        Quickflip.fileMethod = 1;
        Quickflip.setRoot("NewCardPage");
        NewCardPageController startNewCard = new NewCardPageController();
        startNewCard.hidePopup();
        FileWriter fileWriter = new FileWriter("flashcards.txt");
        fileWriter.close();
    }

    @FXML
    void enterLoad(ActionEvent event) throws IOException {
        Quickflip.fileMethod = 2;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose a .txt file");
        File selectedFile = fileChooser.showOpenDialog(null);
        Quickflip.filePath = selectedFile.getAbsolutePath();
        Quickflip.setRoot("FlashCards");
        FlashCardsController startFlashCard = new FlashCardsController();
        startFlashCard.writeFlashCards(Quickflip.filePath);
    }

}
