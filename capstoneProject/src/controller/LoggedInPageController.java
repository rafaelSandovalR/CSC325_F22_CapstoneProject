package controller;

import app.Main;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoggedInPageController {

    @FXML
    private Button comlaintBtn;

    @FXML
    private Button criminalBtn;

    @FXML
    private MenuButton fileBtn;
    @FXML
    private Pane pane;

    @FXML
    void addCriminal(ActionEvent event) throws IOException {
        Main.setRoot("/view/AddCriminalView.fxml");
    }

    @FXML
    void fileComplaint(ActionEvent event) throws IOException {
        Main.setRoot("/view/FileAComplaintView.fxml");
    }

    @FXML
    void logOutMethod(ActionEvent event) throws IOException {
        Main.setRoot("/view/HomePageView.fxml");
    }

    @FXML
    void viewComplaintHistoryMethod(ActionEvent event) throws IOException {
        Main.setRoot("/view/ComplaintsHistoryView.fxml");
    }

    @FXML
    void viewCriminalListMethod(ActionEvent event) throws IOException {
        Main.setRoot("/view/CriminalListView.fxml");
    }

}
