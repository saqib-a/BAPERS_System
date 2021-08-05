/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author sajawal
 */
public class Payment {
    private float amount;
    private char paymentType;

    public Payment(float amount, char paymentType) {
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public char getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(char paymentType) {
        this.paymentType = paymentType;
    }
    
    
}
