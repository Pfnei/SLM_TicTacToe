package at.technikum.slm.tictactoe;

import java.util.InputMismatchException;
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
		int counterBreak = 0;
		while (sc.hasNext() && counterBreak < 9) {

			currentPlayer = getCurrentPlayer();
			board.print();
			System.out.println("Spieler " + currentPlayer.getMarker() + " ist am Zug.");

			int row = -1;
			int column = -1;

			// Eingabe für Reihe
			while (row < 0 || row > 2) {
				try {
					System.out.print("Row (y) [0-2]: ");
					row = sc.nextInt();
					if (row < 0 || row > 2) System.out.println("Fehler: Row muss zwischen 0 und 2 liegen!");
				} catch (InputMismatchException e) {
					System.out.println("Fehler: Bitte eine ganze Zahl eingeben!");
					sc.nextLine();
				}
			}

			// Eingabe für Spalte
			while (column < 0 || column > 2) {
				try {
					System.out.print("Column (x) [0-2]: ");
					column = sc.nextInt();
					if (column < 0 || column > 2) System.out.println("Fehler: Column muss zwischen 0 und 2 liegen!");
				} catch (InputMismatchException e) {
					System.out.println("Fehler: Bitte eine ganze Zahl eingeben!");
					sc.nextLine();
				}
			}




			// Marker setzen
			if (board.isCellEmpty(column, row)) {
				board.place(column, row, currentPlayer.getMarker());
				counterBreak++;
				if (hasWinner()) {
					board.print();
					System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
					return;
				}
				switchCurrentPlayer();
			} else {
				System.out.println("Dieses Feld ist nicht leer!");
			}
			counterBreak++;
			System.out.println("---------------------+"+counterBreak);
			if(counterBreak == 9){
				break;
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

		return false;
	}

	public Board getBoard() {
		return board;
	}
}
