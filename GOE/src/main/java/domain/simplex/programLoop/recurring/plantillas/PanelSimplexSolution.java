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
package domain.simplex.programLoop.recurring.plantillas;

import javax.swing.*;
import java.awt.*;

/**
 * @author Javier Linares Castrillón
 */

/**
 * Clase encargada de definir un JPanel donde se plasmará una iteración del Simplex.
 */
public class PanelSimplexSolution extends JPanel {

    private  Font f= new Font("Arial", Font.BOLD, 18);
    //cj: procesos, x = valores matriz, c =  matriz ampliada, v = valores solución óptima, m = matriz inversa
    private JTextField cj1 = new JTextField(), cj2 = new JTextField(), cj3 = new JTextField(), cj4 = new JTextField(), cj5 = new JTextField(),
            cj6 = new JTextField(), cj7 = new JTextField(), cj8 = new JTextField(), cj9 = new JTextField(), cj10 = new JTextField(), v1 = new JTextField(),
            v2 = new JTextField(), v3 = new JTextField(), c1 = new JTextField(), c2 = new JTextField(), c3 = new JTextField(), x11 = new JTextField(),
            x12 = new JTextField(), x13 = new JTextField(), x21 = new JTextField(), x22 = new JTextField(), x23 = new JTextField(),
            x31 = new JTextField(), x32 = new JTextField(), x33 = new JTextField(), x41 = new JTextField(), x42 = new JTextField(), x43 = new JTextField(),
            x51 = new JTextField(), x52 = new JTextField(), x53 = new JTextField(), x61 = new JTextField(), x62 = new JTextField(), x63 = new JTextField(),
            x71 = new JTextField(), x72 = new JTextField(), x73 = new JTextField(), zj1 = new JTextField(), zj2 = new JTextField(), zj3 = new JTextField(),
            zj4 = new JTextField(), zj5 = new JTextField(), zj6 = new JTextField(), zj7 = new JTextField(), wj1 = new JTextField(),
            wj2 = new JTextField(), wj3 = new JTextField(), wj4 = new JTextField(), wj5 = new JTextField(), wj6 = new JTextField(), wj7 = new JTextField(),
            sol = new JTextField(), ent = new JTextField(), sal = new JTextField();

    /**
     * Constructor de la clase PanelSimplexSolution.
     */
    public PanelSimplexSolution(){
        setLayout(null);
        initComponents();
    }
    private void initComponents(){

        add(cj1); add(cj2); add(cj3); add(cj4); add(cj5); add(cj6); add(cj7); add(cj8); add(cj9); add(cj10); add(v1); add(v2); add(v3);
        add(c1); add(c2); add(c3); add(x11); add(x12); add(x13); add(x21); add(x22); add(x23); add(x31); add(x32); add(x33); add(x41);
        add(x42); add(x43); add(x51); add(x52); add(x53); add(x61); add(x62); add(x63); add(x71); add(x72); add(x73); add(zj1); add(zj2);
        add(zj3); add(zj4); add(zj5); add(zj6); add(zj7); add(wj1); add(wj2); add(wj3); add(wj4); add(wj5); add(wj6); add(wj7); add(sol); add(ent); add(sal);
        initFields();
    }

    public void paint(Graphics grafico) {
        ImageIcon Img = new ImageIcon("GOE/src/main/res/imagen.png");
        grafico.drawImage(Img.getImage(), 0, 0, 1162,1298/2, null);
        setOpaque(false);
        super.paint(grafico);

    }

