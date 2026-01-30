package at.technikum.slm.tictactoe;

import java.util.Scanner;

public class TicTacToe {

	private Player player1;
	private Player player2;

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	private Player currentPlayer;
	private Board board;


	public TicTacToe() {
		this.board = new Board();
		this.player1= new Player('X');
		this.player2= new Player('O');
		this.currentPlayer = player1;
	}

	public void start() {
	}

	public void switchCurrentPlayer() {
		if(player1 == null || player2 == null){
			throw new NullPointerException("hmm");
		}
		if(currentPlayer.equals(player1)){
			currentPlayer = player2;
		}else{
			currentPlayer = player1;
		}

	}

	public boolean hasWinner() {
		return true;
	}


	public Board getBoard() {
		return board;
	}

	public Player getPlayer() {
		return currentPlayer;
	}
}