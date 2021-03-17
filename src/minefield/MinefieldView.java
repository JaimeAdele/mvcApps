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
        Minefield model1 = (Minefield)model;//each reference to model in this function should be model1 (maybe a more specific name? there aren't multiple models)--it's the one that has a type of Minefield, whereas model is only known to be a generic Model  -JZ

        //new background
        gc.setColor(Color.DARK_GRAY);
        gc.fillRect(125,0, 125, 250);

        //drawing squares

        for(int i = 0; i<model.FIELD_WIDTH; i++)
        {
            for(int j=0; j<model.FIELD_HEIGHT; j++)
            {
                if(model.Square.wasVisited())//due to the changes I made in the Minefield model, this condition should check if (model.wasVisited(i, j))  -JZ
                {
                    gc.setColor(Color.BLACK);
                    String mines = String.valueOf(model.Square.surroundingMines);
                    JLabel label = new JLabel(mines);//this label isn't added to any panel, so it won't show up. There is a method to simply draw text rather than adding a label: gc.drawString(mines); -- I think that should work well without needing to deal with panels at all  -JZ
                    gc.setColor(Color.WHITE);
                }
                else if(model.Square.getX()==model.FIELD_WIDTH && model.Square.getY()==model.FIELD_HEIGHT)//this conditional just needs to know if i == model.FIELD_WIDTH and j == FIELD_HEIGHT  -JZ
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
                gc.drawRect(model.getX(),model.getY(),SIZE,SIZE);//this method needs the actual pixel position that the rectangle starts at--the getX()/getY() methods give the relative position of the squares in the grid. You'll simply want to multiply each by SIZE to get it to its proper starting place  -JZ
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
