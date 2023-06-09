import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
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
    @FXML
    private Button btnTest;

    private String term;
    private String definition;

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
    private void backToStart(MouseEvent event) throws IOException {
        Quickflip.fileMethod = 0;
        Quickflip.studyMethod = 0;
        Quickflip.setRoot("StartPage");

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

        PauseTransition pause = new PauseTransition(Duration.millis(250));
        pause.setOnFinished(e -> {
            btnFlipCard.setVisible(true);
        });
        btnFlipCard.setVisible(false);
        pause.play();

    }

    @FXML
    void enterTest(ActionEvent event) throws IOException {
        Quickflip.setRoot("Test");
    }

    @FXML
    private void nextCard(ActionEvent event) throws IOException {
        String nextTerm = Quickflip.reader.readLine();
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
        ScaleTransition scale = scaleTransition(rFlashCard);
        scale.play();
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

    private ScaleTransition scaleTransition(Rectangle rFlashCard) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), rFlashCard);
        scale.setFromX(1.25);
        scale.setFromY(1.25);
        scale.setToX(1.5);
        scale.setToY(1.5);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);
        return scale;
    }

}