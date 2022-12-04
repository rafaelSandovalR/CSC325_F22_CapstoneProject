package modelview;

import com.mycompany.mvvmexample.App;
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
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoggedInPageController implements Initializable{
    
    public static String loggedIn = "false";
    @FXML
    private ImageView imageview;
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
        loggedIn = "true";
        App.setRoot("/view/AddCriminalView.fxml");
    }

    @FXML
    void fileComplaint(ActionEvent event) throws IOException {
        loggedIn = "true";
        App.setRoot("/view/FileAComplaintView.fxml");
    }

    @FXML
    void logOutMethod(ActionEvent event) throws IOException {
        loggedIn = "false";
        App.setRoot("/view/HomePageView.fxml");
    }

    @FXML
    void viewComplaintHistoryMethod(ActionEvent event) throws IOException {
        loggedIn = "true";
         App.setRoot("/view/ComplaintsHistoryView.fxml");
    }

    @FXML
    void viewCriminalHistoryMethod(ActionEvent event) throws IOException {
        loggedIn = "true";
        App.setRoot("/view/ComplaintsHistoryView.fxml");
    }

    @FXML
    void viewCriminalListMethod(ActionEvent event) throws IOException {
     loggedIn = "true";
        App.setRoot("/view/CriminalListView.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("/controller/image.png", 645, 650, false, false);
        imageview.setImage(image);
        imageview.setFitHeight(645);
        imageview.setFitWidth(650);
    }

}