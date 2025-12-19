package at.technikum.slm.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BoardTest {
	
	@Test
	void isCellEmpty() {
		Board board = new Board();
		assertTrue(board.isCellEmpty(1,2));
		
		board.place(0,0, '\0');
		assertTrue(board.isCellEmpty(0,0));
		
		board.place(2,2, 'U');
		assertFalse(board.isCellEmpty(2,2));
	}
	
	@Test
	void place() {
		Board board = new Board();
		assertTrue(board.isCellEmpty(1,2));
		board.place(1,2, '5');
		
		assertFalse(board.isCellEmpty(1,2));
		assertEquals ('5', board.getCellValue(1,2));
		assertNotEquals ('7', board.getCellValue(1,2));
		assertFalse(board.isFull());
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			board.place(10, 10, 'X');
		});
		
		board.place(0,0, '\0');
		System.out.println(board.getCellValue(0,0));
		assertTrue(board.isCellEmpty(0,0));
	}
	
	@Test
	void isFull() {
	}
	
	@Test
	void clear() {
	}
	
	@Test
	void print() {
	}
}