import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class NewCardPageController {
    @FXML
    private ImageView backLogo;
    @FXML
    private TextArea taDefinition;
    @FXML
    private TextArea taSavePop;
    @FXML
    private TextField tfTerm;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnNoSave;

    @FXML
    private void initialize() {
        backLogo.setOnMouseEntered(e -> {
            backLogo.setScaleX(1.35);
            backLogo.setScaleY(1.35);
        });
        backLogo.setOnMouseExited(e -> {
            backLogo.setScaleX(1.25);
            backLogo.setScaleY(1.25);
        });

    }

    @FXML
    void backToStart(MouseEvent event) throws IOException {
        Quickflip.setRoot("StartPage");
    }

    void hidePopup() {
        Scene scene = Quickflip.grabScene();
        taSavePop = (TextArea) scene.lookup("#taSavePop");
        btnSave = (Button) scene.lookup("#btnSave");
        btnNoSave = (Button) scene.lookup("#btnNoSave");
        btnSave.setVisible(false);
        btnNoSave.setVisible(false);
        taSavePop.setVisible(false);
    }

    @FXML
    void nextTerm(ActionEvent event) throws IOException {
        Scene scene = Quickflip.grabScene();
        tfTerm = (TextField) scene.lookup("#tfTerm");
        taDefinition = (TextArea) scene.lookup("#taDefinition");

        String term = tfTerm.getText();
        String definition = taDefinition.getText();

        writeToFile(term, definition);

        tfTerm.setText("");
        taDefinition.setText("");

    }

    public static void writeToFile(String term, String definition) throws IOException {
        String toWrite = term + "\n" + definition + "\n";
        Files.write(Paths.get("flashcards.txt"), toWrite.getBytes(), StandardOpenOption.APPEND);

    }

    @FXML
    void studyTerms(ActionEvent event) throws IOException {
        Quickflip.setRoot("FlashCards");
        FlashCardsController startFlashCard = new FlashCardsController();
        startFlashCard.writeFlashCards("flashcards.txt");
    }

    @FXML
    void showPopup(ActionEvent event) {
        taSavePop.setVisible(true);
        btnSave.setVisible(true);
        btnNoSave.setVisible(true);
    }

    @FXML
    void saveFlashcards() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Flashcards");
        fileChooser.setInitialFileName("myflashcards.txt");
        File file = fileChooser.showSaveDialog(null);
        String filePath = file.getAbsolutePath();
        Quickflip.setRoot("FlashCards");
        FlashCardsController startFlashCard = new FlashCardsController();
        startFlashCard.writeFlashCards("flashcards.txt");
        File sourceFile = new File("flashcards.txt");
        File targetFile = new File(filePath);
        try (InputStream inputStream = new FileInputStream(sourceFile);
                OutputStream outputStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
