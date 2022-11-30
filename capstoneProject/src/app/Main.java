package app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
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

        scene = new Scene(loadFXML("/view/HomePageView.fxml"));
        window = scene.getWindow();
        

        primaryStage.setScene(scene);
        primaryStage.setWidth(650);
        primaryStage.setHeight(645);
        primaryStage.show();
    }
    
    public static void setRoot(String fxml)throws IOException{
        scene.setRoot(loadFXML(fxml));
        window = scene.getWindow();
        window.sizeToScene();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        return fxmlLoader.load();
    }
}
