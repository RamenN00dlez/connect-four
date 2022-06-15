import java.util.Arrays;

public class Display {
    private static String RESET = "\u001B[0m";
    private static String BLACK = "\u001B[30m";
    private static String RED = "\u001B[31m";
    private static String GREEN = "\u001B[32m";
    private static String YELLOW = "\u001B[33m";
    private static String BLUE = "\u001B[34m";
    private static String PURPLE = "\u001B[35m";
    private static String CYAN = "\u001B[36m";
    private static String WHITE = "\u001B[37m";
    private static String CIRCLE = "⬤";

    public static void displayBoard(Board board) {
        for (int height = board.getHeight() - 1; height >= 0; height--) {
            for (int width = 0; width < board.getWidth(); width++) {
                System.out.print(" |");
                Board.Tile tile = board.getBoard()[width][height];
                switch (tile) {
                    case BOARD_RED: {
                        System.out.print(RED + CIRCLE + RESET);
                        break;
                    }
                    case BOARD_YELLOW: {
                        System.out.print(YELLOW + CIRCLE + RESET);
                        break;
                    }
                    default: {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println(" |");
        }
        for (int width = 0; width < board.getWidth(); width++) {
            System.out.printf(" |%d", width + 1);
        }
        System.out.println(" |\n\n");
    }
}