    private void initFields(){

        cj1.setBounds(276+6, 20, 94, 50);
        cj1.setBorder(null);
        cj1.setOpaque(false);
        cj1.setText("0");
        cj1.setFont(f);
        cj2.setBounds(276+95+6, 20, 94, 50);
        cj2.setBorder(null);
        cj2.setOpaque(false);
        cj2.setText("0");
        cj2.setFont(f);
        cj3.setBounds(276+190+6, 20, 94, 50);
        cj3.setBorder(null);
        cj3.setOpaque(false);
        cj3.setText("0");
        cj3.setFont(f);
        cj4.setBounds(276+285+6, 20, 94, 50);
        cj4.setBorder(null);
        cj4.setOpaque(false);
        cj4.setText("0");
        cj4.setFont(f);
        cj5.setBounds(276 + 377+6, 20, 94, 50);
        cj5.setBorder(null);
        cj5.setOpaque(false);
        cj5.setText("0");
        cj5.setFont(f);
        cj6.setBounds(276 + 470+6, 20, 94, 50);
        cj6.setBorder(null);
        cj6.setOpaque(false);
        cj6.setText("0");
        cj6.setFont(f);
        cj7.setBounds(275 + 565, 20, 94, 50);
        cj7.setBorder(null);
        cj7.setOpaque(false);
        cj7.setText("0");
        cj7.setFont(f);

        cj8.setBounds(2+6, 210, 94, 50);
        cj8.setBorder(null);
        cj8.setOpaque(false);
        cj8.setText("0");
        cj8.setFont(f);
        cj9.setBounds(2+6, 300, 94, 50);
        cj9.setBorder(null);
        cj9.setOpaque(false);
        cj9.setText("0");
        cj9.setFont(f);
        cj10.setBounds(2+6, 390, 94, 50);
        cj10.setBorder(null);
        cj10.setOpaque(false);
        cj10.setText("0");
        cj10.setFont(f);

        v1.setBounds(140, 210, 94, 50);
        v1.setBorder(null);
        v1.setOpaque(false);
        v1.setText("x5");
        v1.setFont(f);
        v2.setBounds(140, 300, 94, 50);
        v2.setBorder(null);
        v2.setOpaque(false);
        v2.setText("x6");
        v2.setFont(f);
        v3.setBounds(140, 390, 94, 50);
        v3.setBorder(null);
        v3.setOpaque(false);
        v3.setText("x7");
        v3.setFont(f);

        x11.setBounds(276+6, 210, 94, 50);
        x11.setBorder(null);
        x11.setOpaque(false);
        x11.setText("0");
        x11.setFont(f);
        x12.setBounds(276+6, 300, 94, 50);
        x12.setBorder(null);
        x12.setOpaque(false);
        x12.setText("0");
        x12.setFont(f);
        x13.setBounds(276+6, 390, 94, 50);
        x13.setBorder(null);
        x13.setOpaque(false);
        x13.setText("0");
        x13.setFont(f);

        x21.setBounds(276+95+6, 210, 94, 50);
        x21.setBorder(null);
        x21.setOpaque(false);
        x21.setText("0");
        x21.setFont(f);
        x22.setBounds(276+95+6, 300, 94, 50);
        x22.setBorder(null);
        x22.setOpaque(false);
        x22.setText("0");
        x22.setFont(f);
        x23.setBounds(276+95+6, 390, 94, 50);
        x23.setBorder(null);
        x23.setOpaque(false);
        x23.setText("0");
        x23.setFont(f);

        x31.setBounds(276+190+6, 210, 94, 50);
        x31.setBorder(null);
        x31.setOpaque(false);
        x31.setText("0");
        x31.setFont(f);
        x32.setBounds(276+190+6, 300, 94, 50);
        x32.setBorder(null);
        x32.setOpaque(false);
        x32.setText("0");
        x32.setFont(f);
        x33.setBounds(276+190+6, 390, 94, 50);
        x33.setBorder(null);
        x33.setOpaque(false);
        x33.setText("0");
        x33.setFont(f);

        x41.setBounds(276+285+6, 210, 94, 50);
        x41.setBorder(null);
        x41.setOpaque(false);
        x41.setText("0");
        x41.setFont(f);
        x42.setBounds(276+285+6, 300, 94, 50);
        x42.setBorder(null);
        x42.setOpaque(false);
        x42.setText("0");
        x42.setFont(f);
        x43.setBounds(276+285+6, 390, 94, 50);
        x43.setBorder(null);
        x43.setOpaque(false);
        x43.setText("0");
        x43.setFont(f);

        x51.setBounds(276 + 377+6, 210, 94, 50);
        x51.setBorder(null);
        x51.setOpaque(false);
        x51.setText("0");
        x51.setFont(f);
        x52.setBounds(276 + 377+6, 300, 94, 50);
        x52.setBorder(null);
        x52.setOpaque(false);
        x52.setText("0");
        x52.setFont(f);
        x53.setBounds(276 + 377+6, 390, 94, 50);
        x53.setBorder(null);
        x53.setOpaque(false);
        x53.setText("0");
        x53.setFont(f);

        x61.setBounds(276 + 470+6, 210, 94, 50);
        x61.setBorder(null);
        x61.setOpaque(false);
        x61.setText("0");
        x61.setFont(f);
        x62.setBounds(276 + 470+6, 300, 94, 50);
        x62.setBorder(null);
        x62.setOpaque(false);
        x62.setText("0");
        x62.setFont(f);
        x63.setBounds(276 + 470+6, 390, 94, 50);
        x63.setBorder(null);
        x63.setOpaque(false);
        x63.setText("0");
        x63.setFont(f);

        x71.setBounds(275 + 565+6, 210, 94, 50);
        x71.setBorder(null);
        x71.setOpaque(false);
        x71.setText("0");
        x71.setFont(f);
        x72.setBounds(275 + 565+6, 300, 94, 50);
        x72.setBorder(null);
        x72.setOpaque(false);
        x72.setText("0");
        x72.setFont(f);
        x73.setBounds(275 + 565+6, 390, 94, 50);
        x73.setBorder(null);
        x73.setOpaque(false);
        x73.setText("0");
        x73.setFont(f);

        c1.setBounds(276 + 670+6, 210, 94, 50);
        c1.setBorder(null);
        c1.setOpaque(false);
        c1.setText("0");
        c1.setFont(f);
        c2.setBounds(276 + 670+6, 300, 94, 50);
        c2.setBorder(null);
        c2.setOpaque(false);
        c2.setText("0");
        c2.setFont(f);
        c3.setBounds(276 + 670+6, 390, 94, 50);
        c3.setBorder(null);
        c3.setOpaque(false);
        c3.setText("0");
        c3.setFont(f);

        zj1.setBounds(276+6, 480, 94, 50);
        zj1.setBorder(null);
        zj1.setOpaque(false);
        zj1.setText("0");
        zj1.setFont(f);
        zj2.setBounds(276+95+6,  480, 94, 50);
        zj2.setBorder(null);
        zj2.setOpaque(false);
        zj2.setText("0");
        zj2.setFont(f);
        zj3.setBounds(276+190+6, 480, 94, 50);
        zj3.setBorder(null);
        zj3.setOpaque(false);
        zj3.setText("0");
        zj3.setFont(f);
        zj4.setBounds(276+285+6, 480, 94, 50);
        zj4.setBorder(null);
        zj4.setOpaque(false);
        zj4.setText("0");
        zj4.setFont(f);
        zj5.setBounds(276 + 377+6, 480, 94, 50);
        zj5.setBorder(null);
        zj5.setOpaque(false);
        zj5.setText("0");
        zj5.setFont(f);
        zj6.setBounds(276 + 470+6, 480, 94, 50);
        zj6.setBorder(null);
        zj6.setOpaque(false);
        zj6.setText("0");
        zj6.setFont(f);
        zj7.setBounds(275 + 565+6, 480, 94, 50);
        zj7.setBorder(null);
        zj7.setOpaque(false);
        zj7.setText("0");
        zj7.setFont(f);

        wj1.setBounds(276+6, 570, 94,50);
        wj1.setBorder(null);
        wj1.setOpaque(false);
        wj1.setText("0");
        wj1.setFont(f);
        wj2.setBounds(276+95+6, 570, 94, 50);
        wj2.setBorder(null);
        wj2.setOpaque(false);
        wj2.setText("0");
        wj2.setFont(f);
        wj3.setBounds(276+190+6, 570, 94, 50);
        wj3.setBorder(null);
        wj3.setOpaque(false);
        wj3.setText("0");
        wj3.setFont(f);
        wj4.setBounds(276+285+6, 570, 94, 50);
        wj4.setBorder(null);
        wj4.setOpaque(false);
        wj4.setText("0");
        wj4.setFont(f);
        wj5.setBounds(276 + 377+6, 570, 94, 50);
        wj5.setBorder(null);
        wj5.setOpaque(false);
        wj5.setText("0");
        wj5.setFont(f);
        wj6.setBounds(276 + 470+6, 570, 94, 50);
        wj6.setBorder(null);
        wj6.setOpaque(false);
        wj6.setText("0");
        wj6.setFont(f);
        wj7.setBounds(275 + 565+6, 570, 94, 50);
        wj7.setBorder(null);
        wj7.setOpaque(false);
        wj7.setText("0");
        wj7.setFont(f);

        sol.setBounds(1040+6, 590, 100,50);
        sol.setBorder(null);
        sol.setOpaque(false);
        ent.setBounds(1040+6, 470, 100, 50);
        ent.setBorder(null);
        ent.setOpaque(false);
        sal.setBounds(1040+6, 530, 100, 50);
        sal.setBorder(null);
        sal.setOpaque(false);

        sol.setFont(f);
        ent.setFont(f);
        sal.setFont(f);
    }

