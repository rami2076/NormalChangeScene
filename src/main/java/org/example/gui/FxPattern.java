package org.example.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.Root;

import java.net.URL;

public class FxPattern extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL location = Root.class.getClass().getResource("/org/example/gui/Main.fxml");

        Parent root = FXMLLoader.load(location);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
