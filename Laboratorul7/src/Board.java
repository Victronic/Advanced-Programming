// The class board has a int representing the current number of token
//and a list of tokens

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board {
    Random rand = new Random();
    private int numberOfTokens;
    private final List<Token> tokens = Collections.synchronizedList(new ArrayList<Token>());

    public Board() {
    }
    //we are adding tokens to the board and set the number of the via a parameter
    public void createBoard(int numberOfTokens){
        this.numberOfTokens = numberOfTokens;
        for (int i = 1; i <= this.numberOfTokens; i++) {
            tokens.add(new Token(i));
        }
    }
    // a sync method in which we get a token from the board
    //getting it will also remove it from the array
    //I used random so each player gets a random token
    public synchronized Token getToken(){
        int index = rand.nextInt(tokens.size());
        Token current = tokens.get(index);
        tokens.remove(index);
        numberOfTokens--;
        return current;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }
}
