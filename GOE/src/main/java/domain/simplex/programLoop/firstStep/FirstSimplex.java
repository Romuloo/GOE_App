package domain.simplex.programLoop.firstStep;

import domain.simplex.programLoop.SimplexManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Javier Linares Castrillón
 */

/**
 * Clase encargada de anotar los datos de la primera iteracioon del Algoritmo Simpelx.
 */
public class FirstSimplex extends JFrame {
    //cj: procesos, x = valores matriz, c =  matriz ampliada, v = valores solución óptima.
    private static JTextField cj1 = new JTextField(), cj2 = new JTextField(), cj3 = new JTextField(), cj4 = new JTextField(), cj5 = new JTextField(),
            cj6 = new JTextField(), cj7 = new JTextField(), cj8 = new JTextField(), cj9 = new JTextField(), cj10 = new JTextField(), v1 = new JTextField(),
            v2 = new JTextField(), v3 = new JTextField(), c1 = new JTextField(), c2 = new JTextField(), c3 = new JTextField(), x11 = new JTextField(),
            x12 = new JTextField(), x13 = new JTextField(), x21 = new JTextField(), x22 = new JTextField(), x23 = new JTextField(),
            x31 = new JTextField(), x32 = new JTextField(), x33 = new JTextField(), x41 = new JTextField(), x42 = new JTextField(), x43 = new JTextField(),
            x51 = new JTextField(), x52 = new JTextField(), x53 = new JTextField(), x61 = new JTextField(), x62 = new JTextField(), x63 = new JTextField(),
            x71 = new JTextField(), x72 = new JTextField(), x73 = new JTextField(), zj1 = new JTextField(), zj2 = new JTextField(), zj3 = new JTextField(),
            zj4 = new JTextField(), zj5 = new JTextField(), zj6 = new JTextField(), zj7 = new JTextField(), wj1 = new JTextField(),
            wj2 = new JTextField(), wj3 = new JTextField(), wj4 = new JTextField(), wj5 = new JTextField(), wj6 = new JTextField(), wj7 = new JTextField();

    private JButton bt = new JButton("Resolver");
    private ImageIcon ic = new ImageIcon("GOE/src/main/res/iconoResolver.png");


    private static HashMap<String, ArrayList<Double>> valoresStack;
    private static ArrayList<String> procesos;

    /**
     * Inicializa los valores Stack.
     * @return valores stackeados.
     */
    private HashMap<String, ArrayList<Double>> inicializarValoresStack(){
        valoresStack = stackValores();
        return valoresStack;
    }

    public static HashMap<String, ArrayList<Double>> getValoresStack(){
        return valoresStack;
    }

    public static ArrayList<String> salientesInicial(){
       return salientes();
    }
    private static ArrayList<String> salientes(){
        procesos = new ArrayList<>();
        procesos.add(v1.getText());
        procesos.add(v2.getText());
        procesos.add(v3.getText());
        return procesos;
    }


