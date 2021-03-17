package minefield;

import mvc.*;

import java.util.ArrayList;

public class Minefield extends Model {

    public static int FIELD_WIDTH = 50;
    public static int FIELD_HEIGHT = 50;
    public static int percentMined = 5;

    private ArrayList<ArrayList<Square>> field;
    private Square currentPosition;
    private Boolean gameOver = false;

    public Minefield() { //initialize a new Minefield model

        //create field of squares as two-dimensional array
        //representation as column x row, so a 50x100 field is 50 wide and 100 tall
        field = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            ArrayList<Square> newColumn = new ArrayList<>();
            for (int j = 0; j < FIELD_HEIGHT; j++) {
                Square newSquare = new Square(i, j);
                newColumn.add(newSquare);
            }
            field.add(newColumn);
        }

        //add mines to specified percentage of squares
        int x, y;
        int numOfMines = FIELD_HEIGHT * FIELD_WIDTH * percentMined / 100;
        for (int k = 0; k < numOfMines; k++) {
            x = (int)(Math.random() * FIELD_WIDTH);
            y = (int)(Math.random() * FIELD_HEIGHT);
            if (hasMine(x, y) || (x == 0 && y == 0) || (x == FIELD_WIDTH && y == FIELD_HEIGHT)) {
                k--;
            } else {
                field.get(x).get(y).addMine();
                //increment number of surroundingMines for neighboring squares
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if (i != x && j != y) {
                            try {
                                field.get(i).get(j).surroundingMines++;
                            } catch (NullPointerException e) {
                                //do nothing if the square doesn't exist
                            }
                        }
                    }
                }
            }
        }

        //add player to initial location
        currentPosition = field.get(0).get(0);
        currentPosition.visit();
    }

    //hopefully, this function is unnecessary
    public ArrayList<ArrayList<Square>> getField() {
        return field;
    }

    //returns whether square at x, y has a mine
    public Boolean hasMine(int x, int y) {
        return field.get(x).get(y).mined;
    }

    //returns whether square at x, y has been visited
    public Boolean wasVisited(int x, int y) {
        return field.get(x).get(y).visited;
    }

    //returns number of mines surrounding square at x, y
    public int getSurroundingMines(int x, int y) {
        return field.get(x).get(y).surroundingMines;
    }

    public void moveN() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX(), currentPosition.getY() - 1);
        }
    }
    public void moveS() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX(), currentPosition.getY() + 1);
        }
    }
    public void moveE() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX() + 1, currentPosition.getY());
        }
    }
    public void moveW() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX() - 1, currentPosition.getY());
        }
    }
    public void moveNE() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX() + 1, currentPosition.getY() - 1);
        }
    }
    public void moveNW() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX() - 1, currentPosition.getY() - 1);
        }
    }
    public void moveSE() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX() + 1, currentPosition.getY() + 1);
        }
    }
    public void moveSW() {
        if (gameOver) {
            Utilities.inform("The game has ended. Please start a new game.");
        } else {
            changePosition(currentPosition.getX() - 1, currentPosition.getY() + 1);
        }
    }

    public void changePosition(int newX, int newY) {
        if (newX < 0 || newX >= FIELD_WIDTH || newY < 0 || newY >= FIELD_HEIGHT) {
            Utilities.inform("You cannot move in that direction. Please choose a different direction.");
        } else {
            currentPosition.setX(newX);
            currentPosition.setY(newY);
            currentPosition.visit();
            if (currentPosition.getX() == FIELD_WIDTH - 1 && currentPosition.getY() == FIELD_HEIGHT - 1) {
                //game won
                gameOver = true;
            } else if (currentPosition.mined) {
                //game lost
                gameOver = true;
            }
            changed();
        }
    }

    private class Square {
        private int x;
        private int y;
        private Boolean mined;
        private Boolean visited;
        public int surroundingMines;

        Square(int x, int y) {
            this.x = x;
            this.y = y;
            mined = false;
            visited = false;
            surroundingMines = 0;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void addMine() {
            mined = true;
        }

        public void visit() {
            visited = true;
        }

//        public Boolean isMined() {
//            return mined;
//        }

//        public Boolean wasVisited() {
//            return visited;
//        }


    }
}
