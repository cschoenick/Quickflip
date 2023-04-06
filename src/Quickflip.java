import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Quickflip extends Application {
    private static Scene scene;
    public static BufferedReader reader;
    public static String filePath;
    public static int fileMethod = 0;
    public static int studyMethod = 0;
    public static int index;
    public static ArrayList<String> termsList = new ArrayList<String>();
    public static ArrayList<String> definitionsList = new ArrayList<String>();
    public static Map<String, String> termsMap = new TreeMap<>();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("StartPage"));

        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Quickflip.class.getResource("/resources/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Scene grabScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
