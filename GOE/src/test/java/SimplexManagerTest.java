import domain.simplex.programLoop.SimplexManager;
import domain.simplex.programLoop.recurring.EntranteSaliente;
import domain.simplex.programLoop.recurring.procesos.IProceso;
import domain.simplex.programLoop.recurring.procesos.ProcesoHorizontal;
import domain.simplex.programLoop.recurring.procesos.ProcesoVertical;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


/**
 * Clase encargada de probar la clase SimplexManager.
 */
public class SimplexManagerTest {

    //1º
    private EntranteSaliente es;
    private IProceso x1, x2, x3, x4, x5, x6, x7, cjVertical, cantidades, hx1, hx2, hx3;
    private IProceso[][] matriz = new IProceso[2][9];
//-------------------------------------------------//
    //2º Creo esto para probar métodos más avanzados que requieren otros valores de los procesos.

    private IProceso[][] matriz_2 = new IProceso[2][9];
    private IProceso X1, X2, X3, zj; //todos horizontales.



//------------------------------------------------//
    private SimplexManager sm;

    /**
     * Este método inicializa los datos necesarios para correr los test.
     */
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
        hx1.setCj(0.0); hx2.setCj(0.0); hx3.setCj(0.0);

        matriz[0][0] = x1; matriz[0][1] = x2; matriz[0][2] = x3; matriz[0][3] = x4;
        matriz[0][4] = x5; matriz[0][5] = x6; matriz[0][6] = x7; matriz[0][7] = cjVertical;
        matriz[0][8] = cantidades;

        matriz[1][0] = hx1;  matriz[1][1] = hx2;  matriz[1][2] = hx3;

        //---------------------------------------------------------------------------//

        X1 = new ProcesoHorizontal();
        X1.setNombreProceso("x1"); X1.setX1(1.0); X1.setX2(0.0); X1.setX3(0.4); X1.setX4(1.2);
        X1.setX5(0.4); X1.setX6(0.0); X1.setX7(-0.2); X1.setCantidad(60.0); X1.setCj(40.0);

        X2 = new ProcesoHorizontal();
        X2.setNombreProceso("x6"); X2.setX1(0.0); X2.setX2(0.0); X2.setX3(-0.5); X2.setX4(-1.5);
        X2.setX5(-0.5); X2.setX6(1.0); X2.setX7(0.0); X2.setCantidad(50.0); X2.setCj(0.0);

        X3 = new ProcesoHorizontal();
        X3.setNombreProceso("x2"); X3.setX1(0.0); X3.setX2(1.0); X3.setX3(0.7); X3.setX4(-0.4);
        X3.setX5(-0.3); X3.setX6(0.0); X3.setX7(0.4); X3.setCantidad(380.0); X3.setCj(35.0);

