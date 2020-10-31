/**
 Copyright [2020] [Javier Linares Castrillón]
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package domain.simplex;

import domain.simplex.programLoop.firstStep.FirstSimplex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Javier linares Castrillón
 */

/**
 * Clase encargada de instanciar el frame inicial.
 */
public class Begin extends JFrame{

    private static JButton b1 = new JButton("Simplex");
    private static JButton b2 = new JButton("Dual");

    private static FirstSimplex fs;

    /**
     * Constructor de la clase Begin. LLama al método init().
     */
    public Begin(){
        init();
    }


    private void initComponents(){
        add(b1);
        add(b2);
        b1.setBounds(10, 50, 90, 50);
        b2.setBounds(110, 50, 90, 50);


        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fs = new FirstSimplex();
            }
        });

    }

    /**
     * Crea la instancia de FirstSimplex.
     * @return una nueva instancia de first simplex.
     */
    public static FirstSimplex getFirstSimplexInstance(){
        return fs;
    }

    /**
     * Este método inicializa los valores del frame.
     */
    public void init(){
        setBackground(new Color(39, 156, 207));
        setSize(210,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(200, 200);
        setResizable(true);
        initComponents();

    }

}
