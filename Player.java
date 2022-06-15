import java.util.Scanner;

public class Player {
    private Board.Tile color;
    private int id;
    private static int counter = 1;
    /**
     * creates a new player object
     * @param tileColor color for this player's tile
     * @param id id number of the player
     */
    public Player(Board.Tile tileColor) {
        color = tileColor;
        id = counter++;
    }

    public Board.Tile getTile() {
        return color;
    }

    public int getID() {
        return id;
    }

    /**
     * Prompt the player to take their turn
     * @param maxOption the maximum column to choose
     * @return the column chosen
     */
    public int takeTurn(int maxOption) {
        Scanner input = new Scanner(System.in);
        int column = -1;

        while(column <= 0 || column > maxOption) {
            System.out.printf("PLAYER %d\nPlace a tile between column 1 and %d.\n", id, maxOption);
            try {
                column = Integer.parseInt(input.nextLine());
            }
            catch (Exception e) {
                System.out.printf("Something went wrong.Enter a number between 1 and %d\n", maxOption);
            }
        }

        return column;
    }
}