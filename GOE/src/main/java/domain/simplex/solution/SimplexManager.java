package domain.simplex.solution;

import domain.simplex.FirstSimplex;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SimplexManager extends JFrame {

    private static JTabbedPane jt = new JTabbedPane();

    private HashMap<String, ArrayList<Double>>  valoresIniciales = FirstSimplex.getValoresStack();

    public SimplexManager(){

        initComponentes();
        initFrame();
        manager();
    }

    /**
     * Método encargado de realizar el algoritmo.
     */
    public void manager(){
        boolean correcto = false;


        do{
            //Con este bloque de código compruebo que los datos originales no son Sol óptima.
            ArrayList<Double> wjsIniciales =  valoresIniciales.get("wjs");
            int contadorInicial = 0;
            for(Double d : wjsIniciales)
                if (d > 0) contadorInicial++;
            if(contadorInicial != 0)  correcto = true;

            EntranteSaliente es1 = new EntranteSaliente(valoresIniciales, 0);

            System.out.println(es1.getEntrante() + " Este");
            correcto = true;




        }while(!correcto);



    }
    private void initComponentes(){
        add(jt);
        // jt.add(new PanelSimplexSolution(), 0);
    }
    private void initFrame(){
        setBackground(new Color(39, 156, 207));
        setSize(1190/2,1226/2+70);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation(100, 20);
        setResizable(false);
        setTitle("Simplex - Solucion");
    }


    /**
     * Clase encargada de resolver el simplex
     */

}