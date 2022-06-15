import java.util.Arrays;

public class Board {
    private int width, height;
    private Tile[][] board;

    public enum Tile {
        BOARD_EMPTY,
        BOARD_RED,
        BOARD_YELLOW
    }

    /**
     * Create a Board object
     * @param w the width of the board
     * @param h the height of the board
     */
    public Board(int w, int h) {
        width = w;
        height = h;
        board = new Tile[width][height];
        Arrays.stream(board).forEach((subArray) -> {
            Arrays.fill(subArray, Tile.BOARD_EMPTY);
        });
    }

    public void display() {
        Display.displayBoard(this);
    }
    /**
     * places a tile at the bottom-most empty space within a given column of the board
     * @param column the column to place the tile in
     * @param tile the tile to be placed
     * @throws OutOfBoundsException thrown when given column index does not exist
     * @throws BadColumnException thrown when given column is completely full of tiles
     * @return the column played in
     */
    public int placeTile(int column, Tile tile) {
        if (!(0 <= column && column < width)) {
            System.out.println("column must be between 1 and " + width + " inclusive.");
            return -1;
        }
        if (!(board[column][height - 1] == Tile.BOARD_EMPTY)) {
            System.out.println("column must have some empty space to place a tile.");
            return -1;
        }
        
        int y = height - (int)Arrays.stream(board[column])
            .filter((c) -> c == Tile.BOARD_EMPTY)
            .count();
        board[column][y] = tile;
        return y;
    }

    /**
     * gets the respective board object
     * @return this board object
     */
    public Tile[][] getBoard() {
        return board;
    }

    public Tile getTile(int x, int y) {
        return board[x][y];
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}