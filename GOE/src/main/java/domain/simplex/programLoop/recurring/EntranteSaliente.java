package domain.simplex.programLoop.recurring;

import domain.simplex.programLoop.recurring.plantillas.IProceso;
import domain.simplex.programLoop.recurring.plantillas.ProcesoHorizontal;

import java.util.*;

public class EntranteSaliente {



    private HashMap<String, ArrayList<Double>> valoresStack;
    private int contador;

    private ArrayList<IProceso> procesos;

    private ArrayList<Double> xs = new ArrayList<>();

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
    public EntranteSaliente(ArrayList<IProceso> procesos, int cont){
        this.procesos = procesos;
        this.contador = cont;
    }


    /**
     * Con este código encuentro el entrante.
     *
     * @return la variable que sale del proceso simplex.
     */

    public String getEntranteP(){
        //Con este bloque de codigo obtengo el objeto.

        double solucion = 0; //almacenará la solución de quién es más grande.
        int posicion = 0; //almacenará la dirección de memoria del elemento mayor en el ArrayList.

        ProcesoHorizontal x1 = new ProcesoHorizontal("x1");
        xs.add(procesos.get(procesos.indexOf(x1)).getCj());

        ProcesoHorizontal x2 = new ProcesoHorizontal("x2");
        xs.add(procesos.get(procesos.indexOf(x2)).getCj());

        ProcesoHorizontal x3 = new ProcesoHorizontal("x3");
        xs.add(procesos.get(procesos.indexOf(x3)).getCj());

        ProcesoHorizontal x4 = new ProcesoHorizontal("x4");
        xs.add(procesos.get(procesos.indexOf(x4)).getCj());

        ProcesoHorizontal x5 = new ProcesoHorizontal("x5");
        xs.add(procesos.get(procesos.indexOf(x5)).getCj());

        ProcesoHorizontal x6 = new ProcesoHorizontal("x6");
        xs.add(procesos.get(procesos.indexOf(x6)).getCj());

        ProcesoHorizontal x7 = new ProcesoHorizontal("x7");
        xs.add(procesos.get(procesos.indexOf(x7)).getCj());

        PriorityQueue<Double> values = new PriorityQueue<>();
        values.add(xs.get(0));
        values.add(xs.get(1));
        values.add(xs.get(2));
        values.add(xs.get(3));
        values.add(xs.get(4));
        values.add(xs.get(5));
        values.add(xs.get(6));

        for (int i = 0; i < 7 - contador; i++)
            solucion = values.remove();
        System.out.println(solucion);

        for (int i = 0; i < 7; i++)
            if (solucion == xs.get(i))
                posicion = i + 1;
        System.out.println(posicion);

        String solucionFinal = "x" + posicion;

        return solucionFinal;

    }
    /*
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

*/

    /**
     * Localiza el proceso que debe salir.
     * @return proceso saliente.
     */
    public String getSaliente(ArrayList<String> procesosSalientes){

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
        if(solIndex == 0) saliente = procesosSalientes.get(0);
        if(solIndex == 1) saliente = procesosSalientes.get(1);
        if(solIndex == 2) saliente = procesosSalientes.get(2);
        return saliente;
    }

    private double division(double dividendo, double divisor){
        return dividendo / divisor;
    }

    public String[] noSalientes(ArrayList<String> p, String saliente)
    {
        ArrayList<String> procesos = p;
        int idx = procesos.indexOf(saliente);
        procesos.remove(idx);

        String[] procesosNoSalientes = new String[2];
        procesosNoSalientes[0] = procesos.get(0);
        procesosNoSalientes[1] = procesos.get(1);

        return procesosNoSalientes;
    }

}
