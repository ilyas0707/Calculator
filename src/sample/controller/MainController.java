package sample.controller;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.Calculate;

public class MainController {

    private double num1 = 0;
    private double num2 = 0;
    private String operation = "";
    private boolean init = true;
    private Calculate calc = new Calculate();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label answer;

    @FXML
    void number(ActionEvent event) {
        if (init) {
            answer.setText("");
            init = false;
        }

        String label = ((Button)event.getSource()).getText();
        answer.setText(answer.getText() + label);
    }

    @FXML
    void operation(ActionEvent event) {
        String label = ((Button)event.getSource()).getText();

        if (label.equals("C")) {
            try {
                answer.setText(answer.getText().substring(0, answer.getText().length() - 1));
            } catch (Exception e) {
                answer.setText("");
            }
        } else if (label.equals("CA")) {
            try {
                answer.setText("");
            } catch (Exception e) {
                answer.setText("");
            }
        } else if (!label.equals("=")) {
            if (!operation.isEmpty())
                return;
            try {
                num1 = Double.parseDouble(answer.getText());
                operation = label;
                answer.setText("");
            } catch (Exception e) {
                answer.setText("Enter number first!");
            }
        } else if (operation.equals("√")) {
            double root = calc.root(num1, operation);
            answer.setText(String.valueOf(root));
        } else {
            if (operation.isEmpty())
                return;
            num2 = Double.parseDouble(answer.getText());
            try {
                double output = calc.calculate(num1, num2, operation);
                answer.setText(String.valueOf(output));
                FileWriter lastResult = new FileWriter("lastOperation.txt");
                lastResult.write(num1 + operation + num2 + "=" + output);
                lastResult.close();
            } catch (Exception e) {
                answer.setText("Cannot divide by zero!");
            }

            operation = "";
            init = true;
        }
    }

    @FXML
    void initialize() {

    }
}

