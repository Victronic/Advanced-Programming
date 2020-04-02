//the game class which will create the board and players and start 2 thread for each
public class Game extends Thread {
    Board game_board = new Board();
    public void init(){
        game_board.createBoard(5);
        Board alt_board = new Board();
        Runnable player1 = new Player("player1",game_board);
        Runnable player2 = new Player("player2",game_board);
        new Thread(player1).start();
        new Thread(player2).start();
    }
}
