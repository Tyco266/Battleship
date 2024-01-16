import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        gameStart();

        int size = gameSize();
        char[][] playGround = new char[size][size];

        initializePlayGround(playGround);
        //Tyco:Zauber Schiffe da rein
        //Mia int x, y
        showPlayGround(playGround, size);
        //Userdialog > x: 1 y: 2
        int fakex=0,fakey=1;
        checkHitanddrownship(fakex,fakey,size,playGround);

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
                System.out.println("Spiel gestartet");
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

public Scanner [] shoot() {
        System.out.println("Gib eine x Koordinate ein!");
        Scanner x = new Scanner(System.in);
        System.out.println("Gib eine y-Koordinate ein!");
        Scanner y = new Scanner (System.in);
        Scanner[] koordinate = {x,y};
        return koordinate;

    }

    private static void initializePlayGround(char[][] playGround) {
        for (char[] row : playGround) {
            Arrays.fill(row, '~');
        }
    }

    private static void showPlayGround(char[][] playGround, int size) {
        System.out.print("   ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d  ",i);
            //System.out.print(i + "  ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%2d  ",i);
            //System.out.print(i + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(playGround[i][j] + " ".repeat(size >= 10 ? 3 : 2));
            }
            System.out.println();
        }
        System.out.println();
    }


    public static boolean checkHitanddrownship(int x, int y, int size, char[][] playground) {
        if (x < 0 || x > size || y < 0 || y > size) {
            System.out.println("Ungültige Koordinaten. Bitte gib gültige Koordinaten ein.");
            return false;
        }
        char gameObject = playground[x][y];
        if (gameObject != '~' ) {
            System.out.println("Treffer! Du hast ein Schiff getroffen!");
            playground[x][y] = 'X'; //Schiffswrack markiert mit X
            return true;
        } else {
            System.out.println("Leider kein Treffer. Versuche es erneut!");
            return false;
        }
    }

}

