/*
 * Copyright 2018, Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package com.github.tombentley.rivieradev2018.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CreditCardDetails {
    private String nameOnCard;
    private long cardNumber;
    private Date validFromDate;
    private Date expiryDate;
    private int cvc;

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getValidFromDate() {
        return validFromDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setValidFromDate(Date validFromDate) {
        this.validFromDate = validFromDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    @Override
    public String toString() {
        return "CreditCardDetails{" +
                "nameOnCard='" + nameOnCard + '\'' +
                ", cardNumber=" + cardNumber +
                ", validFromDate=" + validFromDate +
                ", expiryDate=" + expiryDate +
                ", cvc=" + cvc +
                '}';
    }
}
