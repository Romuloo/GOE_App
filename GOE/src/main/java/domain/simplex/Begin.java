package domain.simplex;

import domain.simplex.programLoop.firstStep.FirstSimplex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Begin {

    private static JFrame f = new JFrame("INDEX");
    private static JButton b1 = new JButton("Simplex");
    private static JButton b2 = new JButton("Dual");

    private static FirstSimplex fs;

    private static void initComponents(){
        f.add(b1);
        f.add(b2);
        b1.setBounds(10, 50, 90, 50);
        b2.setBounds(110, 50, 90, 50);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fs = new FirstSimplex();
            }
        });

    }

    public static FirstSimplex getFirstSimplexInstance(){
        return fs;
    }

    public static void init(){

        f.setBackground(new Color(39, 156, 207));
        f.setSize(210,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocation(200, 200);
        f.setResizable(false);
        initComponents();

    }

}
