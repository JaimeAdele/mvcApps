package minefield;

import mvc.*;
import java.awt.*;
import javax.swing.*;

public class MinefieldPanel extends AppPanel{
    private JButton NW;
    private JButton N;
    private JButton NE;
    private JButton W;
    private JButton E;
    private JButton SW;
    private JButton S;
    private JButton SE;
    public MinefieldPanel(AppFactory factory) {
        super(factory);

        // Add NW Button
        NW = new JButton("NW");
        NW.addActionListener(this);
        controlPanel.add(NW);

        // Add N Button
        N = new JButton("N");
        N.addActionListener(this);
        controlPanel.add(N);

        // Add NE Button
        NE = new JButton("NE");
        NE.addActionListener(this);
        controlPanel.add(NE);

        // Add W Button
        W = new JButton("W");
        W.addActionListener(this);
        controlPanel.add(W);

        // Add E Button
        E = new JButton("E");
        E.addActionListener(this);
        controlPanel.add(E);

        // Add SW Button
        SW = new JButton("SW");
        SW.addActionListener(this);
        controlPanel.add(SW);

        // Add S Button
        S = new JButton("S");
        S.addActionListener(this);
        controlPanel.add(S);

        // Add SE Button
        SE = new JButton("SE");
        SE.addActionListener(this);
        controlPanel.add(SE);
    }

    public static void main(String[] args) {
        AppFactory factory = new MinefieldFactory();
        AppPanel panel = new MinefieldPanel(factory);
        panel.display();
    }
}
