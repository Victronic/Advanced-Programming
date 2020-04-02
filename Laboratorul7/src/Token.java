//A simple class representing the token with a value

public class Token {
    private int number;

    public Token(int number) {
        this.number = number;
    }

    public Token() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
