import java.util.Arrays;

public class Main {

    private static void initializePlayGround(char[][] playGround) {
        for (char[] row : playGround) {
            Arrays.fill(row, '~');
        }
    }

    private static void showPlayGround(char[][] playGround, int size) {
        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < playGround[i].length; j++) {
                System.out.print(playGround[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int size = 5;
        char[][] playGround = new char[size][size];

        initializePlayGround(playGround);
        showPlayGround(playGround, size);

    }
}