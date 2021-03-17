package minefield;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

public class MinefieldView extends View {
    private Minefield model;
    private int width, height, rows, columns;
    public static final int SIZE = 10;

    public MinefieldView(Minefield theModel)
    {
        super(theModel);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Minefield model1 = (Minefield)model;
        //new background
        gc.setColor(Color.DARK_GRAY);
        gc.fillRect(125,0, 125, 250);

        //drawing squares

        for(int i = 0; i<model.FIELD_WIDTH; i++)
        {
            for(int j=0; j<model.FIELD_HEIGHT; j++)
            {
                if(model.Square.wasVisited())
                {
                    gc.setColor(Color.BLACK);
                    String mines = String.valueOf(model.Square.surroundingMines);
                    JLabel label = new JLabel(mines);
                    gc.setColor(Color.WHITE);
                }
                else if(model.Square.getX()==model.FIELD_WIDTH && model.Square.getY()==model.FIELD_HEIGHT)
                {
                    gc.setColor(Color.BLACK);
                    JLabel label = new JLabel("?");
                    gc.setColor(Color.GREEN);
                }
                else
                {
                    gc.setColor(Color.BLACK);
                    JLabel label = new JLabel("?");
                    gc.setColor(Color.DARK_GRAY);
                }
                gc.drawRect(model.getX(),model.getY(),SIZE,SIZE);
            }
        }


    }
}

class Cell extends JPanel
{
    int x = 0;
    int y = 0;
   // String label = "?";
    Cell(int x, int y, String label)
    {
        this.x = x;
        this.y = y;
        JLabel cellLabel = new JLabel(label);
    }

}
