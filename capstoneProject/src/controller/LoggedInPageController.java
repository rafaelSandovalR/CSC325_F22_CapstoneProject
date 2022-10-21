package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoggedInPageController {

    @FXML
    void addCriminal(ActionEvent event) throws IOException {
        changeScene(event, "/view/AddCriminal");
    }

    @FXML
    void fileComplaint(ActionEvent event) throws IOException {
        changeScene(event, "/view/FileComplaint");
    }

    @FXML
    void logOutMethod(ActionEvent event) throws IOException {
        changeScene(event, "/view/HomePageView.fxml");
    }

    @FXML
    void viewComplaintHistoryMethod(ActionEvent event) throws IOException {
        changeScene(event, "view/ComplaintsHistoryView");
    }

    @FXML
    void viewCriminalHistoryMethod(ActionEvent event) throws IOException {
        changeScene(event, "view/CriminalHistoryView");
    }

    public void changeScene(ActionEvent event, String str) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(str));
        Parent root = loader.load();
        Scene scene = new Scene(root, 700, 700);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setWidth(700);
        window.setHeight(700);
        window.setScene(scene);
        window.show();
    }

}
