package com.android.model;

import java.util.Random;

public class Game {

	// Table game
	private char table[] = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };

	private Player player1;
	private Player player2;

	public static final char CELULA_VAZIA = ' ';
	public static final int size_table = 9;

	private Random rand;

	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		start();
	}

	public void start() {
		rand = new Random();

		for (int i = 0; i < size_table; i++) {
			table[i] = CELULA_VAZIA;
		}
	}
	
	public boolean playing(Player player, int position) {

		if (table[position] != CELULA_VAZIA) {
			return false;
		}

		table[position] = player.getSimble();

		return true;

	}

	/**
	 * Check Victory
	 * 
	 * @return -1 - no victory 0 - 1 - victory human 2 - victory computer
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

		int valor_check_secound_diagonal = checkSecoundDiagonal();

		if (valor_check_secound_diagonal != -1) {
			return valor_check_secound_diagonal;
		}

		int valor_check_empate = checkEmpate();

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

	public int checkSecoundDiagonal() {
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

	public int checkEmpate() {

		boolean check = false;

		for (int i = 0; i < size_table; i++) {
			if (table[i] == CELULA_VAZIA) {
				check = true;
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
