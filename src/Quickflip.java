import java.io.BufferedReader;
import java.io.IOException;
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

    @Override
    public void start(Stage stage) {
        try {
            scene = new Scene(loadFXML("StartPage"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
