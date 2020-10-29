package domain.simplex.programLoop.firstStep;

import domain.simplex.programLoop.SimplexManager;
import domain.simplex.programLoop.recurring.plantillas.IProceso;
import domain.simplex.programLoop.recurring.plantillas.ProcesoVertical;
import domain.simplex.programLoop.recurring.plantillas.ProcesoHorizontal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * @author Javier Linares Castrillón
 */

/**
 * Clase encargada de anotar los datos de la primera iteracioon del Algoritmo Simpelx.
 */
public class FirstSimplex extends JFrame {
    //cj: procesos, x = valores matriz, c =  matriz ampliada, v = valores solución óptima.
    private static final JTextField cj1 = new JTextField(), cj2 = new JTextField(), cj3 = new JTextField(), cj4 = new JTextField(), cj5 = new JTextField(),
            cj6 = new JTextField(), cj7 = new JTextField(), cj8 = new JTextField(), cj9 = new JTextField(), cj10 = new JTextField(), v1 = new JTextField(),
            v2 = new JTextField(), v3 = new JTextField(), c1 = new JTextField(), c2 = new JTextField(), c3 = new JTextField(), x11 = new JTextField(),
            x12 = new JTextField(), x13 = new JTextField(), x21 = new JTextField(), x22 = new JTextField(), x23 = new JTextField(),
            x31 = new JTextField(), x32 = new JTextField(), x33 = new JTextField(), x41 = new JTextField(), x42 = new JTextField(), x43 = new JTextField(),
            x51 = new JTextField(), x52 = new JTextField(), x53 = new JTextField(), x61 = new JTextField(), x62 = new JTextField(), x63 = new JTextField(),
            x71 = new JTextField(), x72 = new JTextField(), x73 = new JTextField(), zj1 = new JTextField(), zj2 = new JTextField(), zj3 = new JTextField(),
            zj4 = new JTextField(), zj5 = new JTextField(), zj6 = new JTextField(), zj7 = new JTextField(), wj1 = new JTextField(),
            wj2 = new JTextField(), wj3 = new JTextField(), wj4 = new JTextField(), wj5 = new JTextField(), wj6 = new JTextField(), wj7 = new JTextField();

    private static IProceso x1,  x2, x3, x4, x5, x6, x7, cjVertical, cantidades, hx1, hx2, hx3, zj, wj;

    private JButton bt = new JButton("Resolver");
    private ImageIcon ic = new ImageIcon("GOE/src/main/res/iconoResolver.png");


    private static HashMap<String, ArrayList<Double>> valoresStack;
    private static ArrayList<String> procesos;



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

