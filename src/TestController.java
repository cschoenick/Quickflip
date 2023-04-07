import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeMap;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.io.BufferedReader;
import java.io.FileReader;

public class TestController {

    @FXML
    private ImageView backLogo;
    @FXML
    private Rectangle rTestCard;
    @FXML
    private Button btnT1;
    @FXML
    private Button btnT2;
    @FXML
    private Button btnT3;
    @FXML
    private Button btnT4;
    @FXML
    private Button btnNext;
    @FXML
    private TextArea taTestDefinition;

    @FXML
    private void initialize() throws IOException {
        backLogo.setOnMouseEntered(e -> {
            backLogo.setScaleX(1.35);
            backLogo.setScaleY(1.35);
        });
        backLogo.setOnMouseExited(e -> {
            backLogo.setScaleX(1.25);
            backLogo.setScaleY(1.25);
        });

        writeTest();

    }

    @FXML
    private void backToStart(MouseEvent event) throws IOException {
        Quickflip.fileMethod = 0;
        Quickflip.studyMethod = 0;
        Quickflip.setRoot("StartPage");
    }

    @FXML
    void checkAnswerB1(ActionEvent event) {
        if (btnT1.getText().equals(Quickflip.termsList.get(Quickflip.index))) {

            btnT1.setStyle("-fx-background-color: #51AB7D");

        } else {

            btnT1.setStyle("-fx-background-color: #ea5456");

        }
    }

    @FXML
    void checkAnswerB2(ActionEvent event) {
        if (btnT2.getText().equals(Quickflip.termsList.get(Quickflip.index))) {

            btnT2.setStyle("-fx-background-color: #51AB7D");

        } else {

            btnT2.setStyle("-fx-background-color: #ea5456");

        }
    }

    @FXML
    void checkAnswerB3(ActionEvent event) {
        if (btnT3.getText().equals(Quickflip.termsList.get(Quickflip.index))) {

            btnT3.setStyle("-fx-background-color: #51AB7D");

        } else {

            btnT3.setStyle("-fx-background-color: #ea5456");

        }
    }

    @FXML
    void checkAnswerB4(ActionEvent event) {
        if (btnT4.getText().equals(Quickflip.termsList.get(Quickflip.index))) {

            btnT4.setStyle("-fx-background-color: #51AB7D");

        } else {

            btnT4.setStyle("-fx-background-color: #ea5456");

        }
    }

    @FXML
    void next(ActionEvent event) {
        Quickflip.termsList = new ArrayList<>(Quickflip.termsMap.keySet());
        Collections.shuffle(Quickflip.termsList);
        clearButtons();
        fillButtons();

        taTestDefinition.setText(Quickflip.termsMap.get(Quickflip.termsList.get(Quickflip.index)));
        ScaleTransition scale = scaleTransition(rTestCard);
        scale.play();

    }

    public void writeTest() throws IOException {
        Quickflip.termsMap = new TreeMap<>();
        String line;
        String term = "";
        if (Quickflip.fileMethod == 1) {
            Quickflip.reader = new BufferedReader(new FileReader("flashcards.txt"));
        } else if (Quickflip.fileMethod == 2) {
            Quickflip.reader = new BufferedReader(new FileReader(Quickflip.filePath));
        }

        while ((line = Quickflip.reader.readLine()) != null) {
            if (term.isEmpty()) {
                term = line;
            } else {
                Quickflip.termsMap.put(term, line);
                term = "";
            }
        }

        Quickflip.termsList = new ArrayList<>(Quickflip.termsMap.keySet());
        Collections.shuffle(Quickflip.termsList);

        Quickflip.index = (int) (Math.random() * Quickflip.termsList.size());
        taTestDefinition.setText(Quickflip.termsMap.get(Quickflip.termsList.get(Quickflip.index)));
        fillButtons();

    }

    public void fillButtons() {
        Random random = new Random();
        int randomInt = random.nextInt(4) + 1;

        ArrayList<Integer> incorrectAnswers = new ArrayList<Integer>();
        for (int i = 0; i < Quickflip.termsList.size(); i++) {
            if (i != Quickflip.index) {
                incorrectAnswers.add(i);
            }
        }
        Collections.shuffle(incorrectAnswers);
        switch (randomInt) {
            case 1:
                btnT1.setText(Quickflip.termsList.get(Quickflip.index));
                btnT2.setText(Quickflip.termsList.get(incorrectAnswers.get(0)));
                btnT3.setText(Quickflip.termsList.get(incorrectAnswers.get(1)));
                btnT4.setText(Quickflip.termsList.get(incorrectAnswers.get(2)));
                break;
            case 2:
                btnT2.setText(Quickflip.termsList.get(Quickflip.index));
                btnT1.setText(Quickflip.termsList.get(incorrectAnswers.get(0)));
                btnT3.setText(Quickflip.termsList.get(incorrectAnswers.get(1)));
                btnT4.setText(Quickflip.termsList.get(incorrectAnswers.get(2)));
                break;
            case 3:
                btnT3.setText(Quickflip.termsList.get(Quickflip.index));
                btnT2.setText(Quickflip.termsList.get(incorrectAnswers.get(0)));
                btnT1.setText(Quickflip.termsList.get(incorrectAnswers.get(1)));
                btnT4.setText(Quickflip.termsList.get(incorrectAnswers.get(2)));
                break;
            case 4:
                btnT4.setText(Quickflip.termsList.get(Quickflip.index));
                btnT2.setText(Quickflip.termsList.get(incorrectAnswers.get(0)));
                btnT3.setText(Quickflip.termsList.get(incorrectAnswers.get(1)));
                btnT1.setText(Quickflip.termsList.get(incorrectAnswers.get(2)));
        }

    }

    public void clearButtons() {
        btnT1.setText("");
        btnT2.setText("");
        btnT3.setText("");
        btnT4.setText("");
        btnT1.setStyle("");
        btnT2.setStyle("");
        btnT3.setStyle("");
        btnT4.setStyle("");
    }

    private ScaleTransition scaleTransition(Rectangle rTestCard) {
        ScaleTransition scale = new ScaleTransition(Duration.millis(100), rTestCard);
        scale.setFromX(1.25);
        scale.setFromY(1.25);
        scale.setToX(1.5);
        scale.setToY(1.5);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);
        return scale;
    }
}
