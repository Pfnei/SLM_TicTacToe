package at.technikum.slm.tictactoe;


public class Board {

	private char[][] cells;


	public Board() {
		this.cells = new char[3][3];
		this.clear();
	}

	public boolean isCellEmpty(int x, int y) {
		if (this.cells[x][y] == ' ' ) return true;
		return false;
	}

	public void place(int x, int y, char marker) {
		if (marker == '\0' || marker == ' '){
			System.out.println("Value '\0' or Empty Char not allowed");
			return;}
		this.cells[x][y] = marker;
	}

	public boolean isFull() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (isCellEmpty(x, y)) return false;
			}
		}
		return true;
	}

	public void clear() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				this.cells[x][y] = ' ';
			}
		}

	}

	public void print() {
		System.out.println("  0 1 2");
		for (int y = 0; y < cells.length; y++) {
			System.out.print(y + " ");
			for (int x = 0; x < cells[y].length; x++) {
				System.out.print(cells[x][y]);
				if (x < cells[y].length - 1) System.out.print("|"); //zwischen einzelnen Zellen
			}
			System.out.println();
			if (y < cells.length - 1) System.out.println("  -----"); // Trennlinie zwischen Reihen
		}
	}


	// Helpers
	public char getCellValue(int x, int y) {

		return this.cells[x][y];
	}




}