    public JTextField getCj1() {
        return cj1;
    }

    public JTextField getCj2() {
        return cj2;
    }

    public JTextField getCj3() {
        return cj3;
    }

    public JTextField getCj4() {
        return cj4;
    }

    public JTextField getCj5() {
        return cj5;
    }

    public JTextField getCj6() {
        return cj6;
    }

    public JTextField getCj7() {
        return cj7;
    }

    public JTextField getCj8() {
        return cj8;
    }

    public JTextField getCj9() {
        return cj9;
    }

    public JTextField getCj10() {
        return cj10;
    }

    public JTextField getV1() {
        return v1;
    }

    public JTextField getV2() {
        return v2;
    }

    public JTextField getV3() {
        return v3;
    }

    public JTextField getC1() {
        return c1;
    }

    public JTextField getC2() {
        return c2;
    }

    public JTextField getC3() {
        return c3;
    }

    public JTextField getX11() {
        return x11;
    }

    public JTextField getX12() {
        return x12;
    }

    public JTextField getX13() {
        return x13;
    }

    public JTextField getX21() {
        return x21;
    }

    public JTextField getX22() {
        return x22;
    }

    public JTextField getX23() {
        return x23;
    }

    public JTextField getX31() {
        return x31;
    }

    public JTextField getX32() {
        return x32;
    }