        matriz_2[1][0] = X1;
        matriz_2[1][1] = X2;
        matriz_2[1][2] = X3;



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
                && p.getX5().equals(0.25) && p.getX6().equals(0.0) && p.getX7().equals(0.0) && p.getCantidad().equals(250.0) && p.getCj().equals(40.0));
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
             && p.getX5().equals(0.0) && p.getX6().equals(0.0) && p.getX7().equals(0.25) && p.getCantidad().equals(425.0) && p.getCj().equals(35.0));
    }

    /**
     * Este test comprueba que se calculen bien los procesos del programaBase, es decir, aquellos que no son salientes.
     */
    @Test
    public void testCalcularElementosProgramaBaseFunciona(){
        es = new EntranteSaliente(matriz, 0);
        sm = new SimplexManager();
        IProceso p = sm.calcularFilaEntrante(matriz, es.getEntrante(), es.getSaliente(es.getEntrante()));

        String noSalienteNombre_1 = es.noSalientes(es.getSaliente(es.getEntrante()))[0];
        IProceso noSaliente_1 = sm.calcularProcesoProgramaBase(p, matriz, es.getEntrante(), noSalienteNombre_1);
        boolean x6 = noSaliente_1.getNombreProceso().equals("x6") &&  noSaliente_1.getX1().equals(0.0) && noSaliente_1.getX2().equals(0.0) &&
                noSaliente_1.getX3().equals(-0.5) && noSaliente_1.getX4().equals(-1.5) && noSaliente_1.getX5().equals(-0.5) &&
                noSaliente_1.getX6().equals(1.0) && noSaliente_1.getX7().equals(0.0) && noSaliente_1.getCantidad().equals(50.0) && noSaliente_1.getCj().equals(0.0);

        String noSalienteNombre_2 = es.noSalientes(es.getSaliente(es.getEntrante()))[1];
        IProceso noSaliente_2 = sm.calcularProcesoProgramaBase(p, matriz, es.getEntrante(), noSalienteNombre_2);
        boolean x7 = noSaliente_2.getNombreProceso().equals("x7") &&  noSaliente_2.getX1().equals(0.0) && noSaliente_2.getX2().equals(2.5) &&
                noSaliente_2.getX3().equals(1.75) && noSaliente_2.getX4().equals(-1.0) && noSaliente_2.getX5().equals(-0.75) &&
                noSaliente_2.getX6().equals(0.0) && noSaliente_2.getX7().equals(1.0) && noSaliente_2.getCantidad().equals(950.0) && noSaliente_2.getCj().equals(0.0);

        assertTrue(x6 && x7);
    }


    /**
     * Utilizo este test para probar que se calcular los programas base correctamente en una iteración distinta.
     * Es decir, comprobar que el contador de iteración influye en el programa.
     */
    @Test
    public void testCalcularElementosProgramaBaseOtraIteracion(){
        es = new EntranteSaliente(matriz, 1);
        sm = new SimplexManager();
        IProceso p = sm.calcularFilaEntrante(matriz, es.getEntrante(), es.getSaliente(es.getEntrante()));
        String noSalienteNombre = es.noSalientes(es.getSaliente(es.getEntrante()))[0];
        IProceso noSaliente = sm.calcularProcesoProgramaBase(p, matriz, es.getEntrante(), noSalienteNombre);
        assertTrue(noSaliente.getNombreProceso().equals("x5") &&  noSaliente.getX1().equals(2.5) && noSaliente.getX2().equals(0.0) &&
                noSaliente.getX3().equals(1.0) && noSaliente.getX4().equals(3.0) && noSaliente.getX5().equals(1.0) &&
                noSaliente.getX6().equals(0.0) && noSaliente.getX7().equals(-0.5) && noSaliente.getCantidad().equals(150.0) && noSaliente.getCj().equals(0.0));
    }

    /**
     * Este test comprueba que el método calcularZj funciona correctamente.
     */
    @Test
    public void testCalcularZjFuncionaCorrectamente(){
        sm = new SimplexManager();
        IProceso zj = sm.calcularZj(matriz_2);

        assertTrue(zj.getNombreProceso().equals("zj") && zj.getX1().equals(40.0) && zj.getX2().equals(35.0) && zj.getX3().equals(40.5) &&
                zj.getX4().equals(34.0) && zj.getX5().equals(5.5) && zj.getX6().equals(0.0) && zj.getX7().equals(6.0));
    }

    /**
     * Mediante este test compruebo el cálculo del proceso horizontal Wj.
     */
    @Test
    public void testCalcularWjFuncionaCorrectamente(){
        sm = new SimplexManager();
        IProceso zj = sm.calcularZj(matriz_2);

        IProceso wj = sm.calcularWj(matriz, zj);

        assertTrue(wj.getNombreProceso().equals("wj") && wj.getX1().equals(0.0) && wj.getX2().equals(0.0) && wj.getX3().equals(-10.5) &&
                wj.getX4().equals(-14.0) && wj.getX5().equals(-5.5) && wj.getX6().equals(0.0) && wj.getX7().equals(-6.0));
    }



}
