package com.android.model;

public class Player {

	private char simble;
	private int points;

	public Player(int points, char simble) {
		setSimble(simble);
		setPoints(points);
	}

	public char getSimble() {
		return simble;
	}

	public void setSimble(char simble) {
		this.simble = simble;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
