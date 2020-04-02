//Player class which implements runnable
//it has a name and a list of each player tokens
//I created a Board obj to have access to the game board

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {
    private String name;
    private List<Token> token_list = Collections.synchronizedList(new ArrayList<Token>());
    private Board game_board;

    // I decided to give the board when creating the player
    public Player(String name, Board game_board) {
        this.name = name;
        this.game_board = game_board;

    }
    //a player will constantly draw a token until there are no more left
    //I used synchronized and a sleep to make the to player alternate between drawing
    // and to ensure they will "play" in turns
    // at the end of the game each player will show his tokens
    @Override
    public void run() {
        while (game_board.getNumberOfTokens()!=0){
            token_list.add(game_board.getToken());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName()+" has the following tokens:");
        printTokens();
    }

    public String getName() {
        return name;
    }

    public void printTokens(){
        for (Token t :token_list) {
            System.out.print(t.getNumber()+" ");
        }
        System.out.println();
    }
}
