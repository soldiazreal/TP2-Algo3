module BlockUs {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    //requires javafx.fxml;

    //opens org.openjfx to javafx.fxml;
    //exports org.openjfx;





    opens com.vista to javafx.graphics;
    exports com.vista;
}
