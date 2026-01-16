package at.technikum.slm.tictactoe;

import java.util.Scanner;

public class TicTacToe {
	
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private Board board;
	
	
	public TicTacToe() {
		this.board = new Board();
		this.player1= new Player('X');
		this.player2= new Player('O');
	
	}
	
	public void start() {
	}
	
	public void switchCurrentPlayer() {
	}
	
	public boolean hasWinner() {
		return true;
	}
	
	
}