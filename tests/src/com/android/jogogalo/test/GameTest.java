package com.android.jogogalo.test;

import com.jogogalo.model.Computer;
import com.jogogalo.model.Game;
import com.jogogalo.model.Human;

import android.test.AndroidTestCase;

public class GameTest extends AndroidTestCase {

	private Computer computer = new Computer(0, 0, 'X');
	private Human human = new Human(0, 'O', "Laura");
	private Game game;

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		game = new Game(computer, human);

		Computer computer = new Computer(0, 0, 'X');
		Human human = new Human(0, 'O', "Laura");

		game.setPlayer1(computer);
		game.setPlayer2(human);

		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		game = null;
		super.tearDown();
	}

	/**
	 * Check if human victory horizontal
	 */
	public void testCheckVictoryHorizontalHuman() {

		game.playing(computer, 0);
		game.playing(human, 3);
		game.playing(computer, 1);
		game.playing(human, 4);
		game.playing(computer, 6);
		game.playing(human, 5);

		int expect_result = 1;

		int result = game.checkVictoryHorizontal();

		assertEquals(expect_result, result);

	}

	/**
	 * Check if computer victory horizontal
	 */
	public void testCheckVictoryHorizontalComputer() {

		game.playing(computer, 0);
		game.playing(human, 3);
		game.playing(computer, 1);
		game.playing(human, 4);
		game.playing(computer, 2);

		int expect_result = 2;

		int result = game.checkVictoryHorizontal();

		assertEquals(expect_result, result);

	}

	/**
	 * Check draw horizontal
	 */
	public void testCheckVictoryHorizontalDraw() {

		game.playing(computer, 0);
		game.playing(human, 3);
		game.playing(computer, 1);
		game.playing(human, 4);

		int expect_result = -1;

		int result = game.checkVictoryHorizontal();

		assertEquals(expect_result, result);

	}

	/**
	 * Check if human victory vertical
	 */
	public void testCheckVictoryVerticalHuman() {

		game.playing(computer, 1);
		game.playing(human, 0);
		game.playing(computer, 2);
		game.playing(human, 3);
		game.playing(computer, 8);
		game.playing(human, 6);

		int expect_result = 1;

		int result = game.checkVictoryVertical();

		assertEquals(expect_result, result);

	}

	/**
	 * Check if computer victory vertical
	 */
	public void testCheckVictoryVerticalComputer() {

		game.playing(computer, 1);
		game.playing(human, 0);
		game.playing(computer, 4);
		game.playing(human, 3);
		game.playing(computer, 7);

		int expect_result = 2;

		int result = game.checkVictoryVertical();

		assertEquals(expect_result, result);

	}

	/**
	 * Check draw vertical
	 */
	public void testCheckVictoryVerticalDraw() {

		game.playing(computer, 1);
		game.playing(human, 0);
		game.playing(computer, 4);

		int expect_result = -1;

		int result = game.checkVictoryVertical();

		assertEquals(expect_result, result);

	}

	/**
	 * Check if human victory first diagonal
	 */
	public void testCheckVictoryFirstDiagonalHuman() {

		game.playing(computer, 1);
		game.playing(human, 0);
		game.playing(computer, 3);
		game.playing(human, 4);
		game.playing(computer, 2);
		game.playing(human, 8);

		int expect_result = 1;

		int result = game.checkFirstDiagonal();

		assertEquals(expect_result, result);

	}

	/**
	 * Check if computer victory first diagonal
	 */
	public void testCheckVictoryFirstDiagonalComputer() {

		game.playing(computer, 0);
		game.playing(human, 1);
		game.playing(computer, 4);
		game.playing(human, 3);
		game.playing(computer, 8);

		int expect_result = 2;

		int result = game.checkFirstDiagonal();

		assertEquals(expect_result, result);

	}

	/**
	 * Check if human victory second diagonal
	 */
	public void testCheckVictorySecondDiagonalHuman() {

		game.playing(computer, 1);
		game.playing(human, 2);
		game.playing(computer, 5);
		game.playing(human, 4);
		game.playing(computer, 8);
		game.playing(human, 6);

		int expect_result = 1;

		int result = game.checkSecondDiagonal();

		assertEquals(expect_result, result);

	}

	/**
	 * Check if computer victory second diagonal
	 */
	public void testCheckVictorySecondDiagonalComputer() {

		game.playing(computer, 2);
		game.playing(human, 1);
		game.playing(computer, 4);
		game.playing(human, 5);
		game.playing(computer, 6);

		int expect_result = 2;

		int result = game.checkSecondDiagonal();

		assertEquals(expect_result, result);

	}

	/**
	 * Check draw
	 */
	public void testCheckDraw() {

		game.playing(computer, 1);
		game.playing(human, 0);
		game.playing(computer, 3);
		game.playing(human, 2);
		game.playing(computer, 4);
		game.playing(human, 5);
		game.playing(computer, 8);
		game.playing(human, 6);
		game.playing(human, 7);

		int expect_result = 0;

		int result = game.checkDraw();

		assertEquals(expect_result, result);

	}

}
