import domain.simplex.programLoop.SimplexManager;
import domain.simplex.programLoop.recurring.EntranteSaliente;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

public class SimplexManagerTest {

    private EntranteSaliente es;

    private HashMap<String, ArrayList<Double>> vs = new HashMap();

    private ArrayList<Double> x1s = new ArrayList();
    private ArrayList<Double> x2s = new ArrayList();
    private ArrayList<Double> x3s = new ArrayList();
    private ArrayList<Double> x4s = new ArrayList();
    private ArrayList<Double> x5s = new ArrayList();
    private ArrayList<Double> x6s = new ArrayList();
    private ArrayList<Double> x7s = new ArrayList();
    private ArrayList<String> salientes = new ArrayList<>();

    private ArrayList<Double> dividendos = new ArrayList();
    private ArrayList<Double> divisores = new ArrayList();

    private SimplexManager sm = new SimplexManager();

    //Get Orden
    private HashMap<Double, String> hm = new HashMap<>();
    private String saliente = "x6";
    private String noSaliente1 = "x5";
    private String noSaliente2 = "x7";

    @Before
    public void setUp(){

        hm.put(0.0, "x5");
        hm.put(1.0, "x6");
        hm.put(2.0, "x7");



        salientes.add("x5");
        salientes.add("x6");
        salientes.add("x7");

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

        dividendos.add(40.0);
        dividendos.add(20.0);
        dividendos.add(30.0);
        vs.put("sols", dividendos);

        divisores.add(3.0);
        divisores.add(4.0);
        divisores.add(2.0);
        vs.put("divisores", divisores);


    }

    /**
     * Con este test pruevo que se haya realizado con éxito el setPosicion;
     */
    @Test
    public void testSetPosicionesCorrecto(){
     HashMap<String, Double> h = sm.setPosiciones(hm, saliente, noSaliente1, noSaliente2);
     HashMap<String, Double> myH = new HashMap<>();
     myH.put("x5", 0.0); myH.put("x6", 1.0); myH.put("x7", 2.0);

     boolean igual = true;
     igual = igual && (myH.get("x5").equals(h.get("x5")));
     igual = igual && (myH.get("x6").equals(h.get("x6")));
     igual = igual && (myH.get("x7").equals(h.get("x7")));


     assertEquals(true, igual);
     }



}
