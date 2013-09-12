package com.jogogalo.model;

public class Computer extends Player {

	private int level;

	public Computer(int points, int level, char simble) {
		super(points, simble);
		setLevel(level);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
