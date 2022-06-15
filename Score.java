import java.util.Arrays;
import java.util.Collections;

public class Score {
    /**
     * checks if the tile at the current coordinates is involved in a winning play
     * @param x the x coordinate of the tile
     * @param y the y coordinate of the tile
     * @return true if win, false if not
     */
    public static boolean checkWin(Board board, int x, int y) {
        Board.Tile color = board.getTile(x, y);
        int h = countHorizontal(board, x, y, color);
        int v = countVertical(board, x, y, color);
        int f = countForward(board, x, y, color);
        int b = countBackward(board, x, y, color);

        int max = Collections.max(Arrays.asList(h, v, f, b));
        return max >= 4;
    }

    private static int countHorizontal(Board board, int x, int y, Board.Tile tile) {
        int total = 1;
        int Offset = 0;
        
        while (x + ++Offset < board.getWidth() && board.getTile(x + Offset, y) == tile) {
            total++;
        }
        Offset = 0;
        while (x + --Offset >= 0 && board.getTile(x + Offset, y) == tile) {
            total++;
        }
        return total;
    }

    private static int countBackward(Board board, int x, int y, Board.Tile tile) {
        int total = 1;
        int vOffset = 0;
        int hOffset = 0;
        
        while ((y + --vOffset >= 0 && x + ++hOffset < board.getWidth())&& board.getTile(x + hOffset, y + vOffset) == tile) {
            total++;
        }
        vOffset = 0;
        hOffset = 0;
        while ((y + ++vOffset < board.getHeight() && x + --hOffset >= 0)&& board.getTile(x + hOffset, y + vOffset) == tile) {
            total++;
        }
        return total;
    }

    private static int countVertical(Board board, int x, int y, Board.Tile tile) {
        int total = 1;
        int Offset = 0;
        
        while (y + ++Offset < board.getHeight() && board.getTile(x, y + Offset) == tile) {
            total++;
        }
        Offset = 0;
        while (y + --Offset >= 0 && board.getTile(x, y + Offset) == tile) {
            total++;
        }
        return total;
    }

    private static int countForward(Board board, int x, int y, Board.Tile tile) {
        int total = 1;
        int vOffset = 0;
        int hOffset = 0;
        
        while ((y + ++vOffset < board.getHeight() && x + ++hOffset < board.getWidth())&& board.getTile(x + hOffset, y + vOffset) == tile) {
            total++;
        }
        vOffset = 0;
        hOffset = 0;
        while ((y + --vOffset >= 0 && x + --hOffset >= 0)&& board.getTile(x + hOffset, y + vOffset) == tile) {
            total++;
        }
        return total;
    }
}