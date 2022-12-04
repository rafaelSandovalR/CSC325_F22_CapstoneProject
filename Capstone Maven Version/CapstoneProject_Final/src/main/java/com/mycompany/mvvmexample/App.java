package com.mycompany.mvvmexample;

import com.google.cloud.firestore.Firestore;
import com.mycompany.mvvmexample.FirestoreContext;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.StoreAndBackUpData;

/**
 * JavaFX App
 */
public class App extends Application {

    public static Firestore fstore;
    private final FirestoreContext contxtFirebase = new FirestoreContext();
    public static Scene scene;
    public static Window window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        fstore = contxtFirebase.firebase();
        StoreAndBackUpData dt = new StoreAndBackUpData();
        Parent login = FXMLLoader.load(getClass().getResource("AddCriminalView.fxml")); //"FileAComplaintView.fxml"
        Scene scene = new Scene(login);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
   

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        window = scene.getWindow();
        window.sizeToScene();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {

        launch(args);

    }

}
