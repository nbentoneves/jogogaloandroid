package com.jogogalo.model;

public class Player {

    private char symbol;
    private int points;

    public Player(int points, char symbol) {
        setSymbol(symbol);
        setPoints(points);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
