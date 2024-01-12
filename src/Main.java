import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    private static void gameStart() {
        System.out.println("Zum starten des Spieles 'Start' eingeben.");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        while (!Objects.equals(start, "Start")) {
            start = scanner.nextLine();
        }
        System.out.println("Das Spiel wird gestartet");
        System.out.println();
    }

    private static void initializePlayGround(char[][] playGround) {
        for (char[] row : playGround) {
            Arrays.fill(row, '~');
        }
    }

    private static void showPlayGround(char[][] playGround, int size) {
        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(playGround[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int size = 5;
        char[][] playGround = new char[size][size];

        gameStart();
        initializePlayGround(playGround);
        showPlayGround(playGround, size);

    }
}