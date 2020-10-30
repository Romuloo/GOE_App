package domain.simplex.programLoop.recurring;

import domain.simplex.programLoop.firstStep.FirstSimplex;
import domain.simplex.programLoop.recurring.plantillas.IProceso;
import domain.simplex.programLoop.recurring.plantillas.ProcesoVertical;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class EntranteSaliente {

    private IProceso[][] matrizProcesos;


    private int contador;
    //maetodo 1
    private ArrayList<Double> xs = new ArrayList<>();
    //metodo 2
    private ArrayList<Double> dividendos = new ArrayList<>(), divisores = new ArrayList<>();

    public EntranteSaliente(IProceso[][] matriz, int contador){
        this.contador = contador;
        this.matrizProcesos = matriz;
    }

    /**
     * Con este método calculo el proceso entrante.
     * @return proceso entrante.
     */
    public String getEntrante(){
        double solucion = 0; //almacenará la solución de quién es más grande.
        int posicion = 0; //almacenará la dirección de memoria del elemento mayor en el ArrayList.

        xs.add((matrizProcesos[0][0]).getCj());
        xs.add((matrizProcesos[0][1]).getCj());
        xs.add((matrizProcesos[0][2]).getCj());
        xs.add((matrizProcesos[0][3]).getCj());
        xs.add((matrizProcesos[0][4]).getCj());
        xs.add((matrizProcesos[0][5]).getCj());
        xs.add((matrizProcesos[0][6]).getCj());


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

        for (int i = 0; i < 7; i++)
            if (solucion == xs.get(i))
                posicion = i + 1;

        String solucionFinal = "x" + posicion;


        return solucionFinal;
    }

    /**
     * Coon este método calculo el proceso saliente.
     * @param entrante
     * @return el proceso saliente.
     */
    public String getSaliente(String entrante){

        int index = 0;
        for(int i = 0; i < 7; i++)
            if(matrizProcesos[0][i].getNombreProceso().equals(entrante))
                index = i;

        dividendos.add(matrizProcesos[0][8].getX1());
        dividendos.add(matrizProcesos[0][8].getX2());
        dividendos.add(matrizProcesos[0][8].getX3());

        //Con este bloque de código, repito la misma estrategia pero pasando el parámetro "entrante".
        divisores.add(matrizProcesos[0][index].getX1());
        divisores.add(matrizProcesos[0][index].getX2());
        divisores.add(matrizProcesos[0][index].getX3());

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

        //Con este bloque de codigo, obtengo el nombre del proceso horizontal cuya cantidad coincide con un objeto de Procesos verticales.
        String saliente = "";
        if(solIndex == 0) saliente = matrizProcesos[1][0].getNombreProceso();
        if(solIndex == 1) saliente = matrizProcesos[1][1].getNombreProceso();
        if(solIndex == 2) saliente = matrizProcesos[1][2].getNombreProceso();

        return saliente;
    }


    private double division(double dividendo, double divisor){
        return dividendo / divisor;
    }

    /**
     * Utilizo este método para hallar los procesos que no van a salir.
     * ¡Importante! -> Se utiliza el proceso saliente y NO el entrante, de otro modo no funcionaría.
     * @param saliente
     * @return una tupla con los dos procesos no salientes.
     */
    public String[] noSalientes(String saliente){
        int idx = 0;
        for(int i = 0; i < 3; i++)
            if(matrizProcesos[1][i].getNombreProceso().equals(saliente))
             idx = i;

        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(0); aux.add(1); aux.add(2);

        aux.remove(aux.indexOf(idx));

        String[] procesosNoSalientes = new String[2];
        procesosNoSalientes[0] = matrizProcesos[1][aux.get(0)].getNombreProceso();
        procesosNoSalientes[1] = matrizProcesos[1][aux.get(1)].getNombreProceso();

        return procesosNoSalientes;
    }

}
