package minefield;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

class Cell
{
    JLabel label = new JLabel("?");
}
public class MineFieldView extends View {
    private MineField model;
    private int width, height, rows, columns;
    public static final int SIZE = 10;
    private boolean i<model.FIELD_WIDTH; i++;

    public MineFieldView(MineField theModel)
    {
        super(theModel);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        MineField model1 = (MineField)model;
      /*  Color oldColor = gc.getColor();
        gc.setColor(model1.getColor());
        gc.fillOval(100, 100, 20, 20);  */

        //new
        gc.setColor(Color.DARK_GRAY);
        gc.fillRect(125,0, 125, 250);

        //drawing the rows
        int rowPoints = height/rows;
        for(int i = 0; i<rows; i++)
        {
            gc.setColor(Color.WHITE);
            gc.drawLine(0, i*rowPoints,  width, i*rowPoints);
            Cell cell = new Cell();
        }
        //drawing the columns
        int columnPoints = width/columns;
        for(int i = 0; i<columns; i++)
        {
            gc.setColor(Color.WHITE);
            gc.drawLine(i*rowPoints,  0, i*rowPoints, height);
        }

        //drawing squares

        for(int i = 0; i<model.FIELD_WIDTH; i++)
        {
            for(int j=0; j<model.FIELD_HEIGHT; j++)
            {
                if(field.getX().getY().wasVisited())
                {
                    gc.setColor(Color.BLACK);
                    String mines = String.valueOf(field.getX().getY().surroundingMines);
                    JLabel label = new JLabel(mines);
                    gc.setColor(Color.WHITE);
                }
                else
                {
                    gc.setColor(Color.BLACK);
                    JLabel label = new JLabel("?");
                    gc.setColor(Color.DARK_GRAY);
                }
                gc.drawRect(x,y,SIZE,SIZE);
            }
        }


    }
}
