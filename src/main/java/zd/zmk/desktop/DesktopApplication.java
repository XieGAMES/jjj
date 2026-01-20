package zd.zmk.desktop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import zd.zmk.desktop.controller.MainController;

import java.io.IOException;

/**
 * Main desktop application class
 */
public class DesktopApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the main FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = fxmlLoader.load();
        
        // Set up the scene and stage
        Scene scene = new Scene(root, 1024, 768);
        primaryStage.setTitle("Вендинговое приложение");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}