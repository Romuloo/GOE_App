package domain.simplex;

import domain.simplex.solution.SimplexSolution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * @author Javier Linares Castrillón
 */

/**
 * Clase encargada de anotar los datos de la primera iteracioon del Algoritmo Simpelx.
 */
public class FirstSimplex extends JFrame {

    private JTextField cj1 = new JTextField(), cj2 = new JTextField(), cj3 = new JTextField(), cj4 = new JTextField(), cj5 = new JTextField(),
            cj6 = new JTextField(), cj7 = new JTextField(), cj8 = new JTextField(), cj9 = new JTextField(), cj10 = new JTextField(), v1 = new JTextField(),
            v2 = new JTextField(), v3 = new JTextField(), c1 = new JTextField(), c2 = new JTextField(), c3 = new JTextField(), x11 = new JTextField(),
            x12 = new JTextField(), x13 = new JTextField(), x21 = new JTextField(), x22 = new JTextField(), x23 = new JTextField(),
            x31 = new JTextField(), x32 = new JTextField(), x33 = new JTextField(), x41 = new JTextField(), x42 = new JTextField(), x43 = new JTextField(),
            x51 = new JTextField(), x52 = new JTextField(), x53 = new JTextField(), x61 = new JTextField(), x62 = new JTextField(), x63 = new JTextField(),
            x71 = new JTextField(), x72 = new JTextField(), x73 = new JTextField(), zj1 = new JTextField(), zj2 = new JTextField(), zj3 = new JTextField(),
            zj4 = new JTextField(), zj5 = new JTextField(), zj6 = new JTextField(), zj7 = new JTextField(), wj1 = new JTextField(),
            wj2 = new JTextField(), wj3 = new JTextField(), wj4 = new JTextField(), wj5 = new JTextField(), wj6 = new JTextField(), wj7 = new JTextField();

    private JButton bt = new JButton("Resolver");
    private ImageIcon ic = new ImageIcon("res/iconoResolver.png");

    private SimplexSolution sp;

    private HashMap<String, Double> valores;
    private HashMap<String, String> procesos;


    /**
     * Constructor de la clase. Inicializa el Frame y los componentes.
     */
    public FirstSimplex(){
        setLayout(null);
        setFrame();
        initComponents();
    }
    private SimplexSolution getInstanceSimplexSolution(){
       return (sp == null) ? sp = new SimplexSolution() : sp;
    }


