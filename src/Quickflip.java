import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.scene.*;
 
public class Quickflip extends Application {
    @Override
    public void start(Stage primaryStage) {
    
    Parent root;
     try{
    root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Quickflip");
    primaryStage.setScene(scene);
    primaryStage.show();
    } catch (IOException e){
    }
  }
  

 public static void main(String[] args) {
        launch(args);
    }
}

