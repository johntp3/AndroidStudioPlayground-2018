package com.example.john.war;

public class Card {
    private int cardNumber;
    private int cardImage;

    public Card (int cardNumber, int cardImage) {
        this.cardNumber = cardNumber;
        this.cardImage = cardImage;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getCardImage() {
        return cardImage;
    }
}
