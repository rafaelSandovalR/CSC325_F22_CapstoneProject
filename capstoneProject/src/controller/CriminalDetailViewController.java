package controller;

import app.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Criminal;

public class CriminalDetailViewController implements Initializable {

    @FXML
    private Button backBtn;
    @FXML
    private ImageView imageview;
    @FXML
    private Label idLabel;
    @FXML
    private Label fnameLabel;
    @FXML
    private Label lNameLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label pobLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label sexLabel;
    @FXML
    private Label heightLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Label raceLabel;
    @FXML
    private Label ethnicityLabel;
    @FXML
    private Label eyeColorLabel;
    @FXML
    private Label hairColorLabel;

    public static Criminal criminal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDetails();
        Image image = new Image("/controller/image.png", 645, 650, false, false);
        imageview.setImage(image);
        imageview.setFitHeight(645);
        imageview.setFitWidth(650);
    }

    public void showDetails() {
        criminal = CriminalListController.criminal;

        idLabel.setText(criminal.getId());
        fnameLabel.setText(criminal.getfName());
        lNameLabel.setText(criminal.getlName());
        dobLabel.setText(criminal.getDate_of_birth());
        pobLabel.setText(criminal.getPlace_of_birth());
        addressLabel.setText(criminal.getAddress());
        sexLabel.setText(criminal.getSex());
        heightLabel.setText(criminal.getHeight());
        weightLabel.setText(criminal.getWeight());
        raceLabel.setText(criminal.getRace());
        ethnicityLabel.setText(criminal.getEthnicity());
        eyeColorLabel.setText(criminal.getEyeColor());
        hairColorLabel.setText(criminal.getHairColor());
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Main.setRoot("/view/CriminalListView.fxml");
    }
}
