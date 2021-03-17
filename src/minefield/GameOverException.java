package minefield;

public class GameOverException extends Exception {
    public GameOverException(String errorMessage) {
        super(errorMessage);
    }
}
