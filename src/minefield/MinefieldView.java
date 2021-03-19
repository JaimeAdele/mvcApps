package minefield;

import mvc.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MinefieldView extends View {

    public static final int SIZE = 10;
    Minefield model1 = (Minefield) model;

    public MinefieldView(Minefield theModel) {
        super(theModel);
        setLayout(new GridLayout(model1.FIELD_WIDTH, model1.FIELD_HEIGHT));
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
    }

    public void propertyChange(PropertyChangeEvent event) {
        Minefield model1 = (Minefield)model;
        JLabel label;
        setBackground(Color.DARK_GRAY);
        //label.setPreferredSize(new Dimension(SIZE, SIZE));
        Border greenLine =  BorderFactory.createLineBorder(Color.GREEN);
        Border blackLine =  BorderFactory.createLineBorder(Color.BLACK);
        Border whiteLine =  BorderFactory.createLineBorder(Color.WHITE);
        //drawing squares

        for(int j = 0; j < model1.FIELD_WIDTH; j++) {
            for(int i = 0; i < model1.FIELD_HEIGHT; i++) {
                if(model1.wasVisited(i,j)) {
                    setBackground();
                    setBorder(whiteLine);
                    String mines = String.valueOf(model1.getSurroundingMines(i,j));
                    label = new JLabel(mines);
                } else if(model1.isGoal(i,j)) {
                    setBorder(greenLine);
                    label = new JLabel("X");
                } else {
                    setBorder(blackLine);
                    label = new JLabel("?");
                }
                add(label);
            }
        }

    }
}



