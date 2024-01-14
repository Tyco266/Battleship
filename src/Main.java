import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    private static void gameStart() {
        Scanner scanner = new Scanner(System.in);
        String choose;

        while (true) {
            System.out.println("Zum starten des Spiels 'Start' eingeben, zum lesen der Anleitung 'Anleitung' eingeben.");
            choose = scanner.nextLine();

            if (Objects.equals(choose, "Anleitung")) {
                System.out.println("Anleitung hier");
                System.out.println();
                continue;
            } else if (Objects.equals(choose, "Start")) {
                System.out.println("Spiel gestartet");
                break;
            } else {
                System.out.println("Ungültige Eingabe. Bitte 'Start' oder 'Anleitung' eingeben.");
            }
        }

    }

    private static int gameSize() {
        int size;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Bitte größe des Spielfelds als einzelne Zahl eingeben.");
                size = scanner.nextInt();
                if (size > 3) {
                    break;
                } else {
                    System.out.println("Die Größe muss größer als 0 sein.S");
                    System.out.println();
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                System.out.println();
                scanner.next();
            }
        }


        System.out.println("Das Spiel wird gestartet");
        System.out.println();
        return size;
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
        gameStart();

        int size = gameSize();
        char[][] playGround = new char[size][size];

        initializePlayGround(playGround);
        showPlayGround(playGround, size);

    }
}