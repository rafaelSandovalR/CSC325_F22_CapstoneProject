package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import main.finalproject.App;

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
        App.setRoot("FileAComplaintView.fxml");
    }

    @FXML
    void logInMethod(ActionEvent event) throws IOException {
        App.setRoot("LogInView.fxml");

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        pane.getStylesheets().add("HomePageSS.css");
        Image image = new Image("file:image.png", 645, 650, false, false);
        imageView.setImage(image);
        imageView.setFitHeight(645);
        imageView.setFitWidth(650);
    }
}
