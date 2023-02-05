module plan.vacation {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens plan.vacation to javafx.fxml;
    exports plan.vacation;
}
