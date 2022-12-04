package app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Crime;
import model.Criminal;
import model.StoreAndBackUpData;

public class Main extends Application {

    public static Scene scene;
    public static Window window;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StoreAndBackUpData dt = new StoreAndBackUpData();

        //Test Data
        Criminal c = new Criminal("Raf", "Sandoval", "04/08/1967", "Stony Brook",
                "123 Applewood Rd, Smithtown, NY, 11787", "Male", "5' 7\"", "170",
                "White", "Latino", "Brown", "Black");
        Criminal c2 = new Criminal("Bruce", "Wayne", "01/23/1980", "Gotham",
                "224 Main St, Gotham, NY, 11223", "Male", "6' 5\"", "210",
                "White", "Non-Latino", "Brown", "Brown");
        StoreAndBackUpData.getCriminals().put(c.getId(), c);
        StoreAndBackUpData.getCriminals().put(c2.getId(), c2);

        Crime x = new Crime(c, "Val", "Merc", "04/13/1994", "Female",
                "123-456-7890", "777 Ocean Ave", "02/02/2022", "10:00pm",
                "Ronkonkoma", "Stolen Car", "3 Years Prison");

        Crime x2 = new Crime(c, "JJ", "Abrams", "08/22/1965", "Male",
                "123-456-7890", "123 LenseFlare Rd", "12/25/2020", "8:00pm",
                "Hollywood", "Punched for releasing Rise of Skywalker", "Dismissed");

        StoreAndBackUpData.getCrimes().put(x.getCrime_id(), x);
        StoreAndBackUpData.getCrimes().put(x2.getCrime_id(), x2);

        //TODO: change back to HomePageView.fxml
        scene = new Scene(loadFXML("/view/LoggedInView.fxml"));
        window = scene.getWindow();

        primaryStage.setScene(scene);
        primaryStage.setWidth(650);
        primaryStage.setHeight(645);
        primaryStage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        window = scene.getWindow();
        window.sizeToScene();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        return fxmlLoader.load();
    }
}
