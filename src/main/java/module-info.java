module mx.utng {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;          //<-----

    opens mx.utng.controller to javafx.fxml;    //<---
    exports mx.utng;
    exports mx.utng.controller;             //<---
}