    public static IProceso[][] matrizProcesos(){
        IProceso[][] matriz = new IProceso[2][9];
        initProcesos();
        matriz[0][0] = x1;
        matriz[0][1] = x2;
        matriz[0][2] = x3;
        matriz[0][3] = x4;
        matriz[0][4] = x5;
        matriz[0][5] = x6;
        matriz[0][6] = x7;
        matriz[0][7] = cjVertical;
        matriz[0][8] = cantidades;

        matriz[1][0] = hx1;
        matriz[1][1] = hx2;
        matriz[1][2] = hx3;
        matriz[1][3] = zj;
        matriz[1][4] = wj;

        return matriz;
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


    public static void initProcesos()
    {

        //--------------- Instancio e inicializo los procesos Verticales
        x1 = new ProcesoVertical();
        x1.setNombreProceso("x1");
        x1.setCj(Double.parseDouble(cj1.getText()));
        x1.setX1(Double.parseDouble(x11.getText()));
        x1.setX2(Double.parseDouble(x12.getText()));
        x1.setX3(Double.parseDouble(x13.getText()));
        x1.setZj(Double.parseDouble(zj1.getText()));
        x1.setWj(Double.parseDouble(wj1.getText()));

        x2 = new ProcesoVertical();
        x2.setNombreProceso("x2");
        x2.setCj(Double.parseDouble(cj2.getText()));
        x2.setX1(Double.parseDouble(x21.getText()));
        x2.setX2(Double.parseDouble(x22.getText()));
        x2.setX3(Double.parseDouble(x23.getText()));
        x2.setZj(Double.parseDouble(zj2.getText()));
        x2.setWj(Double.parseDouble(wj2.getText()));

        x3 = new ProcesoVertical();
        x3.setNombreProceso("x3");
        x3.setCj(Double.parseDouble(cj3.getText()));
        x3.setX1(Double.parseDouble(x31.getText()));
        x3.setX2(Double.parseDouble(x32.getText()));
        x3.setX3(Double.parseDouble(x33.getText()));
        x3.setZj(Double.parseDouble(zj3.getText()));
        x3.setWj(Double.parseDouble(wj3.getText()));

        x4 = new ProcesoVertical();
        x4.setNombreProceso("x4");
        x4.setCj(Double.parseDouble(cj4.getText()));
        x4.setX1(Double.parseDouble(x41.getText()));
        x4.setX2(Double.parseDouble(x42.getText()));
        x4.setX3(Double.parseDouble(x43.getText()));
        x4.setZj(Double.parseDouble(zj4.getText()));
        x4.setWj(Double.parseDouble(wj4.getText()));

        x5 = new ProcesoVertical();
        x5.setNombreProceso("x5");
        x5.setCj(Double.parseDouble(cj5.getText()));
        x5.setX1(Double.parseDouble(x51.getText()));
        x5.setX2(Double.parseDouble(x52.getText()));
        x5.setX3(Double.parseDouble(x53.getText()));
        x5.setZj(Double.parseDouble(zj5.getText()));
        x5.setWj(Double.parseDouble(wj5.getText()));

        x6 = new ProcesoVertical();
        x6.setNombreProceso("x6");
        x6.setCj(Double.parseDouble(cj6.getText()));
        x6.setX1(Double.parseDouble(x61.getText()));
        x6.setX2(Double.parseDouble(x62.getText()));
        x6.setX3(Double.parseDouble(x63.getText()));
        x6.setZj(Double.parseDouble(zj6.getText()));
        x6.setWj(Double.parseDouble(wj6.getText()));

        x7 = new ProcesoVertical();
        x7.setNombreProceso("x7");
        x7.setCj(Double.parseDouble(cj7.getText()));
        x7.setX1(Double.parseDouble(x71.getText()));
        x7.setX2(Double.parseDouble(x72.getText()));
        x7.setX3(Double.parseDouble(x73.getText()));
        x7.setZj(Double.parseDouble(zj7.getText()));
        x7.setWj(Double.parseDouble(wj7.getText()));

        cjVertical = new ProcesoVertical();
        cjVertical.setNombreProceso("cjVertical");
        cjVertical.setX1(Double.parseDouble(cj8.getText()));
        cjVertical.setX2(Double.parseDouble(cj9.getText()));
        cjVertical.setX3(Double.parseDouble(cj10.getText()));

        cantidades = new ProcesoVertical();
        cantidades.setNombreProceso("cantidades");
        cantidades.setX1(Double.parseDouble(c1.getText()));
        cantidades.setX2(Double.parseDouble(c2.getText()));
        cantidades.setX3(Double.parseDouble(c3.getText()));

        //------------------- Instancio e inicializo los procesos Horizontales.

        hx1 = new ProcesoHorizontal();
        hx1.setNombreProceso(v1.getText());
        hx1.setCj(Double.parseDouble(cj8.getText()));
        hx1.setX1(Double.parseDouble(x11.getText()));
        hx1.setX2(Double.parseDouble(x21.getText()));
        hx1.setX3(Double.parseDouble(x31.getText()));
        hx1.setX4(Double.parseDouble(x41.getText()));
        hx1.setX5(Double.parseDouble(x51.getText()));
        hx1.setX6(Double.parseDouble(x61.getText()));
        hx1.setX7(Double.parseDouble(x71.getText()));
        hx1.setCantidad(Double.parseDouble(c1.getText()));

        hx2 = new ProcesoHorizontal();
        hx2.setNombreProceso(v2.getText());
        hx2.setCj(Double.parseDouble(cj9.getText()));
        hx2.setX1(Double.parseDouble(x12.getText()));
        hx2.setX2(Double.parseDouble(x22.getText()));
        hx2.setX3(Double.parseDouble(x32.getText()));
        hx2.setX4(Double.parseDouble(x42.getText()));
        hx2.setX5(Double.parseDouble(x52.getText()));
        hx2.setX6(Double.parseDouble(x62.getText()));
        hx2.setX7(Double.parseDouble(x72.getText()));
        hx2.setCantidad(Double.parseDouble(c2.getText()));

        hx3 = new ProcesoHorizontal();
        hx3.setNombreProceso(v3.getText());
        hx3.setCj(Double.parseDouble(cj10.getText()));
        hx3.setX1(Double.parseDouble(x13.getText()));
        hx3.setX2(Double.parseDouble(x23.getText()));
        hx3.setX3(Double.parseDouble(x33.getText()));
        hx3.setX4(Double.parseDouble(x43.getText()));
        hx3.setX5(Double.parseDouble(x53.getText()));
        hx3.setX6(Double.parseDouble(x63.getText()));
        hx3.setX7(Double.parseDouble(x73.getText()));
        hx3.setCantidad(Double.parseDouble(c3.getText()));

        zj = new ProcesoHorizontal();
        zj.setNombreProceso("zj");
        zj.setX1(Double.parseDouble(zj1.getText()));
        zj.setX2(Double.parseDouble(zj2.getText()));
        zj.setX3(Double.parseDouble(zj3.getText()));
        zj.setX4(Double.parseDouble(zj4.getText()));
        zj.setX5(Double.parseDouble(zj5.getText()));
        zj.setX6(Double.parseDouble(zj6.getText()));
        zj.setX7(Double.parseDouble(zj7.getText()));

        wj = new ProcesoHorizontal();
        wj.setNombreProceso("wj");
        wj.setX1(Double.parseDouble(wj1.getText()));
        wj.setX2(Double.parseDouble(wj2.getText()));
        wj.setX3(Double.parseDouble(wj3.getText()));
        wj.setX4(Double.parseDouble(wj4.getText()));
        wj.setX5(Double.parseDouble(wj5.getText()));
        wj.setX6(Double.parseDouble(wj6.getText()));
        wj.setX7(Double.parseDouble(wj7.getText()));


    }

    public static HashMap<Double, String> posicionesFirst(){
        HashMap<Double, String> hm = new HashMap<>();
        hm.put(0.0, v1.getText());
        hm.put(1.0, v2.getText());
        hm.put(2.0, v3.getText());
        return hm;
    }

}
