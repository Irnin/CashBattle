package com.irnin.cashbattle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    // Properties
    Team blue;

    @FXML
    private TextField input;

    @FXML
    private Label balance;

    // Methods
    @FXML
    protected void charge() {
        int amount = getAmountFromInput();
        blue.charge(amount);
    }

    @FXML
    protected void increase() {
        int amount = getAmountFromInput();
        blue.increaseBalance(amount);
    }

    // Init
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        blue = new Team();
        balance.textProperty().bind(Bindings.concat(blue.getAccountBalanceProperty()));
    }

    // Utility
    private int getAmountFromInput() {
        String providedAmount = input.getText();

        if (providedAmount == null || providedAmount.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(providedAmount);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}