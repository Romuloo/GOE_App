package domain;

import domain.simplex.FirstSimplex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
            @Override
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


        HashMap<String, Double> aux = new HashMap<>();
        aux.put("cj1", 3.0);
        aux.put("cj2", 11.0 );
        aux.put("cj3", 4.0);
        aux.put("cj4", 1.0);
        aux.put("cj5",5.0);
        aux.put("cj6", 7.0);
        aux.put("cj7",9.0);

        String help = "";
        int cont = 1;
        for(int i = 1; i <7; i++){
            if(aux.get("cj"+i) > aux.get("cj" + ++cont)) help = ("cj" + i);
            else{
                help = ("cj" + cont);
            }
        }
        System.out.println(help);
    }

}
