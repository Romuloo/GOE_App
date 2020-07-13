package domain.simplex.solution;

import domain.Begin;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SimplexSolution extends JFrame {

    private static JTabbedPane jt = new JTabbedPane();

    public SimplexSolution(){

        initComponentes();
        initFrame();

    }

    private HashMap<String, Double> valores(){
        return Begin.getFirstSimplexInstance().getValores();
    }
    private HashMap<String, String> procesos(){
        return Begin.getFirstSimplexInstance().getProcesos();
    }


    private void initComponentes(){
       add(jt);
       jt.add(new PanelSimplexSolution(), 0);
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



    private class SimplexSolver{
        private HashMap<String, Double> valores = new HashMap<>();
        private HashMap<String, String> procesos = new HashMap<>();

        private void getEntrante() {
            HashMap<String, Double> aux = new HashMap<>();

            String help = "";
            int cont = 1;
            for(int i = 1; i <7; i++){
                if(valores().get("cj"+i) > valores().get("cj" + ++cont)) help = ("cj" + i);
                else{
                    help = ("cj" + cont);
                }
            }

            procesos.put("ent", help);
            }

        }
}