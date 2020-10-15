
import domain.simplex.programLoop.recurring.MatrixCalculator;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;


public class MatrixCalculatorTest {


    private HashMap<String, ArrayList<Double>> vs = new HashMap();

    private ArrayList<Double> x5s = new ArrayList();
    private ArrayList<Double> x6s = new ArrayList();
    private ArrayList<Double> x7s = new ArrayList();

    private double[][] solucion1 = new double[3][3];
    private double[][] solucion = new double[3][3];



    private boolean checker(HashMap<String, ArrayList<Double>> sol, double[][] solucion){

        boolean equal1 = true, equal2 = true, equal3 = true;
        ArrayList<Double> a1 = sol.get("x5");
        ArrayList<Double> a2 = sol.get("x6");
        ArrayList<Double> a3 = sol.get("x7");

        for(int i = 0; i < 3; i++)
            equal1 = (a1.get(i) == solucion[0][i]) && equal1;
        for(int i = 0; i < 3; i++)
            equal2 = (a2.get(i) == solucion[1][i]) && equal2;
        for(int i = 0; i < 3; i++)
            equal3 = (a3.get(i) == solucion[2][i]) && equal3;

        return equal1 && equal2 && equal3;
    }

    @Before
    public void setUp(){

        x5s.add(0.0);
        x5s.add(1.0);
        x5s.add(2.0);
        x5s.add(3.0);
        x5s.add(0.0);
        x5s.add(0.0);
        vs.put("x5", x5s);

        x6s.add(0.0);
        x6s.add(1.0);
        x6s.add(1.0);
        x6s.add(1.0);
        x6s.add(0.0);
        x6s.add(0.0);
        vs.put("x6", x6s);


        x7s.add(0.0);
        x7s.add(4.0);
        x7s.add(0.0);
        x7s.add(4.0);
        x7s.add(0.0);
        x7s.add(0.0);
        vs.put("x7", x7s);


        solucion1[0][0] = 1.0;
        solucion1[0][1] = 2.0;
        solucion1[0][2] = 3.0;

        solucion1[1][0] = 1.0;
        solucion1[1][1] = 1.0;
        solucion1[1][2] = 1.0;

        solucion1[2][0] = 4.0;
        solucion1[2][1] = 0.0;
        solucion1[2][2] = 4.0;

        solucion[0][0] = -0.5;
        solucion[0][1] = 1.0;
        solucion[0][2] = 0.125;

        solucion[1][0] = -0.0;
        solucion[1][1] = 1.0;
        solucion[1][2] = 0.25;

        solucion[2][0] = 0.5;
        solucion[2][1] = -1.0;
        solucion[2][2] = 0.125;



    }

    @Test
    public void testMatrizCorrecta(){
      /*  for(Double d : MatrixCalculator.getMatrixInversa(vs, "x5", "x6", "x7").get("x5"))
         //   System.out.println(d);
        for(Double d : MatrixCalculator.getMatrixInversa(vs, "x5", "x6", "x7").get("x6"))
        //    System.out.println(d);
        for(Double d : MatrixCalculator.getMatrixInversa(vs, "x5", "x6", "x7").get("x7"))
           // System.out.println(d);*/
        double[][] m = MatrixCalculator.invert(solucion1);
        for(int i= 0; i <3; i++)
            for(int j = 0; j < 3; j++)
                System.out.println(m[i][j] + " Esta " + i);

        //assertTrue(checker(MatrixCalculator.getMatrixInversa(vs, "x5", "x6", "x7"), solucion));

    }
}
