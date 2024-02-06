import java.util.*;

public class Main {

    public static void main(String[] args) {
        int shotsFired = 0;

        gameStart();
        while (true) {
            int size = gameSize();
            char[][] playGround = new char[size][size];

            initializePlayGround(playGround);
            int shipAmount = shipAmount();
            createShips(playGround, size, shipAmount);
            showPlayGround(playGround, size);
            while (true) {
                int[] coordinates = shoot();
                checkHitanddrownship(coordinates, size, playGround);
                showPlayGround(playGround, size);
                int remainingShips = checkWin(playGround, size);
                if (remainingShips == 0) {
                    System.out.println("Du hast das Spiel gewonnen!");
                    break;
                } else {
                    System.out.println("Es sind noch " + remainingShips + " Schiffe übrig.");
                }
                shotsFired++;
            }
            hitRate(shipAmount, shotsFired);
            System.out.println("Willst du nochmal spielen? Ja/Nein");
            if (!playAgain()) break;
        }
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
                if (size > 2) {
                    return size;
                } else {
                    System.out.println("Die Größe muss größer als 2 sein.\n");
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

    private static int shipAmount() {
        int shipAmount = 0; //
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Bitte Anzahl der Schiffe angeben.");
            shipAmount = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Bitte Gültige Eingabe eingeben");
            scanner.next();
        }
        return shipAmount;
    }

    private static void createShips(char[][] playGround, int size, int shipAmount) {

        Random random = new Random();
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

    }


    private static int[] shoot() {
        int[] coordinates = new int[2];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gib eine x-Koordinate ein!");
        coordinates[1] = scanner.nextInt();

        System.out.println("Gib eine y-Koordinate ein!");
        coordinates[0] = scanner.nextInt();

        return coordinates;
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
                System.out.print(playGround[i][j] == 'S' ? '~' : playGround[i][j]);
                System.out.print(" ".repeat(size >= 10 ? 3 : 2));
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void checkHitanddrownship(int[] coordinates, int size, char[][] playground) {
        int x = coordinates[0];
        int y = coordinates[1];

        if (x < 0 || x >= size || y < 0 || y >= size) {
            System.out.println("Ungültige Koordinaten. Bitte gib gültige Koordinaten ein.");
            return;
        }
        char gameObject = playground[x][y];
        if (gameObject == 'S') {
            System.out.println("Treffer! Du hast ein Schiff getroffen!");
            playground[x][y] = 'X'; //Schiffswrack markiert mit X
        } else if (gameObject == '~') {
            System.out.println("Leider kein Treffer. Versuche es erneut!");
            playground[x][y] = '/';
        }
    }

    private static int checkWin(char[][] playground, int size) {
        int remainingShips = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playground[i][j] == 'S') {
                    remainingShips++;
                }
            }
        }
        return remainingShips;
    }

    static boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        return decision.equals("Ja");
    }

    static void hitRate(int shipAmount, int shotsFired) {
        double hitRate = ((double) shipAmount / shotsFired) * 100;
        System.out.println("Trefferrate: " + hitRate + "%.\n");
    }
}



