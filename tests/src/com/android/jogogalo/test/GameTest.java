package com.android.jogogalo.test;

import com.android.model.Computer;
import com.android.model.Game;
import com.android.model.Human;

import android.test.AndroidTestCase;

public class GameTest extends AndroidTestCase {

	private Computer computer = new Computer(0, 0, 'X');
	private Human human = new Human(0, 'O', "Laura");
	private Game game;
	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		game = new Game(computer, human);
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
	
}
