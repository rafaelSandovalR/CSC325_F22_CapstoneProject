package controller;

import app.Main;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

    @FXML
    private HBox hBox;
    @FXML
    private Button complaintBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button logInBtn;
    @FXML
    private Pane pane;

    @FXML
    private ImageView imageView;

    @FXML
    void exit(ActionEvent event) {

    }
    
    

    @FXML
    void fileComplainMethod(ActionEvent event) throws IOException {
        Main.setRoot("/view/FileAComplaintView.fxml");
    }

    @FXML
    void logInMethod(ActionEvent event) throws IOException {
        Main.setRoot("/view/LogInView.fxml");

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("/controller/image.png", 645, 650, false, false);
        imageView.setImage(image);
        imageView.setFitHeight(645);
        imageView.setFitWidth(650);
    }
}
