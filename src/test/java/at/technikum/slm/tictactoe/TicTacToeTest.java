package at.technikum.slm.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
	
	@Test
	void start() {
	}
	
	@Test
	void switchCurrentPlayer_switchBackToPlayer1() {
		TicTacToe game = new TicTacToe();
		Player player1 = game.getCurrentPlayer();
		game.switchCurrentPlayer();
		game.switchCurrentPlayer();
		assertEquals(player1, game.getCurrentPlayer());
	}

	@Test
	void switchCurrentPlayer_switchPlayer1ToPlayer2() {
		TicTacToe game = new TicTacToe();
		Player player1 = game.getCurrentPlayer();
		game.switchCurrentPlayer();
		Player player2 = game.getCurrentPlayer();
		assertEquals(player1, player2);
	}

	@Test
	void hasWinner() {
	}
}