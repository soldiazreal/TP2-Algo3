module BlockUs {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    //requires javafx.fxml;

    //opens org.openjfx to javafx.fxml;
    //exports org.openjfx;





    opens com.vista to javafx.graphics;
    exports com.vista;
}
