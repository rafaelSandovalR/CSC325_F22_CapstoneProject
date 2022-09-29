
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    
    public static void main(String[] args) {
		launch(args);
                System.out.println("");
                  System.out.println("gbhjn");
                  System.out.println("new change");
                
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/LogInView.fxml"));
		Scene scene = new Scene(root, 700, 700);
		Stage primaryStage = new Stage();
		primaryStage.setWidth(700);
		primaryStage.setHeight(700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
