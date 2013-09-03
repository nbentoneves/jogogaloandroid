package com.android.jogogalo.test;

import com.android.model.Computer;
import com.android.model.Game;
import com.android.model.Human;

import android.test.AndroidTestCase;

public class GameTest extends AndroidTestCase {

	private Game game;
	
	protected void setUp() throws Exception {
		game = new Game();
		//super.setUp();
	}

	protected void tearDown() throws Exception {
		game = null;
		//super.tearDown();
	}
	
	public void testPlaying() {
		fail("Not yet implemented");
	}

	public void testCheckVictory() {
		fail("Not yet implemented");
	}

	public void testCheckFirstDiagonal() {
		fail("Not yet implemented");
	}

	public void testCheckSecoundDiagonal() {
		fail("Not yet implemented");
	}

	public void testCheckEmpate() {
		fail("Not yet implemented");
	}

	public void testCheckVictoryVertical() {
		fail("Not yet implemented");
	}

	public void testCheckVictoryHorizontal() {
		
		Computer computer = new Computer(0, 0, 'X');
		Human human = new Human(0, 'O', "Laura");
	
		game.playing(computer, 0);
		game.playing(human, 3);
		game.playing(computer, 1);
		game.playing(human, 4);
		game.playing(computer, 6);
		game.playing(human, 5);

		int expect_result = 1;

		int result = game.checkVictory();

		assertEquals(expect_result, result);
		
	}

}