    private void initComponents(){
        add(cj1); add(cj2); add(cj3); add(cj4); add(cj5); add(cj6); add(cj7); add(cj8); add(cj9); add(cj10); add(v1); add(v2); add(v3);
        add(c1); add(c2); add(c3); add(x11); add(x12); add(x13); add(x21); add(x22); add(x23); add(x31); add(x32); add(x33); add(x41);
        add(x42); add(x43); add(x51); add(x52); add(x53); add(x61); add(x62); add(x63); add(x71); add(x72); add(x73); add(zj1); add(zj2);
        add(zj3); add(zj4); add(zj5); add(zj6); add(zj7); add(wj1); add(wj2); add(wj3); add(wj4); add(wj5); add(wj6); add(wj7);

        add(bt);

        initFields();

        bt.setBounds(225+420, 260, 512/5, 512/5);
        bt.setIcon(new ImageIcon(ic.getImage().getScaledInstance(bt.getWidth(), bt.getHeight(), Image.SCALE_SMOOTH)));
        bt.setVisible(true);
        bt.setOpaque(true);
        bt.setContentAreaFilled(false);
        bt.setBorderPainted(false);
        bt.setBorder(null);

        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInstanceSimplexSolution();
            }
        });

    }

    /**
     * Metodo encargado de pintar el fondo del frame.
     * @param grafico
     */
   public void paint(Graphics grafico) {
        ImageIcon Img = new ImageIcon("res/imgFirst.png");
        grafico.drawImage(Img.getImage(), 0, 10, 1548/2,764/2, null);
    }

    private void setFrame(){
        setBackground(new Color(39, 156, 207));
        setSize(1548/2,764/2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation(200, 100);
        setResizable(false);
        setTitle("Simplex");
    }

    private void initFields(){
        cj1.setBounds(225, 0, 50, 40);
        cj1.setBackground(Color.green);
        cj1.setText("0");
        cj2.setBounds(225+55, 0, 50, 40);
        cj2.setBackground(Color.green);
        cj2.setText("0");
        cj3.setBounds(225+110, 0, 50, 40);
        cj3.setBackground(Color.green);
        cj3.setText("0");
        cj4.setBounds(225+165, 0, 50, 40);
        cj4.setBackground(Color.green);
        cj4.setText("0");
        cj5.setBounds(225+220, 0, 50, 40);
        cj5.setBackground(Color.green);
        cj5.setText("0");
        cj6.setBounds(225+275, 0, 50, 40);
        cj6.setBackground(Color.green);
        cj6.setText("0");
        cj7.setBounds(225+330, 0, 50, 40);
        cj7.setBackground(Color.green);
        cj7.setText("0");

        cj8.setBounds(5, 107, 50, 40);
        cj8.setBackground(Color.green);
        cj8.setText("0");
        cj9.setBounds(5, 160, 50, 40);
        cj9.setBackground(Color.green);
        cj9.setText("0");
        cj10.setBounds(5, 213, 50, 40);
        cj10.setBackground(Color.green);
        cj10.setText("0");

        v1.setBounds(110, 107, 50, 40);
        v1.setBackground(Color.pink);
        v1.setText("x5");
        v2.setBounds(110, 160, 50, 40);
        v2.setBackground(Color.pink);
        v2.setText("x6");
        v3.setBounds(110, 213, 50, 40);
        v3.setBackground(Color.pink);
        v3.setText("x7");

        x11.setBounds(225, 107, 50, 40);
        x11.setBackground(Color.yellow);
        x11.setText("0");
        x12.setBounds(225, 160, 50, 40);
        x12.setBackground(Color.yellow);
        x12.setText("0");
        x13.setBounds(225, 213, 50, 40);
        x13.setBackground(Color.yellow);
        x13.setText("0");

        x21.setBounds(225+55, 107, 50, 40);
        x21.setBackground(Color.yellow);
        x21.setText("0");
        x22.setBounds(225+55, 160, 50, 40);
        x22.setBackground(Color.yellow);
        x22.setText("0");
        x23.setBounds(225+55, 213, 50, 40);
        x23.setBackground(Color.yellow);
        x23.setText("0");

        x31.setBounds(225+110, 107, 50, 40);
        x31.setBackground(Color.yellow);
        x31.setText("0");
        x32.setBounds(225+110, 160, 50, 40);
        x32.setBackground(Color.yellow);
        x32.setText("0");
        x33.setBounds(225+110, 213, 50, 40);
        x33.setBackground(Color.yellow);
        x33.setText("0");

        x41.setBounds(225+165, 107, 50, 40);
        x41.setBackground(Color.yellow);
        x41.setText("0");
        x42.setBounds(225+165, 160, 50, 40);
        x42.setBackground(Color.yellow);
        x42.setText("0");
        x43.setBounds(225+165, 213, 50, 40);
        x43.setBackground(Color.yellow);
        x43.setText("0");

        x51.setBounds(225+220, 107, 50, 40);
        x51.setBackground(Color.yellow);
        x51.setText("0");
        x52.setBounds(225+220, 160, 50, 40);
        x52.setBackground(Color.yellow);
        x52.setText("0");
        x53.setBounds(225+220, 213, 50, 40);
        x53.setBackground(Color.yellow);
        x53.setText("0");

        x61.setBounds(225+275, 107, 50, 40);
        x61.setBackground(Color.yellow);
        x61.setText("0");
        x62.setBounds(225+275, 160, 50, 40);
        x62.setBackground(Color.yellow);
        x62.setText("0");
        x63.setBounds(225+275, 213, 50, 40);
        x63.setBackground(Color.yellow);
        x63.setText("0");

        x71.setBounds(225+330, 107, 50, 40);
        x71.setBackground(Color.yellow);
        x71.setText("0");
        x72.setBounds(225+330, 160, 50, 40);
        x72.setBackground(Color.yellow);
        x72.setText("0");
        x73.setBounds(225+330, 213, 50, 40);
        x73.setBackground(Color.yellow);
        x73.setText("0");

        c1.setBounds(225+330+110, 107, 50, 40);
        c1.setBackground(Color.cyan);
        c1.setText("0");
        c2.setBounds(225+330+110, 160, 50, 40);
        c2.setBackground(Color.cyan);
        c2.setText("0");
        c3.setBounds(225+330+110, 213, 50, 40);
        c3.setBackground(Color.cyan);
        c3.setText("0");

        zj1.setBounds(225, 265, 50, 40);
        zj1.setBackground(Color.lightGray);
        zj1.setText("0");
        zj2.setBounds(225+55, 265, 50, 40);
        zj2.setBackground(Color.lightGray);
        zj2.setText("0");
        zj3.setBounds(225+110, 265, 50, 40);
        zj3.setBackground(Color.lightGray);
        zj3.setText("0");
        zj4.setBounds(225+165, 265, 50, 40);
        zj4.setBackground(Color.lightGray);
        zj4.setText("0");
        zj5.setBounds(225+220, 265, 50, 40);
        zj5.setBackground(Color.lightGray);
        zj5.setText("0");
        zj6.setBounds(225+275, 265, 50, 40);
        zj6.setBackground(Color.lightGray);
        zj6.setText("0");
        zj7.setBounds(225+330, 265, 50, 40);
        zj7.setBackground(Color.lightGray);
        zj7.setText("0");

        wj1.setBounds(225, 317, 50, 40);
        wj1.setBackground(Color.orange);
        wj1.setText("0");
        wj2.setBounds(225+55, 317, 50, 40);
        wj2.setBackground(Color.orange);
        wj2.setText("0");
        wj3.setBounds(225+110, 317, 50, 40);
        wj3.setBackground(Color.orange);
        wj3.setText("0");
        wj4.setBounds(225+165, 317, 50, 40);
        wj4.setBackground(Color.orange);
        wj4.setText("0");
        wj5.setBounds(225+220, 317, 50, 40);
        wj5.setBackground(Color.orange);
        wj5.setText("0");
        wj6.setBounds(225+275, 317, 50, 40);
        wj6.setBackground(Color.orange);
        wj6.setText("0");
        wj7.setBounds(225+330, 317, 50, 40);
        wj7.setBackground(Color.orange);
        wj7.setText("0");

    }

    public HashMap<String, Double> getValores(){
       return addValores();
    }

    private HashMap<String, Double> addValores(){
        valores = new HashMap<>();

        valores.put("cj1", Double.parseDouble(cj1.getText()));
        valores.put("cj2", Double.parseDouble(cj2.getText()));
        valores.put("cj3", Double.parseDouble(cj3.getText()));
        valores.put("cj4", Double.parseDouble(cj4.getText()));
        valores.put("cj5", Double.parseDouble(cj5.getText()));
        valores.put("cj6", Double.parseDouble(cj6.getText()));
        valores.put("cj7", Double.parseDouble(cj7.getText()));
        valores.put("cj8", Double.parseDouble(cj8.getText()));
        valores.put("cj9", Double.parseDouble(cj9.getText()));
        valores.put("cj10", Double.parseDouble(cj10.getText()));

        valores.put("x11", Double.parseDouble(x11.getText()));
        valores.put("x12", Double.parseDouble(x12.getText()));
        valores.put("x13", Double.parseDouble(x13.getText()));
        valores.put("x21", Double.parseDouble(x21.getText()));
        valores.put("x22", Double.parseDouble(x22.getText()));
        valores.put("x23", Double.parseDouble(x23.getText()));
        valores.put("x31", Double.parseDouble(x31.getText()));
        valores.put("x32", Double.parseDouble(x32.getText()));
        valores.put("x33", Double.parseDouble(x33.getText()));
        valores.put("x41", Double.parseDouble(x41.getText()));
        valores.put("x42", Double.parseDouble(x42.getText()));
        valores.put("x43", Double.parseDouble(x43.getText()));
        valores.put("x51", Double.parseDouble(x51.getText()));
        valores.put("x52", Double.parseDouble(x52.getText()));
        valores.put("x53", Double.parseDouble(x53.getText()));
        valores.put("x61", Double.parseDouble(x61.getText()));
        valores.put("x62", Double.parseDouble(x62.getText()));
        valores.put("x63", Double.parseDouble(x63.getText()));
        valores.put("x71", Double.parseDouble(x71.getText()));
        valores.put("x72", Double.parseDouble(x72.getText()));
        valores.put("x73", Double.parseDouble(x73.getText()));

        valores.put("c1", Double.parseDouble(c1.getText()));
        valores.put("c2", Double.parseDouble(c2.getText()));
        valores.put("c3", Double.parseDouble(c3.getText()));

        valores.put("zj1", Double.parseDouble(zj1.getText()));
        valores.put("zj2", Double.parseDouble(zj2.getText()));
        valores.put("zj3", Double.parseDouble(zj3.getText()));
        valores.put("zj4", Double.parseDouble(zj4.getText()));
        valores.put("zj5", Double.parseDouble(zj5.getText()));
        valores.put("zj6", Double.parseDouble(zj6.getText()));
        valores.put("zj7", Double.parseDouble(zj7.getText()));

        valores.put("wj1", Double.parseDouble(wj1.getText()));
        valores.put("wj2", Double.parseDouble(wj2.getText()));
        valores.put("wj3", Double.parseDouble(wj3.getText()));
        valores.put("wj4", Double.parseDouble(wj4.getText()));
        valores.put("wj5", Double.parseDouble(wj5.getText()));
        valores.put("wj6", Double.parseDouble(wj6.getText()));
        valores.put("wj7", Double.parseDouble(wj7.getText()));

        return valores;
    }

    public HashMap<String, String> getProcesos(){
       return addProcesos();
    }

    private HashMap<String, String> addProcesos(){
       procesos = new HashMap<>();

        procesos.put("v1", v1.getText());
        procesos.put("v2", v2.getText());
        procesos.put("v3", v3.getText());
        return procesos;
    }


}
