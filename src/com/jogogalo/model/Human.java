package com.jogogalo.model;

public class Human extends Player {

	private String name;

	public Human(int points, char simble, String name) {
		super(points, simble);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
