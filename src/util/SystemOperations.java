/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author fonis
 */
public class SystemOperations {

    private static SystemOperations systemOperationsInstance;

    private SystemOperations() {
    }

    public static SystemOperations getSystemOperationsInstance() {
        if (systemOperationsInstance == null) {
            systemOperationsInstance = new SystemOperations();
        }
        return systemOperationsInstance;
    }

    public double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public double substract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
