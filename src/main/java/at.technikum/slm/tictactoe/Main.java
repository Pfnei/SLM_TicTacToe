package at.technikum.slm.tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Board board = new Board();
        Player player = new Player('X'); 
        Scanner sc = new Scanner(System.in);

        int row;
        int column;

        System.out.print("row (0-2): ");
        row = sc.nextInt();

        System.out.print("column (0-2): ");
        column = sc.nextInt();

        if (board.isCellEmpty(row, column)) {
            board.place(row, column, player.getMarker());
        } else {
            System.out.println("Sorry, this field is either empty or row and column are not within 0-2");
        }
        
    }
}