    public JTextField getX33() {
        return x33;
    }

    public JTextField getX41() {
        return x41;
    }

    public JTextField getX42() {
        return x42;
    }

    public JTextField getX43() {
        return x43;
    }

    public JTextField getX51() {
        return x51;
    }

    public JTextField getX52() {
        return x52;
    }

    public JTextField getX53() {
        return x53;
    }

    public JTextField getX61() {
        return x61;
    }

    public JTextField getX62() {
        return x62;
    }

    public JTextField getX63() {
        return x63;
    }

    public JTextField getX71() {
        return x71;
    }

    public JTextField getX72() {
        return x72;
    }

    public JTextField getX73() {
        return x73;
    }

    public JTextField getZj1() {
        return zj1;
    }

    public JTextField getZj2() {
        return zj2;
    }

    public JTextField getZj3() {
        return zj3;
    }

    public JTextField getZj4() {
        return zj4;
    }

    public JTextField getZj5() {
        return zj5;
    }

    public JTextField getZj6() {
        return zj6;
    }

    public JTextField getZj7() {
        return zj7;
    }

    public JTextField getWj1() {
        return wj1;
    }

    public JTextField getWj2() {
        return wj2;
    }

    public JTextField getWj3() {
        return wj3;
    }

    public JTextField getWj4() {
        return wj4;
    }

    public JTextField getWj5() {
        return wj5;
    }

    public JTextField getWj6() {
        return wj6;
    }

    public JTextField getWj7() {
        return wj7;
    }

    public JTextField getSol() {
        return sol;
    }

    public JTextField getEnt() {
        return ent;
    }

    public JTextField getSal() {
        return sal;
    }


}
