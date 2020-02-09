package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //the backdrop of the scene
        primaryStage.setTitle("Employee Manager 2000");
        primaryStage.setScene(new Scene(root, 800, 600)); //set the scene with root and the size
        primaryStage.show(); //after the scene is put on the stage, show the stage (turn on the lights)
    }


    public static void main(String[] args) {
        launch(args);
    }
}
