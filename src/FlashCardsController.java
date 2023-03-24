import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.util.Duration;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class FlashCardsController {

    @FXML
    private ImageView backLogo;

    @FXML
    private Text tTerm;

    @FXML
    private Text tDefinition;

    @FXML
    private Button btnFlipCard;

    @FXML
    private Rectangle rFlashCard;

    @FXML
    private Button btnNextCard;
    private String term;
    private String definition;

    @FXML
    private void backToStart(MouseEvent event) {
        try {
            Quickflip.setRoot("StartPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void writeFlashCards(String string) throws IOException {
        Quickflip.reader = new BufferedReader(new FileReader(string));
        term = Quickflip.reader.readLine();
        definition = Quickflip.reader.readLine();
        Scene scene = Quickflip.grabScene();
        tTerm = (Text) scene.lookup("#tTerm");
        tTerm.setText(term);
        tDefinition = (Text) scene.lookup("#tDefinition");
        tDefinition.setText(definition);
        tDefinition.setVisible(false);

    }

    @FXML
    private void flipCard(ActionEvent event) {
        if (tTerm.isVisible()) {
            tDefinition.setVisible(true);
            tTerm.setVisible(false);
        } else {
            tTerm.setVisible(true);
            tDefinition.setVisible(false);
        }
        RotateTransition flip = flipTransition(rFlashCard);
        flip.play();

    }

    @FXML
    private void nextCard(ActionEvent event) throws IOException {
        String nextTerm = Quickflip.reader.readLine();
        System.out.println(nextTerm);
        String nextDefinition = Quickflip.reader.readLine();
        if (nextTerm != null && nextDefinition != null) {
            term = nextTerm;
            definition = nextDefinition;
            tTerm.setText(term);
            tDefinition.setText(definition);
            tTerm.setVisible(true);
            tDefinition.setVisible(false);
        } else {
            if (Quickflip.fileMethod == 1) {
                Quickflip.reader = new BufferedReader(new FileReader("flashcards.txt"));
            } else if (Quickflip.fileMethod == 2) {
                Quickflip.reader = new BufferedReader(new FileReader(Quickflip.filePath));
            }
            tTerm.setText(Quickflip.reader.readLine());
            tDefinition.setText(Quickflip.reader.readLine());
            tTerm.setVisible(true);
            tDefinition.setVisible(false);
        }

    }

    private RotateTransition flipTransition(Rectangle rFlashCard) {
        RotateTransition flip = new RotateTransition(Duration.millis(250), rFlashCard);
        flip.setAxis(Rotate.X_AXIS);
        flip.setFromAngle(0);
        flip.setToAngle(180);
        flip.setInterpolator(Interpolator.LINEAR);
        flip.setCycleCount(1);
        return flip;
    }
}