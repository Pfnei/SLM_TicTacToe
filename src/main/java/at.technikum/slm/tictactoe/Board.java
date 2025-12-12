package at.technikum.slm.tictactoe;


public class Board {
	
	private char[][] cells;
	
	
	public Board() {
		this.cells = new char[3][3];
		
	}
	
	public boolean isCellEmpty(int x, int y) {
		if (this.cells[x][y] == '\u0000') return true;
		return false;
	}
	
	public void place(int x, int y, char marker) {
		if (marker == '\u0000'){
			System.out.println("Value '\u0000' not allowed");
			return;}
		this.cells[x][y] = marker;
	}
	
	public boolean isFull() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (isCellEmpty(x, y)) return true;
			}
		}
		return false;
	}
	
	public void clear() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				this.cells[x][y] = '\u0000';
			}
		}
	
	}
	
	public void print() {
	}
	
	
}