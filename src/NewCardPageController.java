import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class NewCardPageController {
    @FXML
    private ImageView backArrow;
    @FXML
    private TextArea taDefinition;
    @FXML
    private TextField tfTerm;

    @FXML
    void backToStart(MouseEvent event) {
        try {
            Quickflip.setRoot("StartPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void nextTerm(ActionEvent event) {
        Scene scene = Quickflip.grabScene();
        tfTerm = (TextField) scene.lookup("#tfTerm");
        taDefinition = (TextArea) scene.lookup("#taDefinition");

        String term = tfTerm.getText();
        String definition = taDefinition.getText();

        writeToFile(term, definition);

        tfTerm.setText("");
        taDefinition.setText("");

    }

    @FXML
    void studyTerms(ActionEvent event) {
        try {
            Quickflip.setRoot("FlashCards");
            FlashCardsController startFlashCard = new FlashCardsController();
            startFlashCard.writeFlashCards("flashcards.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String term, String definition) {
        try {
            String toWrite = term + "\n" + definition + "\n";
            Files.write(Paths.get("flashcards.txt"), toWrite.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error writing flashcards to file");
        }
    }

}
