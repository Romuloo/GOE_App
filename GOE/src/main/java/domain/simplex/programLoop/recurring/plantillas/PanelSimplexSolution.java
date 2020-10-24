package domain.simplex.programLoop.recurring.plantillas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelSimplexSolution extends JPanel {



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
            m11 = new JTextField(), m12 = new JTextField(), m13 = new JTextField(), m21 = new JTextField(), m22 = new JTextField(), m23 = new JTextField(),
            m31 = new JTextField(), m32 = new JTextField(), m33 = new JTextField(), sol = new JTextField(), ent = new JTextField(), sal = new JTextField();

    public PanelSimplexSolution(){
        setLayout(null);
        initComponents();
    }
    private void initComponents(){

        add(cj1); add(cj2); add(cj3); add(cj4); add(cj5); add(cj6); add(cj7); add(cj8); add(cj9); add(cj10); add(v1); add(v2); add(v3);
        add(c1); add(c2); add(c3); add(x11); add(x12); add(x13); add(x21); add(x22); add(x23); add(x31); add(x32); add(x33); add(x41);
        add(x42); add(x43); add(x51); add(x52); add(x53); add(x61); add(x62); add(x63); add(x71); add(x72); add(x73); add(zj1); add(zj2);
        add(zj3); add(zj4); add(zj5); add(zj6); add(zj7); add(wj1); add(wj2); add(wj3); add(wj4); add(wj5); add(wj6); add(wj7);
        add(m11); add(m12); add(m13); add(m21); add(m22); add(m23); add(m31); add(m32); add(m33); add(sol); add(ent); add(sal);
        initFields();
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

    public void paint(Graphics grafico) {
        ImageIcon Img = new ImageIcon("GOE/src/main/res/imagen.png");
        grafico.drawImage(Img.getImage(), 0, 10, 1190/2,1226/2, null);
        setOpaque(false);
        super.paint(grafico);

    }

    private void initFields(){

        m11.setBounds(225+165-105, 95, 45, 40);
        m11.setBorder(null);
        m11.setOpaque(false);
        m11.setText("0");
        m12.setBounds(225+165-105, 95+37, 45, 40);
        m12.setBorder(null);
        m12.setOpaque(false);
        m12.setText("0");
        m13.setBounds(225+165-105, 95+75, 45, 40);
        m13.setBorder(null);
        m13.setOpaque(false);
        m13.setText("0");
        m21.setBounds(225+165-70, 95, 47, 40);
        m21.setBorder(null);
        m21.setOpaque(false);
        m21.setText("0");
        m22.setBounds(225+165-70, 95+37, 47, 40);
        m22.setBorder(null);
        m22.setOpaque(false);
        m22.setText("0");
        m23.setBounds(225+165-70, 95+75, 47, 40);
        m23.setBorder(null);
        m23.setOpaque(false);
        m23.setText("0");
        m31.setBounds(225+165-30, 95, 47, 40);
        m31.setBorder(null);
        m31.setOpaque(false);
        m31.setText("0");
        m32.setBounds(225+165-30, 95+37, 47, 40);
        m32.setBorder(null);
        m32.setOpaque(false);
        m32.setText("0");
        m33.setBounds(225+165-30, 95+75, 47, 40);
        m33.setBorder(null);
        m33.setOpaque(false);
        m33.setText("0");

        cj1.setBounds(225-55, 255, 47, 40);
        cj1.setBorder(null);
        cj1.setOpaque(false);
        cj1.setText("5453");
        cj2.setBounds(225+55-66, 255, 47, 40);
        cj2.setBorder(null);
        cj2.setOpaque(false);
        cj2.setText("0");
        cj3.setBounds(225+110-78, 255, 47, 40);
        cj3.setBorder(null);
        cj3.setOpaque(false);
        cj3.setText("0");
        cj4.setBounds(225+165-90, 255, 47, 40);
        cj4.setBorder(null);
        cj4.setOpaque(false);
        cj4.setText("0");
        cj5.setBounds(225+220-103, 255, 47, 40);
        cj5.setBorder(null);
        cj5.setOpaque(false);
        cj5.setText("0");
        cj6.setBounds(225+275-115, 255, 47, 40);
        cj6.setBorder(null);
        cj6.setOpaque(false);
        cj6.setText("0");
        cj7.setBounds(225+330-128, 255, 47, 40);
        cj7.setBorder(null);
        cj7.setOpaque(false);
        cj7.setText("0");

        cj8.setBounds(2, 341, 47, 40);
        cj8.setBorder(null);
        cj8.setOpaque(false);
        cj8.setText("0");
        cj9.setBounds(2, 382, 47, 40);
        cj9.setBorder(null);
        cj9.setOpaque(false);
        cj9.setText("0");
        cj10.setBounds(2, 423, 47, 40);
        cj10.setBorder(null);
        cj10.setOpaque(false);
        cj10.setText("0");

        v1.setBounds(92, 341, 47, 40);
        v1.setBorder(null);
        v1.setOpaque(false);
        v1.setText("x5");
        v2.setBounds(92, 382, 47, 40);
        v2.setBorder(null);
        v2.setOpaque(false);
        v2.setText("x6");
        v3.setBounds(92, 423, 47, 40);
        v3.setBorder(null);
        v3.setOpaque(false);
        v3.setText("x7");

        x11.setBounds(225-53, 341, 47, 40);
        x11.setBorder(null);
        x11.setOpaque(false);
        x11.setText("0");
        x12.setBounds(225-53, 382, 47, 40);
        x12.setBorder(null);
        x12.setOpaque(false);
        x12.setText("0");
        x13.setBounds(225-53, 423, 47, 40);
        x13.setBorder(null);
        x13.setOpaque(false);
        x13.setText("0");

        x21.setBounds(225+55-64, 341, 47, 40);
        x21.setBorder(null);
        x21.setOpaque(false);
        x21.setText("0");
        x22.setBounds(225+55-64, 382, 47, 40);
        x22.setBorder(null);
        x22.setOpaque(false);
        x22.setText("0");
        x23.setBounds(225+55-64, 423, 47, 40);
        x23.setBorder(null);
        x23.setOpaque(false);
        x23.setText("0");

        x31.setBounds(225+110-76, 341, 47, 40);
        x31.setBorder(null);
        x31.setOpaque(false);
        x31.setText("0");
        x32.setBounds(225+110-76, 382, 47, 40);
        x32.setBorder(null);
        x32.setOpaque(false);
        x32.setText("0");
        x33.setBounds(225+110-76, 423, 47, 40);
        x33.setBorder(null);
        x33.setOpaque(false);
        x33.setText("0");

        x41.setBounds(225+165-88, 341, 47, 40);
        x41.setBorder(null);
        x41.setOpaque(false);
        x41.setText("0");
        x42.setBounds(225+165-88, 382, 47, 40);
        x42.setBorder(null);
        x42.setOpaque(false);
        x42.setText("0");
        x43.setBounds(225+165-88, 423, 47, 40);
        x43.setBorder(null);
        x43.setOpaque(false);
        x43.setText("0");

        x51.setBounds(225+220-101, 341, 47, 40);
        x51.setBorder(null);
        x51.setOpaque(false);
        x51.setText("0");
        x52.setBounds(225+220-101, 382, 47, 40);
        x52.setBorder(null);
        x52.setOpaque(false);
        x52.setText("0");
        x53.setBounds(225+220-101, 423, 47, 40);
        x53.setBorder(null);
        x53.setOpaque(false);
        x53.setText("0");

        x61.setBounds(225+275-113, 341, 47, 40);
        x61.setBorder(null);
        x61.setOpaque(false);
        x61.setText("0");
        x62.setBounds(225+275-113, 382, 47, 40);
        x62.setBorder(null);
        x62.setOpaque(false);
        x62.setText("0");
        x63.setBounds(225+275-113, 423, 47, 40);
        x63.setBorder(null);
        x63.setOpaque(false);
        x63.setText("0");

        x71.setBounds(225+330-126, 341, 47, 40);
        x71.setBorder(null);
        x71.setOpaque(false);
        x71.setText("0");
        x72.setBounds(225+330-126, 382, 47, 40);
        x72.setBorder(null);
        x72.setOpaque(false);
        x72.setText("0");
        x73.setBounds(225+330-126, 423, 47, 40);
        x73.setBorder(null);
        x73.setOpaque(false);
        x73.setText("0");

        c1.setBounds(225+330-36, 341, 47, 40);
        c1.setBorder(null);
        c1.setOpaque(false);
        c1.setText("0");
        c2.setBounds(225+330-36, 382, 47, 40);
        c2.setBorder(null);
        c2.setOpaque(false);
        c2.setText("0");
        c3.setBounds(225+330-36, 423, 47, 40);
        c3.setBorder(null);
        c3.setOpaque(false);
        c3.setText("0");

        zj1.setBounds(225-53, 464, 47, 40);
        zj1.setBorder(null);
        zj1.setOpaque(false);
        zj1.setText("0");
        zj2.setBounds(225+55-64, 464, 47, 40);
        zj2.setBorder(null);
        zj2.setOpaque(false);
        zj2.setText("0");
        zj3.setBounds(225+110-76, 464, 47, 40);
        zj3.setBorder(null);
        zj3.setOpaque(false);
        zj3.setText("0");
        zj4.setBounds(225+165-88, 464, 47, 40);
        zj4.setBorder(null);
        zj4.setOpaque(false);
        zj4.setText("0");
        zj5.setBounds(225+220-101, 464, 47, 40);
        zj5.setBorder(null);
        zj5.setOpaque(false);
        zj5.setText("0");
        zj6.setBounds(225+275-113, 464, 47, 40);
        zj6.setBorder(null);
        zj6.setOpaque(false);
        zj6.setText("0");
        zj7.setBounds(225+330-126, 464, 47, 40);
        zj7.setBorder(null);
        zj7.setOpaque(false);
        zj7.setText("0");

        wj1.setBounds(225-53, 506, 47,40);
        wj1.setBorder(null);
        wj1.setOpaque(false);
        wj1.setText("0");
        wj2.setBounds(225+55-64, 506, 47, 40);
        wj2.setBorder(null);
        wj2.setOpaque(false);
        wj2.setText("0");
        wj3.setBounds(225+110-76, 506, 47, 40);
        wj3.setBorder(null);
        wj3.setOpaque(false);
        wj3.setText("0");
        wj4.setBounds(225+165-88, 506, 47, 40);
        wj4.setBorder(null);
        wj4.setOpaque(false);
        wj4.setText("0");
        wj5.setBounds(225+220-101, 506, 47, 40);
        wj5.setBorder(null);
        wj5.setOpaque(false);
        wj5.setText("0");
        wj6.setBounds(225+275-113, 506, 47, 40);
        wj6.setBorder(null);
        wj6.setOpaque(false);
        wj6.setText("0");
        wj7.setBounds(225+330-126, 506, 47, 40);
        wj7.setBorder(null);
        wj7.setOpaque(false);
        wj7.setText("0");

        sol.setBounds(225-110, 565, 47,40);

        ent.setBounds(225+55-72, 22, 47, 40);
        sal.setBounds(225+330-95, 22, 47, 40);
    }



}
