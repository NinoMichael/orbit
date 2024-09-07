module Orbit {
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires java.sql;

	opens com.orbit to javafx.fxml;
    opens com.orbit.controllers to javafx.fxml;
	exports com.orbit;

}