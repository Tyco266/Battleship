import java.util.*;

public class Main {

    public static void main(String[] args) {
        gameStart();

        int size = gameSize();
        char[][] playGround = new char[size][size];

        initializePlayGround(playGround);
        createShips(playGround, size);
        showPlayGround(playGround, size);
    }

    private static void gameStart() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Zum starten des Spiels 'Start' eingeben, zum lesen der Anleitung 'Anleitung' eingeben.");
            String choose = scanner.nextLine();

            if (Objects.equals(choose, "Anleitung")) {
                System.out.println("Anleitung hier\n");
                continue;
            } else if (Objects.equals(choose, "Start")) {
                break;
            }
            System.out.println("Ungültige Eingabe. Bitte 'Start' oder 'Anleitung' eingeben.");

        }

    }

    private static int gameSize() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Bitte größe des Spielfelds als einzelne Zahl eingeben.");
                int size = scanner.nextInt();
                if (size > 3) {
                    System.out.println("Das Spiel wird gestartet");
                    System.out.println();
                    return size;
                } else {
                    System.out.println("Die Größe muss größer als 0 sein.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                System.out.println();
                scanner.next();
            }
        }
    }


    private static void initializePlayGround(char[][] playGround) {
        for (char[] row : playGround) {
            Arrays.fill(row, '~');
        }
    }

    private static void createShips(char[][] playGround, int size) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Bitte Anzahl der Schiffe angeben.");
            Random random = new Random();
            int shipAmount = scanner.nextInt();
            if (shipAmount < size * size) {
                for (int i = 0; i < shipAmount; i++) {
                    int x = random.nextInt(size - 1);
                    int y = random.nextInt(size - 1);
                    if (playGround[x][y] == 'S') {
                        i--;
                    } else {
                        playGround[x][y] = 'S';
                    }
                }
                System.out.println("Spiel gestartet");
            }


        } catch (InputMismatchException e) {
            System.out.println("...");
            scanner.next();
        }


    }

    private static void showPlayGround(char[][] playGround, int size) {
        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d%s", i, " ".repeat(size >= 10 ? 2 : 1));
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d  ", i);
            for (int j = 0; j < size; j++) {
                System.out.print(playGround[i][j] + " ".repeat(size >= 10 ? 3 : 2));
            }
            System.out.println();
        }
        System.out.println();
    }
}



