package at.technikum.slm.tictactoe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TicTacToeTest {

	@Test
	void start_acceptsValidInput() {
		InputStream originalIn = System.in;
		PrintStream originalOut = System.out;

		try {
			// Spieler X setzt auf (0,0)
			String input = "0\n0\n";
			System.setIn(new ByteArrayInputStream(input.getBytes()));

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));

			TicTacToe game = new TicTacToe();
			game.start();

			String printed = out.toString();

			assertTrue(printed.contains("Row (y)"));
			assertTrue(printed.contains("Column (x)"));
			assertTrue(printed.contains("Spieler X ist am Zug"));

		} finally {
			System.setIn(originalIn);
			System.setOut(originalOut);
		}
	}

	@Test
	void start_handlesInvalidInput() {
		InputStream originalIn = System.in;
		PrintStream originalOut = System.out;

		try {
			// viele ungültige Eingaben, dann gültige
			String input = "-1\n5\n1.2\n0\n3\n0\n";
			System.setIn(new ByteArrayInputStream(input.getBytes()));

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			System.setOut(new PrintStream(out));

			TicTacToe game = new TicTacToe();
			game.start();

			String printed = out.toString();

			assertTrue(printed.contains("Fehler: Row"));
			assertTrue(printed.contains("Fehler: Column"));
			assertTrue(printed.contains("Fehler: Bitte"));

		} finally {
			System.setIn(originalIn);
			System.setOut(originalOut);
		}
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
		assertNotEquals(player1, game.getCurrentPlayer());
	}

	@Test
    void testHasWinnerInFirstRow() {
    	TicTacToe game = new TicTacToe();
    	Board board = game.getBoard();
    	board.place(0, 0, 'X');
    	board.place(1, 0, 'X');
    	board.place(2, 0, 'X');
    	assertTrue(game.hasWinner(), "Spieler X sollte durch die oberste Reihe gewinnen");
    }

	@Test
		public void testHasNoWinner() {
    	TicTacToe game = new TicTacToe();
    	Board board = game.getBoard();
    	board.place(0, 0, 'X');
    	board.place(1, 1, 'O');
    	board.place(2, 2, 'X');
    	assertFalse(game.hasWinner(), "Es gibt noch keinen Gewinner");
    }

}