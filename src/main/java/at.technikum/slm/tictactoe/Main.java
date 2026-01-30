package at.technikum.slm.tictactoe;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

        Board board = new Board();
        Player player = new Player('X');
        Scanner sc = new Scanner(System.in);

        int row = -1;    // y
        int column = -1; // x

        board.print();

        
        while (row < 0 || row > 2) {
            try {
                System.out.print("Row (y) [0-2]: ");
                row = sc.nextInt();
                if (row < 0 || row > 2) {
                    System.out.println("Fehler: Row muss zwischen 0 und 2 liegen!");
                }
            }
            catch  (InputMismatchException e) {
                System.out.println("Fehler: Bitte eine ganze Zahl eingeben!");
                sc.nextLine();
            }
            
        }
        
        

        while (column < 0 || column > 2) {
            try {
                System.out.print("Column (x) [0-2]: ");
                column = sc.nextInt();
                if (column < 0 || column > 2) {
                    System.out.println("Fehler: Column muss zwischen 0 und 2 liegen!");
                }
            }
            catch  (InputMismatchException e) {
                    System.out.println("Fehler: Bitte eine ganze Zahl eingeben!");
                    sc.nextLine();
            }
        }

        
        if (board.isCellEmpty(column, row)) {
            board.place(column, row, player.getMarker());
        } else {
            System.out.println("Dieses Feld ist nicht leer!");
        }

        board.print();
    }
}