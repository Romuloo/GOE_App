package domain.simplex.solution;

import javax.swing.*;
import java.awt.*;

public class SimplexSolution extends JFrame {

    private static JTabbedPane jt = new JTabbedPane();


    public SimplexSolution(){

        initComponentes();
        initFrame();

    }

    private void initComponentes(){
       add(jt);
       jt.add(new PanelSimplexSolution(), 0);
       jt.add(new PanelSimplexSolution(), 1);
       jt.add(new PanelSimplexSolution(), 2);

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
}
