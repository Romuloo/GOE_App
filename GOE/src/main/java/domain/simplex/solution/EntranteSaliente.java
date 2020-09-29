package domain.simplex.solution;

import domain.simplex.FirstSimplex;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.PriorityQueue;

public class EntranteSaliente {



    private HashMap<String, ArrayList<Double>> valoresStack;
    private int contador;

    private ArrayList<Double> x1 = new ArrayList<>();
    private ArrayList<Double> x2 = new ArrayList<>();
    private ArrayList<Double> x3 = new ArrayList<>();
    private ArrayList<Double> x4 = new ArrayList<>();
    private ArrayList<Double> x5 = new ArrayList<>();
    private ArrayList<Double> x6 = new ArrayList<>();
    private ArrayList<Double> x7 = new ArrayList<>();

    private ArrayList<Double> dividendos = new ArrayList<>();
    private ArrayList<Double> divisores = new ArrayList<>();



    public EntranteSaliente(HashMap<String, ArrayList<Double>> es, int cont) {
        this.valoresStack = es;
        this.contador = cont;
    }

    /**
     * Con este código encuentro el entrante.
     *
     * @return la variable que sale del proceso simplex.
     */
    public String getEntrante() {

        double solucion = 0; //almacenará la solución de quién es más grande.
        int posicion = 0; //almacenará la dirección de memoria del elemento mayor en el ArrayList.

        x1 = valoresStack.get("x1");
        x2 = valoresStack.get("x2");
        x3 = valoresStack.get("x3");
        x4 = valoresStack.get("x4");
        x5 = valoresStack.get("x5");
        x6 = valoresStack.get("x6");
        x7 = valoresStack.get("x7");

        //Creo un ArrayList donde almaceno todos los cjs actuales ordenados.
        ArrayList<Double> cjs = new ArrayList<>();
        cjs.add(x1.get(0));
        cjs.add(x2.get(0));
        cjs.add(x3.get(0));
        cjs.add(x4.get(0));
        cjs.add(x5.get(0));
        cjs.add(x6.get(0));
        cjs.add(x7.get(0));

        //Creo una priorityQueue donde encontrar el máximo dependiendo de la iteración del simplex.
        PriorityQueue<Double> values = new PriorityQueue<>();
        values.add(x1.get(0));
        values.add(x2.get(0));
        values.add(x3.get(0));
        values.add(x4.get(0));
        values.add(x5.get(0));
        values.add(x6.get(0));
        values.add(x7.get(0));

        for (int i = 0; i < 7 - contador; i++)
            solucion = values.remove();
        System.out.println(solucion);

        for (int i = 0; i < 7; i++)
            if (solucion == cjs.get(i))
                posicion = i + 1;
        System.out.println(posicion);

        String solucionFinal = "x" + posicion;

        return solucionFinal;

    }


    /**
     * Localiza el proceso que debe salir.
     * @return proceso saliente.
     */
    /**
     * Falta generalizar el código de manera que devuelva el valor xi que le corresponda!!!.
     */
    public String getSaliente(){

        for(Double d : valoresStack.get("sols"))
            dividendos.add(d);

        for(Double d : valoresStack.get("divisores"))
            divisores.add(d);


        int solIndex = 0; //almaneca la posicion en memoria de la solución.
            if((division(dividendos.get(0), divisores.get(0)) < division(dividendos.get(1), divisores.get(1)))) {
                if (division(dividendos.get(0), divisores.get(0)) < division(dividendos.get(2), divisores.get(2))) {
                    solIndex = 0;
                } else {
                    solIndex = 2;
                }
            }
            else if(division(dividendos.get(1), divisores.get(1)) < division(dividendos.get(2), divisores.get(2))){
                    solIndex = 1;
                }
            else {
                solIndex = 2;
                }

        String saliente = "";
        if(solIndex == 0) saliente = "x5";
        if(solIndex == 1) saliente = "x6";
        if(solIndex == 2) saliente = "x7";
        return saliente;
    }

    private double division(double dividendo, double divisor){
        return dividendo / divisor;
    }

}
