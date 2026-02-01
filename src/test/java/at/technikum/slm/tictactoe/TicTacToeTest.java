package at.technikum.slm.tictactoe;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
	void hasWinner() {
	}
}