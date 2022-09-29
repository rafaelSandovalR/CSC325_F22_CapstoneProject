module project {
	exports controller to javafx.graphics;
	exports app to javafx.graphics;
	exports model to javafx.graphics;
	opens model to javafx.base;
	opens controller to javafx.fxml;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.swing;
	requires jdk.compiler;
}