
module project {
	exports app to javafx.graphics;
	opens app to javafx.base;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.swing;
	requires jdk.compiler;
    requires javafx.swt;
    requires javafx.media;
    requires javafx.web;
}