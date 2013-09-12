package com.jogogalo.model;

import java.util.Random;

public class Game {

	// Table game
	private char table[] = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	private Player player1;
	private Player player2;

	public static final char CELULA_VAZIA = ' ';
	public static final int SIZE_TABLE = 9;

	private Random rand;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		start();
	}

	public void start() {
		rand = new Random();

		for (int i = 0; i < SIZE_TABLE; i++) {
			table[i] = CELULA_VAZIA;
		}
	}

	// TODO computer levels
	public void playingComputer(Player player) {

		int valor;

		do {
			valor = rand.nextInt(SIZE_TABLE);
		} while (!playing(player, valor));

	}

	public boolean playing(Player player, int position) {

		if (table[position] != CELULA_VAZIA) {
			return false;
		}

		table[position] = player.getSimble();

		return true;

	}

	public void setPlayer1(Player player) {
		this.player1 = player;
	}

	public void setPlayer2(Player player) {
		this.player2 = player;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	/**
	 * Check Victory
	 * 
	 * @return -1 - no victory | 0 - draw | 1 - victory human | 2 - victory
	 *         computer
	 */
	public int checkVictory() {

		int valor_check_horizontal = checkVictoryHorizontal();

		if (valor_check_horizontal != -1) {
			return valor_check_horizontal;
		}

		int valor_check_vertical = checkVictoryVertical();

		if (valor_check_vertical != -1) {
			return valor_check_vertical;
		}

		int valor_check_first_diagonal = checkFirstDiagonal();

		if (valor_check_first_diagonal != -1) {
			return valor_check_first_diagonal;
		}

		int valor_check_second_diagonal = checkSecondDiagonal();

		if (valor_check_second_diagonal != -1) {
			return valor_check_second_diagonal;
		}

		int valor_check_empate = checkDraw();

		return valor_check_empate;

	}

	public int checkFirstDiagonal() {
		char simble_player_1 = player1.getSimble();
		char simble_player_2 = player2.getSimble();

		if (simble_player_1 == table[0] && simble_player_1 == table[4]
				&& simble_player_1 == table[8]) {
			return ((player1.getClass().getName().equalsIgnoreCase(Human.class
					.getName())) ? 1 : 2);
		}

		if (simble_player_2 == table[0] && simble_player_2 == table[4]
				&& simble_player_2 == table[8]) {
			return ((player2.getClass().getName().equalsIgnoreCase(Human.class
					.getName())) ? 1 : 2);
		}

		return -1;

	}

	public int checkSecondDiagonal() {
		char simble_player_1 = player1.getSimble();
		char simble_player_2 = player2.getSimble();

		if (simble_player_1 == table[2] && simble_player_1 == table[4]
				&& simble_player_1 == table[6]) {
			return ((player1.getClass().getName().equalsIgnoreCase(Human.class
					.getName())) ? 1 : 2);
		}

		if (simble_player_2 == table[2] && simble_player_2 == table[4]
				&& simble_player_2 == table[6]) {
			return ((player2.getClass().getName().equalsIgnoreCase(Human.class
					.getName())) ? 1 : 2);
		}

		return -1;

	}

	public int checkDraw() {

		boolean check = true;

		for (int i = 0; i < SIZE_TABLE; i++) {
			if (table[i] == CELULA_VAZIA) {
				check = false;
				break;
			}
		}

		return (check == true) ? 0 : -1;

	}

	public int checkVictoryVertical() {

		char simble_player_1 = player1.getSimble();
		char simble_player_2 = player2.getSimble();

		for (int i = 0; i <= 2; i++) {
			if (simble_player_1 == table[i] && simble_player_1 == table[i + 3]
					&& simble_player_1 == table[i + 6]) {
				return ((player1.getClass().getName()
						.equalsIgnoreCase(Human.class.getName())) ? 1 : 2);
			}

			if (simble_player_2 == table[i] && simble_player_2 == table[i + 3]
					&& simble_player_2 == table[i + 6]) {
				return ((player2.getClass().getName()
						.equalsIgnoreCase(Human.class.getName())) ? 1 : 2);
			}
		}

		return -1;

	}

	public int checkVictoryHorizontal() {

		char simble_player_1 = player1.getSimble();
		char simble_player_2 = player2.getSimble();

		for (int i = 0; i <= 6; i += 3) {

			if (simble_player_1 == table[i] && simble_player_1 == table[i + 1]
					&& simble_player_1 == table[i + 2]) {
				return ((player1.getClass().getName()
						.equalsIgnoreCase(Human.class.getName())) ? 1 : 2);
			}

			if (simble_player_2 == table[i] && simble_player_2 == table[i + 1]
					&& simble_player_2 == table[i + 2]) {
				return ((player2.getClass().getName()
						.equalsIgnoreCase(Human.class.getName())) ? 1 : 2);
			}
		}

		return -1;

	}

}
