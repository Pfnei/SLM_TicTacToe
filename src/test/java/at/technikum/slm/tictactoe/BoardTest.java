package at.technikum.slm.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
		Board board = new Board();
		
		board.place(1, 2, 'X');
		assertFalse(board.isFull());
		
		fillBoard(board,3,3,'A');
		assertTrue(board.isFull());
		
		board.clear();
		
		// not the whole board ist filled
		fillBoard(board,3,2,'H');
		assertFalse(board.isFull());
	}
	
	@Test
	void clear() {
		Board board = new Board();
		board.place(1, 2, 'X');
		board.clear();
		assertTrue(board.isCellEmpty(1,2));
		
		fillBoard(board,3,3,'P');
		assertTrue(board.isFull());
		board.clear();
		
		boolean boardHasEntry = false;
				for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (!board.isCellEmpty(x,y)) { boardHasEntry = true;}
			}
		}
		assertFalse(boardHasEntry);
		
		boardHasEntry = false;
		board.place(1, 2, 'X');
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (!board.isCellEmpty(x,y)) { boardHasEntry = true;}
			}
		}
		assertTrue(boardHasEntry);
	}
	
	@Test
	void print() {
	}
	
	
	private void fillBoard (Board board,int xu, int yu, char marker){
		
		for (int x = 0; x < xu; x++) {
			for (int y = 0; y < yu; y++) {
				board.place(x, y, marker);
			}
		}
	}
	
}

