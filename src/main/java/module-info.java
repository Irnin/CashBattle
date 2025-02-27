module com.irnin.cashbattle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.irnin.cashbattle to javafx.fxml;
    exports com.irnin.cashbattle;
}