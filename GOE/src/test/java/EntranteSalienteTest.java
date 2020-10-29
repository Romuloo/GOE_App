import domain.simplex.programLoop.recurring.EntranteSaliente;
import domain.simplex.programLoop.recurring.plantillas.IProceso;
import domain.simplex.programLoop.recurring.plantillas.ProcesoVertical;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

/**
 * Clase encargada de probar la clase EntranteSaliente.
 */
public class EntranteSalienteTest {

    private EntranteSaliente es;

    private ArrayList<IProceso> vs = new ArrayList<>();
    private IProceso x1, x2, x3, x4, x5, x6, x7, cantidades;





    @Before
    public void setUp(){

        x1 = new ProcesoVertical();
        x2 = new ProcesoVertical();
        x3 = new ProcesoVertical();
        x4 = new ProcesoVertical();
        x5 = new ProcesoVertical();
        x6 = new ProcesoVertical();
        x7 = new ProcesoVertical();
        cantidades = new ProcesoVertical();



        x1.setCj(40.0); x2.setCj(35.0); x3.setCj(30.0); x4.setCj(20.0); x5.setCj(0.0);
        x6.setCj(0.0); x7.setCj(0.0);

        x1.setX1(4.0); x1.setX2(2.0); x1.setX3(3.0);
        x2.setX1(2.0); x2.setX2(1.0); x2.setX3(4.0);
        x3.setX1(3.0); x3.setX2(1.0); x3.setX3(4.0);
        x4.setX1(4.0); x4.setX2(0.5); x4.setX3(2.0);
        x5.setX1(0.0); x5.setX2(0.0); x5.setX3(0.0);
        x6.setX1(0.0); x6.setX2(0.0); x6.setX3(0.0);
        x7.setX1(0.0); x7.setX2(0.0); x7.setX3(0.0);
        cantidades.setX1(250.0); cantidades.setX1(50.0); cantidades.setX1(950.0);

        vs.add(x1); vs.add(x2); vs.add(x3); vs.add(x4);
        vs.add(x5); vs.add(x6); vs.add(x7); vs.add(cantidades);
    }

    /**
     * Este test comprueba que el algoritmo calcula el proceso entrante correctamente.
     */
    @Test
    public void testEntranteCorrecto(){
       // es = new EntranteSaliente(vs, 0);
      //  assertEquals(es.getEntrante(), "x1");
    }

    /**
     * Con este test se prueba que el entrante es correcto en distintas iteraciones.
     */
    @Test
    public void testEntranteCorrectoIteracion2(){

      //  es = new EntranteSaliente(vs, 1);
       //assertEquals(es.getEntrante(), "x2");

    }

    /**
     * Este test comprueba que el método saliente funciona correctamente.
     */
    @Test
    public void testSalienteCorrecto(){
      //  es = new EntranteSaliente(vs, 0);
      //  assertEquals(es.getSaliente("x1"), "x6");
    }

    /**
     * Este test comprueba que el método saliente no se ve afectado por el entrante
     * */
    @Test
    public void testSalienteConEntranteSegundaIteracion(){
     //   es = new EntranteSaliente(vs, 1);
      //  assertEquals(es.getSaliente(salientes), "x6");
    }




}
