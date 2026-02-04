package at.technikum.slm.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Board board;

	public TicTacToe() {
		this.board = new Board();
		this.player1 = new Player('X');
		this.player2 = new Player('O');
		this.currentPlayer = player1;
	}

	public void start() {
		Scanner sc = new Scanner(System.in);

		while (true) { // Gesamtschleife für mehrere Spiele
			board.clear();
			currentPlayer = player1;
			int counterBreak = 0;

			while (counterBreak < 9) {
				board.print();
				System.out.println("Spieler " + currentPlayer.getMarker() + " ist am Zug.");

				int row = -1;
				int column = -1;

				// Reihe
				while (row < 0 || row > 2) {
					System.out.println("Press \"q\" to exit.");
					System.out.print("Row (y) [0-2]: ");
					String input = sc.next();

					if (input.equalsIgnoreCase("q")) {
						System.out.println("Spiel wurde abgebrochen!");
						System.out.print("Nochmal spielen? (j/n): ");
						String choice = sc.next();
						if (!choice.equalsIgnoreCase("j")) {
							System.out.println("Auf Wiedersehen!");
							return;
						}
						break;
					}

					try {
						row = Integer.parseInt(input);
						if (row < 0 || row > 2) {
							System.out.println("Fehler: Row muss zwischen 0 und 2 liegen!");
						}
					} catch (NumberFormatException e) {
						System.out.println("Fehler: Bitte eine ganze Zahl eingeben!");
					}
				}


				// Spalte
				while (column < 0 || column > 2) {
					System.out.println("Press \"q\" to exit.");
					System.out.print("Column (x) [0-2]: ");
					String input = sc.next();

					if (input.equalsIgnoreCase("q")) {
						System.out.println("Spiel wurde abgebrochen!");
						System.out.print("Nochmal spielen? (j/n): ");
						String choice = sc.next();
						if (!choice.equalsIgnoreCase("j")) {
							System.out.println("Auf Wiedersehen!");
							return;
						}
						break;
					}

					try {
						column = Integer.parseInt(input);
						if (column < 0 || column > 2) {
							System.out.println("Fehler: Column muss zwischen 0 und 2 liegen!");
						}
					} catch (NumberFormatException e) {
						System.out.println("Fehler: Bitte eine ganze Zahl eingeben!");
					}
				}


				if (board.isCellEmpty(column, row)) {
					board.place(column, row, currentPlayer.getMarker());
					counterBreak++;

					
					if (hasWinner()) {
						board.print();
						System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
						System.out.print("Nochmal spielen? (j/n): ");
						String choice = sc.next();
						if (!choice.equalsIgnoreCase("j")) {
							System.out.println("Auf Wiedersehen!");
							return;
						}
						break; // neues Spiel
					}

					switchCurrentPlayer();
				} else {
					System.out.println("Dieses Feld ist nicht leer!");
				}
			}

			// UNENTSCHIEDEN
			if (counterBreak == 9) {
				board.print();
				System.out.println("Unentschieden!");
				System.out.print("Nochmal spielen? (j/n): ");
				String choice = sc.next();
				if (!choice.equalsIgnoreCase("j")) {
					System.out.println("Auf Wiedersehen!");
					return;
				}
			}
		}
	}

	public void switchCurrentPlayer() {
		if (currentPlayer.equals(player1)) {
			currentPlayer = player2;
		} else {
			currentPlayer = player1;
		}
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean hasWinner() {
		char m = currentPlayer.getMarker();

		for (int y = 0; y < 3; y++) {
			if (board.getCellValue(0, y) == m &&
					board.getCellValue(1, y) == m &&
					board.getCellValue(2, y) == m) {
				return true;
			}
		}

		for (int x = 0; x < 3; x++) {
			if (board.getCellValue(x, 0) == m &&
					board.getCellValue(x, 1) == m &&
					board.getCellValue(x, 2) == m) {
				return true;
			}
		}

		if (board.getCellValue(0, 0) == m &&
				board.getCellValue(1, 1) == m &&
				board.getCellValue(2, 2) == m) {
			return true;
		}

		if (board.getCellValue(2, 0) == m &&
				board.getCellValue(1, 1) == m &&
				board.getCellValue(0, 2) == m) {
			return true;
		}

		return false;
	}

	public Board getBoard() {
		return board;
	}
}


