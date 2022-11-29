module main.finalproject {

    exports controller to javafx.graphics;
	exports model to javafx.graphics;
	opens model to javafx.base;
	opens controller to javafx.fxml;
    exports main.finalproject to javafx.graphics;
    opens main.finalproject to javafx.fxml;
    
    requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires jdk.compiler;
}
