import domain.simplex.solution.EntranteSaliente;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Clase encargada de probar la clase EntranteSaliente.
 */
public class EntranteSalienteTest {

    private EntranteSaliente es;

   HashMap<String, ArrayList<Double>> vs = new HashMap();

    private ArrayList<Double> x1s = new ArrayList();
    private ArrayList<Double> x2s = new ArrayList();
    private ArrayList<Double> x3s = new ArrayList();
    private ArrayList<Double> x4s = new ArrayList();
    private ArrayList<Double> x5s = new ArrayList();
    private ArrayList<Double> x6s = new ArrayList();
    private ArrayList<Double> x7s = new ArrayList();


    @Before
    public void setUp(){

        x1s.add(40.0);
        x1s.add(4.0);
        x1s.add(2.0);
        x1s.add(3.0);
        x1s.add(0.0);
        x1s.add(40.0);
        vs.put("x1", x1s);

        x2s.add(35.0);
        x2s.add(2.0);
        x2s.add(1.0);
        x2s.add(4.0);
        x2s.add(0.0);
        x2s.add(35.0);
        vs.put("x2", x2s);

        x3s.add(30.0);
        x3s.add(3.0);
        x3s.add(1.0);
        x3s.add(4.0);
        x3s.add(0.0);
        x3s.add(30.0);
        vs.put("x3", x3s);

        x4s.add(20.0);
        x4s.add(4.0);
        x4s.add(0.5);
        x4s.add(2.0);
        x4s.add(0.0);
        x4s.add(20.0);
        vs.put("x4", x4s);

        x5s.add(0.0);
        x5s.add(1.0);
        x5s.add(0.0);
        x5s.add(0.0);
        x5s.add(0.0);
        x5s.add(0.0);
        vs.put("x5", x5s);

        x6s.add(0.0);
        x6s.add(0.0);
        x6s.add(1.0);
        x6s.add(0.0);
        x6s.add(0.0);
        x6s.add(0.0);
        vs.put("x6", x6s);


        x7s.add(0.0);
        x7s.add(0.0);
        x7s.add(1.0);
        x7s.add(0.0);
        x7s.add(0.0);
        x7s.add(0.0);
        vs.put("x7", x7s);


    }

    @Test
    public void testEntranteCorrecto(){
        es = new EntranteSaliente(vs, 0);
        assertEquals(es.getEntrante(), "x1");
    }

    @Test
    public void testEntranteCorrectoIteracion2(){
        es = new EntranteSaliente(vs, 1);
        assertEquals(es.getEntrante(), "x2");
    }



}