    /**
     * Constructor de la clase. Inicializa el Frame y los componentes.
     */
    public FirstSimplex(){
        setLayout(null);
        setFrame();
        initComponents();
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
            public void actionPerformed(ActionEvent e) {
                inicializarValoresStack();
                new SimplexManager();
            }
        });

    }

    /**
     * Metodo encargado de pintar el fondo del frame.
     * @param grafico
     */
    public void paint(Graphics grafico) {
        ImageIcon Img = new ImageIcon("GOE/src/main/res/imgFirst.png");
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
        cj6.setText("10");
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


    private HashMap<String, ArrayList<Double>> stackValores() {


        HashMap<String, ArrayList<Double>> vs = new HashMap();


        ArrayList<Double> x1s = new ArrayList();
        x1s.add(Double.parseDouble(cj1.getText()));
        x1s.add(Double.parseDouble(x11.getText()));
        x1s.add(Double.parseDouble(x12.getText()));
        x1s.add(Double.parseDouble(x13.getText()));
        x1s.add(Double.parseDouble(zj1.getText()));
        x1s.add(Double.parseDouble(wj1.getText()));
        vs.put("x1", x1s);

        ArrayList<Double> x2s = new ArrayList();
        x2s.add(Double.parseDouble(cj2.getText()));
        x2s.add(Double.parseDouble(x21.getText()));
        x2s.add(Double.parseDouble(x22.getText()));
        x2s.add(Double.parseDouble(x23.getText()));
        x2s.add(Double.parseDouble(zj2.getText()));
        x2s.add(Double.parseDouble(wj2.getText()));
        vs.put("x2", x2s);


        ArrayList<Double> x3s = new ArrayList();
        x3s.add(Double.parseDouble(cj3.getText()));
        x3s.add(Double.parseDouble(x31.getText()));
        x3s.add(Double.parseDouble(x32.getText()));
        x3s.add(Double.parseDouble(x33.getText()));
        x3s.add(Double.parseDouble(zj3.getText()));
        x3s.add(Double.parseDouble(wj3.getText()));
        vs.put("x3", x3s);

        ArrayList<Double> x4s = new ArrayList();
        x4s.add(Double.parseDouble(cj4.getText()));
        x4s.add(Double.parseDouble(x41.getText()));
        x4s.add(Double.parseDouble(x42.getText()));
        x4s.add(Double.parseDouble(x43.getText()));
        x4s.add(Double.parseDouble(zj4.getText()));
        x4s.add(Double.parseDouble(wj4.getText()));
        vs.put("x4", x4s);

        ArrayList<Double> x5s = new ArrayList();
        x5s.add(Double.parseDouble(cj5.getText()));
        x5s.add(Double.parseDouble(x51.getText()));
        x5s.add(Double.parseDouble(x52.getText()));
        x5s.add(Double.parseDouble(x53.getText()));
        x5s.add(Double.parseDouble(zj5.getText()));
        x5s.add(Double.parseDouble(wj5.getText()));
        vs.put("x5", x5s);

        ArrayList<Double> x6s = new ArrayList();
        x6s.add(Double.parseDouble(cj6.getText()));
        x6s.add(Double.parseDouble(x61.getText()));
        x6s.add(Double.parseDouble(x62.getText()));
        x6s.add(Double.parseDouble(x63.getText()));
        x6s.add(Double.parseDouble(zj6.getText()));
        x6s.add(Double.parseDouble(wj6.getText()));
        vs.put("x6", x6s);

        ArrayList<Double> x7s = new ArrayList();
        x7s.add(Double.parseDouble(cj7.getText()));
        x7s.add(Double.parseDouble(x71.getText()));
        x7s.add(Double.parseDouble(x72.getText()));
        x7s.add(Double.parseDouble(x73.getText()));
        x7s.add(Double.parseDouble(zj7.getText()));
        x7s.add(Double.parseDouble(wj7.getText()));
        vs.put("x7", x7s);


        ArrayList<Double> wjs = new ArrayList();
        wjs.add(Double.parseDouble(wj1.getText()));
        wjs.add(Double.parseDouble(wj2.getText()));
        wjs.add(Double.parseDouble(wj3.getText()));
        wjs.add(Double.parseDouble(wj4.getText()));
        wjs.add(Double.parseDouble(wj5.getText()));
        wjs.add(Double.parseDouble(wj6.getText()));
        vs.put("wjs", wjs);

        ArrayList<Double> sols = new ArrayList();
        sols.add(Double.parseDouble(c1.getText()));
        sols.add(Double.parseDouble(c2.getText()));
        sols.add(Double.parseDouble(c3.getText()));
        vs.put("sols", sols);

        ArrayList<Double> ladoX5 = new ArrayList();
        ladoX5.add(Double.parseDouble(cj8.getText()));
        ladoX5.add(Double.parseDouble(c1.getText()));
        vs.put("ladoX5", ladoX5);

        ArrayList<Double> ladoX6 = new ArrayList();
        ladoX6.add(Double.parseDouble(cj9.getText()));
        ladoX6.add(Double.parseDouble(c2.getText()));
        vs.put("ladoX6", ladoX6);

        ArrayList<Double> ladoX7 = new ArrayList();
        ladoX7.add(Double.parseDouble(cj10.getText()));
        ladoX7.add(Double.parseDouble(c3.getText()));
        vs.put("ladoX7", ladoX7);

        ArrayList<Double> divisores = new ArrayList();
        divisores.add(Double.parseDouble(cj8.getText()));
        divisores.add(Double.parseDouble(cj9.getText()));
        divisores.add(Double.parseDouble(cj10.getText()));
        vs.put("divisores", divisores);

        return vs;

    }


}
