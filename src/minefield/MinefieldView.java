package minefield;

import mvc.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MinefieldView extends View {

    public static final int SIZE = 10;
    Minefield model1 = (Minefield)model;
    public MinefieldView(Minefield theModel)
    {
        super(theModel);
        setLayout(new GridLayout(model1.FIELD_WIDTH, model1.FIELD_HEIGHT));
    }

    //public void paintComponent(Graphics gc) {
     //   super.paintComponent(gc);

    public void propertyChange(PropertyChangeEvent event)
    {
        Minefield model1 = (Minefield)model;
        JLabel label = new JLabel("?");
      //  label.setPreferredSize(new Dimension(SIZE, SIZE));
        Border greenLine =  BorderFactory.createLineBorder(Color.GREEN);
        Border blackLine =  BorderFactory.createLineBorder(Color.BLACK);
        Border whiteLine =  BorderFactory.createLineBorder(Color.WHITE);
        //drawing squares

        for(int i = 0; i<model1.FIELD_WIDTH; i++)
        {
            for(int j=0; j<model1.FIELD_HEIGHT; j++)
            {
                if(model1.wasVisited(i,j))
                {
                    setBackground(Color.gray);
                    setBorder(whiteLine);
                    String mines = String.valueOf(model1.getSurroundingMines(i,j));
                    label = new JLabel(mines);
                    this.add(label);
                }
                else if(model1.isGoal(i,j))
                {
                    setBackground(Color.DARK_GRAY);
                    setBorder(greenLine);
                    label = new JLabel("X");
                    this.add(label);
                }
                else
                {
                    setBackground(Color.DARK_GRAY);
                    setBorder(blackLine);
                }
            }
        }

    }
}



