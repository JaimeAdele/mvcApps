package minefield;

public class IllegalMoveException extends Exception {
    public IllegalMoveException(String errorMessage) {
        super(errorMessage);
    }
}
