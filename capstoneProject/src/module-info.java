module project {
	exports controller to javafx.graphics;
	exports app to javafx.graphics;
	exports model to javafx.graphics;
	opens model to javafx.base;
	opens controller to javafx.fxml;
        opens app to javafx.fxml;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.swing;
	requires jdk.compiler;
/*
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires org.json;
    requires org.xerial.sqlitejdbc;
*/
    requires java.base;
}