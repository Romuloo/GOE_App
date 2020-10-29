import domain.simplex.programLoop.SimplexManager;
import domain.simplex.programLoop.recurring.EntranteSaliente;
import domain.simplex.programLoop.recurring.plantillas.IProceso;
import domain.simplex.programLoop.recurring.plantillas.ProcesoHorizontal;
import domain.simplex.programLoop.recurring.plantillas.ProcesoVertical;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class SimplexManagerTest {

    private EntranteSaliente es;
    private IProceso x1, x2, x3, x4, x5, x6, x7, cjVertical, cantidades, hx1, hx2, hx3, zj, wj;
    private IProceso[][] matriz = new IProceso[2][9];

    private SimplexManager sm;

    @Before
    public void setUp(){

        //inicializo los valores verticales.
        x1 = new ProcesoVertical(); x2 = new ProcesoVertical(); x3 = new ProcesoVertical(); x4 = new ProcesoVertical();
        x5 = new ProcesoVertical(); x6 = new ProcesoVertical(); x7 = new ProcesoVertical(); cantidades = new ProcesoVertical();
        cjVertical = new ProcesoVertical();

        x1.setCj(40.0); x2.setCj(35.0); x3.setCj(30.0); x4.setCj(20.0); x5.setCj(0.0);
        x6.setCj(0.0); x7.setCj(0.0);
        x1.setX1(4.0); x1.setX2(2.0); x1.setX3(3.0);
        x2.setX1(2.0); x2.setX2(1.0); x2.setX3(4.0);
        x3.setX1(3.0); x3.setX2(1.0); x3.setX3(4.0);
        x4.setX1(4.0); x4.setX2(0.5); x4.setX3(2.0);
        x5.setX1(0.0); x5.setX2(0.0); x5.setX3(0.0);
        x6.setX1(0.0); x6.setX2(0.0); x6.setX3(0.0);
        x7.setX1(0.0); x7.setX2(0.0); x7.setX3(0.0);
        cjVertical.setX1(0.0); cjVertical.setX2(0.0); cjVertical.setX3(0.0);
        cantidades.setX1(1000.0); cantidades.setX2(550.0); cantidades.setX3(1700.0);
        x1.setNombreProceso("x1"); x2.setNombreProceso("x2"); x3.setNombreProceso("x3"); x4.setNombreProceso("x4");
        x5.setNombreProceso("x5"); x6.setNombreProceso("x6"); x7.setNombreProceso("x7"); cantidades.setNombreProceso("cantidades");
        cjVertical.setNombreProceso("cjVertical");

        //inicializo los valores horizontales.
        hx1 = new ProcesoHorizontal();
        hx2 = new ProcesoHorizontal();
        hx3 = new ProcesoHorizontal();
        hx1.setX1(4.0); hx1.setX2(2.0); hx1.setX3(3.0); hx1.setX4(4.0);
        hx1.setX5(1.0); hx1.setX6(0.0); hx1.setX7(0.0); hx1.setNombreProceso("x5");
        hx2.setX1(2.0); hx2.setX2(1.0); hx2.setX3(1.0); hx2.setX4(0.5);
        hx2.setX5(0.0); hx2.setX6(1.0); hx2.setX7(0.0); hx2.setNombreProceso("x6");
        hx3.setX1(3.0); hx3.setX2(4.0); hx3.setX3(4.0); hx3.setX4(2.0);
        hx3.setX5(0.0); hx3.setX6(0.0); hx3.setX7(1.0); hx3.setNombreProceso("x7");
        hx1.setCantidad(1000.0); hx2.setCantidad(550.0); hx3.setCantidad(1700.0);


        matriz[0][0] = x1; matriz[0][1] = x2; matriz[0][2] = x3; matriz[0][3] = x4;
        matriz[0][4] = x5; matriz[0][5] = x6; matriz[0][6] = x7; matriz[0][7] = cjVertical;
        matriz[0][8] = cantidades;

        matriz[1][0] = hx1;  matriz[1][1] = hx2;  matriz[1][2] = hx3;
    }

    /**
     * Utilizo este test para comprobar que la fila entrante se calcula adecuadamente.
     */
    @Test
    public void testFilaEntrante(){
        es = new EntranteSaliente(matriz, 0);
        sm = new SimplexManager();
        IProceso p = sm.calcularFilaEntrante(matriz, es.getEntrante(), es.getSaliente(es.getEntrante()));
        assertTrue(p.getNombreProceso().equals("x1") && p.getX1().equals(1.0) && p.getX2().equals(0.5) && p.getX3().equals(0.75) && p.getX4().equals(1.0)
                && p.getX5().equals(0.25) && p.getX6().equals(0.0) && p.getX7().equals(0.0) && p.getCantidad().equals(250.0));
    }


    /**
     * Este test comprueba que la fila entrante se calcula correctamente cuando el contador es 1 (segunda iteración).
     * Ojo!, se calcula en base a la primera matriz.
     */
    @Test
    public void testFilaEntranteIteracion2(){
        es = new EntranteSaliente(matriz, 1);
        sm = new SimplexManager();
        IProceso p = sm.calcularFilaEntrante(matriz, es.getEntrante(), es.getSaliente(es.getEntrante()));
        assertTrue(p.getNombreProceso().equals("x2") && p.getX1().equals(0.75) && p.getX2().equals(1.0) && p.getX3().equals(1.0) && p.getX4().equals(0.5)
             && p.getX5().equals(0.0) && p.getX6().equals(0.0) && p.getX7().equals(0.25) && p.getCantidad().equals(425.0));
    }


}
