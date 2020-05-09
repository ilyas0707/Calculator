package sample;

import java.lang.Math;

public class Calculate {
    public double calculate(double num1, double num2, String operation) {

        double answer;

        if (operation.equals("+")) {
            answer = num1 + num2;
        } else if (operation.equals("-")) {
            answer = num1 - num2;
        } else if (operation.equals("x")) {
            answer = num1 * num2;
        } else if (operation.equals("/")) {
            answer = num1 / num2;
        } else if (operation.equals("^")) {
            answer = Math.pow(num1, num2);
        } else {
            answer = 0;
        }

        return answer;

    }

    public double root(double num1, String operation) {

        double root;

        if (operation.equals("√")) {
            root = Math.sqrt(num1);
        } else {
            root = 0;
        }

        return root;

    }
}
