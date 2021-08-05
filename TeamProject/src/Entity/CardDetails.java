/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.*;

/**
 *
 * @author sajawal
 */
public class CardDetails {
    private char cardType;
    private Date expiryDate;
    private int last4Digits;

    public CardDetails(char cardType, Date expiryDate, int last4Digits) {
        this.cardType = cardType;
        this.expiryDate = expiryDate;
        this.last4Digits = last4Digits;
    }

    public char getCardType() {
        return cardType;
    }

    public void setCardType(char cardType) {
        this.cardType = cardType;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getLast4Digits() {
        return last4Digits;
    }

    public void setLast4Digits(int last4Digits) {
        this.last4Digits = last4Digits;
    }
 
    
}
