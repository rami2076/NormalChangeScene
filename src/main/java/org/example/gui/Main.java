package org.example.gui;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.Root;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


public class Main implements Initializable {


    @FXML
    private SplitPane textAreaSplitPane;

    @FXML
    private SplitPane labelSplitPane;

    @FXML
    private TextArea inputTextArea;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private Button changeStateButton;

    @FXML
    private Button changeSceneButton;

    private int a = 0;


    private Stage primaryStage;

    private ChangeListener<String> lisnerType1 = (observable, oldValue, newValue) -> {
        convertType1(newValue);
    };

    private ChangeListener<String> lisnerType2 = (observable, oldValue, newValue) -> {
        convertType2(newValue);
    };


    /**
     * @param newValue
     */
    private void convertType1(String newValue) {
        List<String> lines = Arrays.asList(newValue.split("\n"));
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            line = "" + i + line + "\n";
            sb.append(line);
            i++;
        }
        outputTextArea.setText(sb.toString());

    }

    /**
     * @param newValue
     */
    private void convertType2(String newValue) {
        List<String> lines = Arrays.asList(newValue.split("\n"));
        int i = 100;
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            line = "" + i + line + "\n";
            sb.append(line);
            i++;
        }
        outputTextArea.setText(sb.toString());

    }

    /**
     * @param url
     * @param bundle
     */
    @Override
    public void initialize(URL url, java.util.ResourceBundle bundle) {
        labelSplitPane.getDividers().get(0).positionProperty().bindBidirectional(
                textAreaSplitPane.getDividers().get(0).positionProperty());

        changeLisner(lisnerType1);

    }

    @FXML
    private void goToSub(ActionEvent event) throws IOException {
        URL location = Root.class.getClass().getResource("/org/example/gui/sub/Sub.fxml");
        Parent sub = FXMLLoader.load(location);

        Scene tableViewScene = new Scene(sub);

        //This line gets the Stage information:
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }


    @FXML
    private void switchAction(ActionEvent event) {
        if ((this.a % 2) == 0) {
            changeLisner(lisnerType1);
            convertType1(inputTextArea.getText());
        } else {
            changeLisner(lisnerType2);
            convertType2(inputTextArea.getText());
        }
        this.a++;
    }

    /**
     * @param lisner
     */
    private void changeLisner(ChangeListener<String> lisner) {
        inputTextArea.textProperty().addListener(lisner);
    }
}
