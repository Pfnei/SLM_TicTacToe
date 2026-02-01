package at.technikum.slm.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
	
	@Test
	void getMarker_returnCorrectMarker() {
		Player player = new Player('X');
		assertEquals('X', player.getMarker());
	}
	@Test
	void getMarker_returnDifferentMarker() {
		Player player = new Player('X');
		assertNotEquals('O', player.getMarker());
	}
}