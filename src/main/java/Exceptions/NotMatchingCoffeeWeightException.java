/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Przemysław
 */
public class NotMatchingCoffeeWeightException extends Exception {

    public NotMatchingCoffeeWeightException(String message) {
        super(message);
    }
}
