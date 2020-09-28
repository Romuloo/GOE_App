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


    public EntranteSaliente(HashMap<String, ArrayList<Double>> es, int cont){
        this.valoresStack = es;
        this.contador = cont;
    }

    /**
     * Con este código encuentro el entrante.
     * @return
     */
    public String getEntrante(){

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
        cjs.add(x1.get(0)); cjs.add(x2.get(0)); cjs.add(x3.get(0)); cjs.add(x4.get(0));
        cjs.add(x5.get(0)); cjs.add(x6.get(0)); cjs.add(x7.get(0));

        //Creo una priorityQueue donde encontrar el máximo dependiendo de la iteración del simplex.
        PriorityQueue<Double> values = new PriorityQueue<>();
        values.add(x1.get(0)); values.add(x2.get(0)); values.add(x3.get(0)); values.add(x4.get(0));
        values.add(x5.get(0)); values.add(x6.get(0)); values.add(x7.get(0));

        for(int i = 0; i < 7 - contador; i++)
            solucion = values.remove();
        System.out.println(solucion);

        for(int i = 0; i < 7; i++)
            if(solucion == cjs.get(i))
                posicion = i + 1;
        System.out.println(posicion);

        String solucionFinal = "x" + posicion;

        return solucionFinal;

    }





/**

 private HashMap<String, Double> getValores(){



 private void getSaliente() {
 double aux1, aux2, aux3;
 String entrante = getEntrante();
 aux1 = valores().get(entrante + 1);
 aux2 = valores().get(entrante + 2);
 aux3 = valores().get(entrante + 3);

 ArrayList<Double> auxs = new ArrayList<>();
 auxs.add(aux1);
 auxs.add(aux2);
 auxs.add(aux3);
 String saliente = "";

 double help = 0;
 int cont = 1;
 for (int i = 1; i < 4; i++) {
 if ((valores().get("c" + i) / auxs.get(i - 1)) < valores().get("c" + ++cont) / auxs.get(i)) {
 saliente = ("v" + i);
 } else {
 saliente = ("v" + cont);
 }
 }

 procesos.put("sal", saliente);
 System.out.println(procesos.get("sal"));
 }
 */
}
