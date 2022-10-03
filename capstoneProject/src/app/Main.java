
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.StoreAndBackUpData;

public class Main extends Application{
    
    public static void main(String[] args) {
		launch(args);
                
	}

	@Override
	public void start(Stage arg0) throws Exception {
            StoreAndBackUpData dt = new StoreAndBackUpData();
            
		Parent root = FXMLLoader.load(getClass().getResource("/view/SignUpView.fxml"));
		Scene scene = new Scene(root, 700, 700);
		Stage primaryStage = new Stage();
		primaryStage.setWidth(700);
		primaryStage.setHeight(700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
