public class ConnectFour {
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player(Board.Tile.BOARD_YELLOW);
        players[1] = new Player(Board.Tile.BOARD_RED);
        Board board = new Board(7, 7);

        int x = -1;
        int y = -1;
        int turn = 1;
        do {
            turn = (turn + 1) % 2;
            x = y = -1;
            while (x == -1 || y == -1) {
                board.display();
                x = players[turn].takeTurn(board.getWidth());
                y = board.placeTile(x, players[turn].getTile());
            }
        } while (!Score.checkWin(board, x, y));

        board.display();

        System.out.println("Player " + players[turn].getID() + " wins!");
    }

}