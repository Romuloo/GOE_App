package domain.simplex.programLoop;

import domain.simplex.programLoop.firstStep.FirstSimplex;
import domain.simplex.programLoop.recurring.EntranteSaliente;
import domain.simplex.programLoop.recurring.plantillas.PanelSimplexSolution;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SimplexManager extends JFrame {

    private static final JTabbedPane jt = new JTabbedPane();

    private HashMap<String, ArrayList<Double>> valoresIniciales = FirstSimplex.getValoresStack();

    public SimplexManager() {
         setUp();
    }

    private void setUp() {
        initComponentes();
        initFrame();
        manager();
    }

    /**
     * Método encargado de realizar el algoritmo.
     */
    public void manager() {
        boolean correcto = false;


        EntranteSaliente es = new EntranteSaliente(FirstSimplex.matrizProcesos(), 0);
        System.out.println("Entrante: " + es.getEntrante());
        System.out.println("Saliente: " + es.getSaliente(es.getEntrante()));
        do {
            correcto = true;
        /*    correcto = true;
            //Con este bloque de código compruebo que los datos originales no son Sol óptima.
            HashMap<String, ArrayList<Double>> solucion_1 = new HashMap<>();
            ArrayList<Double> wjsIniciales =  valoresIniciales.get("wjs");
            int contadorInicial = 0;
            for(Double d : wjsIniciales)
                if (d > 0) contadorInicial++;
            if(contadorInicial != 0)  correcto = true;

            EntranteSalienteR2 es1 = new EntranteSalienteR2(0);
            String entrante_1 = es1.getEntrante();
            String saliente_1 = "x2";//es1.getSaliente(FirstSimplex.salientesInicial());

            //Averiguo los procesos que se mantienen.
           // String[] noSalientes_1 = es1.noSalientes(FirstSimplex.salientesInicial(), saliente_1);
            //String noSaliente_1_1 = noSalientes_1[0];
          //  String noSaliente_1_2 = noSalientes_1[1];


            //Empiezo a formar el nuevo HashMap con la solución {solucion_1}

            //Definitivamente, con este bloque de código incluyo los elementos de las filas hxs calculadas.
            solucion_1.put("cjs", valoresIniciales.get("cjs"));
            String entranteEnMap_1 = "h" + entrante_1;
            String noSalienteEnMap_1_1 = "h" + noSaliente_1_1;
            String noSalienteEnMap_1_2 = "h" + noSaliente_1_2;

            solucion_1.put(entranteEnMap_1, getElementosProcesoEntrante(valoresIniciales.get(entranteEnMap_1), entrante_1));
            solucion_1.put(noSalienteEnMap_1_1, getElementosDelProgramaBase(valoresIniciales.get(entranteEnMap_1),
                    valoresIniciales.get(noSalienteEnMap_1_1), entrante_1));
            solucion_1.put(noSalienteEnMap_1_2, getElementosDelProgramaBase(valoresIniciales.get(entranteEnMap_1),
                    valoresIniciales.get(noSalienteEnMap_1_2), entrante_1));

            //Annado el valor Cj horizontal a cada solucion.
            solucion_1.get(entranteEnMap_1).add(valoresIniciales.get(entrante_1).get(0));
            solucion_1.get(noSalienteEnMap_1_1).add(valoresIniciales.get(noSaliente_1_1).get(0));
            solucion_1.get(noSalienteEnMap_1_2).add(valoresIniciales.get(noSaliente_1_2).get(0));

            //llamo al método calcular Zjs y calculo el array horizontal con todas las zjs.
            solucion_1.put("zjs", calcularZjs(solucion_1.get(entranteEnMap_1), solucion_1.get(noSalienteEnMap_1_1), solucion_1.get(noSalienteEnMap_1_2)));

            //llamo al método calcular Wjs y calculo el array horizontal con todas las wjs.
            solucion_1.put("wjs", calcularWjs(valoresIniciales.get("cjs"),
                    calcularZjs(solucion_1.get(entranteEnMap_1), solucion_1.get(noSalienteEnMap_1_1), solucion_1.get(noSalienteEnMap_1_2))));

            //Hasta aquí debería tener todos los valores de la solucion 1. Ahora he de plasmarlos.
           //Llamo a un método que me crea un nuevo Jpanel, lo inicializa y lo añade al  JtabblePane.

            asignarPosicion(solucion_1, FirstSimplex.posicionesFirst(), saliente_1, noSaliente_1_1, noSaliente_1_2, entranteEnMap_1, noSalienteEnMap_1_1,
                    noSalienteEnMap_1_2);

            //Si el bloque de código anterior ha funcionado como debía, debería de haber llenado en la posición 9 el índice donde debería ir cada fila.
           // correcto = true;


            nuevaIteracion(solucion_1, entranteEnMap_1, noSalienteEnMap_1_1, noSalienteEnMap_1_2 );

*/
        }while(!correcto);


    }

            //-------------------------------- Metodos a los que recurro durante el simplex


    /**
     * Este método toma un ArrayList como parámetro y devuelve las soluciones de la fila en cuestion;
     * @param ar
     * @param pivote
     * @return ArrayList con los valores de la fila entera
     */
  public ArrayList<Double> getElementosProcesoEntrante(ArrayList<Double> ar, String pivote)
    {
        ArrayList<Double> sol = new ArrayList<>();
        //encuentro el pivote:
        int indxPivote = Integer.parseInt(pivote.charAt(1) + "") - 1; //Si es X1, me da la posicion 0
        //Utilizar ese pivote para dividir los demás
        //Me rellena el ArrayList con los elemenos divididos por el pivote
        for(int i = 0; i <7; i++){
            sol.add(ar.get(i)/ar.get(indxPivote));
        }
        return sol;
    }

            /**
             * Este método calcula los valores de la fila de un proceso que permanece en el programa base.
             * @param ar
             * @param thisAr
             * @param pivote
             * @return el arrayList con los valores de la fila calculados.
             */
    public ArrayList<Double> getElementosDelProgramaBase(ArrayList<Double> ar, ArrayList<Double> thisAr, String pivote)
    {
       ArrayList<Double> sol = new ArrayList<>();
       ArrayList<Double> arAnterior = getElementosProcesoEntrante(ar, pivote);

       for(int i = 0; i < 7; i++)
           sol.add(thisAr.get(i) - (thisAr.get(i) * arAnterior.get(i)));

       return sol;
    }

            /**
             * Hago uso de este método para calcular los procesos Zjs de la iteración actual.
             * @param x1 array que hace referencia a hx1/hx2/hx3
             * @param x2
             * @param x3
             * @return un arrayList con los valores de Zj.
             */
   public ArrayList<Double> calcularZjs(ArrayList<Double> x1, ArrayList<Double> x2, ArrayList<Double> x3)
    {
        double multiplicador_1 = x1.get(7);
        double multiplicador_2 = x2.get(7);
        double multiplicador_3 = x3.get(7);

        //Copio los ArrayList porque no me fio de que se mantengan los valores iniciales.
        ArrayList<Double> aux1 = new ArrayList<>(), aux2 = new ArrayList<>(), aux3 = new ArrayList<>(), solucion = new ArrayList<>();

        for(int i = 0; i < 7 ; i++)
              aux1.add(x1.get(i) * multiplicador_1);

        for(int i = 0; i < 7 ; i++)
            aux2.add(x2.get(i) * multiplicador_2);

        for(int i = 0; i < 7 ; i++)
            aux3.add(x3.get(i) * multiplicador_3);

        //Ahora sumo los valores
        for(int i = 0; i < 7; i++)
            solucion.add(aux1.get(i) + aux2.get(i) + aux3.get(i));

        return solucion;
    }

            /**
             * Este método me calcula los valores de Wjs.
             * @param cjs
             * @param zjs
             * @return un arrayList con los valores de Wjs.
             */
    public ArrayList<Double> calcularWjs(ArrayList<Double> cjs, ArrayList<Double> zjs)
    {
        ArrayList<Double> solu = new ArrayList<>();
        for(int i = 0; i < 7; i++)
            solu.add(cjs.get(i) - zjs.get(i));

        return solu;
    }

            /**
             * Utilizo este método para hallar el orden en el que los xs horizontales van situados.
             * @param hm hace referencia a un HashMap con los Xs originales y su orden.
             * @param saliente hace referencia a los nombres del proceso saliente y los que no.
             * @param noSaliente_1
             * @param noSaliente_2
             * @return
             */
   public HashMap<String, Double> setPosiciones(HashMap<Double, String> hm, String saliente, String noSaliente_1, String noSaliente_2)
    {
        HashMap<String, Double> indices = new HashMap<>();
        //Con este codigo me hago con la posicion de cada fila.
      double aux = 0, aux2 = 0, aux3 = 0;
      for(double i = 0; i < 3; i++){
          if(hm.get(i) == saliente)
              aux = i;
          if(hm.get(i) == noSaliente_1)
              aux2 = i;
          if(hm.get(i) == noSaliente_2)
              aux3 = i;
      }

      indices.put(saliente, aux);
      indices.put(noSaliente_1, aux2);
      indices.put(noSaliente_2, aux3);

      return indices;
    }


            /**
             * Utilizo este método para annadir un valor a cada arrayList que indica el orden en el que debe ir situado.
             * @param valores
             * @param hm
             * @param saliente
             * @param noSaliente_1
             * @param noSaliente_2
             * @param entranteHorizontal
             * @param noSalienteHorizontal_1
             * @param noSalienteHorizontal_2
             */
    public void asignarPosicion(HashMap<String, ArrayList<Double>> valores, HashMap<Double, String> hm, String saliente, String noSaliente_1,
                                              String noSaliente_2, String entranteHorizontal, String noSalienteHorizontal_1, String noSalienteHorizontal_2)
    {
        HashMap<String, Double> orden= setPosiciones(hm, saliente, noSaliente_1, noSaliente_2);


        //En este bloque de código añado a cada arraylist dentro de valores un numero que indica su orden.
        // (Ahora este numero se guardará en la posición 10)
            valores.get(entranteHorizontal).add(orden.get(saliente));
            valores.get(noSalienteHorizontal_1).add(orden.get(noSaliente_1));
            valores.get(noSalienteHorizontal_2).add(orden.get(noSaliente_2));
    }

            /**
             * Método encargado de crear un Panel, inicializarlo y annadirlo al JPannelTable.
             * !! deben de ser el entrante, noSaliente... horizontales !!
             */
   private void nuevaIteracion(HashMap<String, ArrayList<Double>> map, String entrante,
                                String noSaliente_1, String noSaliente_2)
    {
        PanelSimplexSolution p = new PanelSimplexSolution();
        jt.add(p);

        p.getCj1().setText("" + map.get("cjs").get(0));
        p.getCj2().setText("" + map.get("cjs").get(1));
        p.getCj3().setText("" + map.get("cjs").get(2));
        p.getCj4().setText("" + map.get("cjs").get(3));
        p.getCj5().setText("" + map.get("cjs").get(4));
        p.getCj6().setText("" + map.get("cjs").get(5));
        p.getCj7().setText("" + map.get("cjs").get(6));

        p.getZj1().setText("" + map.get("zjs").get(0));
        p.getZj2().setText("" + map.get("zjs").get(1));
        p.getZj3().setText("" + map.get("zjs").get(2));
        p.getZj4().setText("" + map.get("zjs").get(3));
        p.getZj5().setText("" + map.get("zjs").get(4));
        p.getZj6().setText("" + map.get("zjs").get(5));
        p.getZj7().setText("" + map.get("zjs").get(6));

        p.getWj1().setText("" + map.get("wjs").get(0));
        p.getWj2().setText("" + map.get("wjs").get(1));
        p.getWj3().setText("" + map.get("wjs").get(2));
        p.getWj4().setText("" + map.get("wjs").get(3));
        p.getWj5().setText("" + map.get("wjs").get(4));
        p.getWj6().setText("" + map.get("wjs").get(5));
        p.getWj7().setText("" + map.get("wjs").get(6));

        //Este bloque de codigo me crea un arrayList con los tres arrayList ordenados seguún su posición!
        //Posibles fallos en copiar y pegar.
        ArrayList<ArrayList> horizontalesOrdenados = new ArrayList<>();
        if (map.get(entrante).get(9) < map.get(noSaliente_1).get(9)){
            if (map.get(entrante).get(9) < map.get(noSaliente_2).get(9)) {
                horizontalesOrdenados.add(map.get(entrante));
                if (map.get(noSaliente_1).get(9) < map.get(noSaliente_2).get(9)) {
                    horizontalesOrdenados.add(map.get(noSaliente_1));
                    horizontalesOrdenados.add(map.get(noSaliente_2));
                } else {
                    horizontalesOrdenados.add(map.get(noSaliente_2));
                    horizontalesOrdenados.add(map.get(noSaliente_1));
                }
            }
        } else if (map.get(noSaliente_1).get(9) < map.get(noSaliente_2).get(9)) {
            horizontalesOrdenados.add(map.get(noSaliente_1));
            if (map.get(entrante).get(9) < map.get(noSaliente_2).get(9)) {
                horizontalesOrdenados.add(map.get(entrante));
                horizontalesOrdenados.add(map.get(noSaliente_2));
            } else {
                horizontalesOrdenados.add(map.get(noSaliente_2));
                horizontalesOrdenados.add(map.get(entrante));
            }
        } else {
            horizontalesOrdenados.add(map.get(noSaliente_2));
            if (map.get(entrante).get(9) < map.get(noSaliente_1).get(9)) {
                horizontalesOrdenados.add(map.get(entrante));
                horizontalesOrdenados.add(map.get(noSaliente_1));
            } else {
                horizontalesOrdenados.add(map.get(noSaliente_1));
                horizontalesOrdenados.add(map.get(entrante));

            }

        }


        p.getX11().setText("" + horizontalesOrdenados.get(0).get(0));
        p.getX21().setText("" + horizontalesOrdenados.get(0).get(1));
        p.getX31().setText("" + horizontalesOrdenados.get(0).get(2));
        p.getX41().setText("" + horizontalesOrdenados.get(0).get(3));
        p.getX51().setText("" + horizontalesOrdenados.get(0).get(4));
        p.getX61().setText("" + horizontalesOrdenados.get(0).get(5));
        p.getX71().setText("" + horizontalesOrdenados.get(0).get(6));
        p.getC1().setText("" + horizontalesOrdenados.get(0).get(7));
        p.getCj8().setText("" + horizontalesOrdenados.get(0).get(8));

        p.getX12().setText("" + horizontalesOrdenados.get(1).get(0));
        p.getX22().setText("" + horizontalesOrdenados.get(1).get(1));
        p.getX32().setText("" + horizontalesOrdenados.get(1).get(2));
        p.getX42().setText("" + horizontalesOrdenados.get(1).get(3));
        p.getX52().setText("" + horizontalesOrdenados.get(1).get(4));
        p.getX62().setText("" + horizontalesOrdenados.get(1).get(5));
        p.getX72().setText("" + horizontalesOrdenados.get(1).get(6));
        p.getC2().setText("" + horizontalesOrdenados.get(1).get(7));
        p.getCj9().setText("" + horizontalesOrdenados.get(1).get(8));


        p.getX13().setText("" + horizontalesOrdenados.get(2).get(0));
        p.getX23().setText("" + horizontalesOrdenados.get(2).get(1));
        p.getX33().setText("" + horizontalesOrdenados.get(2).get(2));
        p.getX43().setText("" + horizontalesOrdenados.get(2).get(3));
        p.getX53().setText("" + horizontalesOrdenados.get(2).get(4));
        p.getX63().setText("" + horizontalesOrdenados.get(2).get(5));
        p.getX73().setText("" + horizontalesOrdenados.get(2).get(6));
        p.getC3().setText("" + horizontalesOrdenados.get(2).get(7));
        p.getCj10().setText("" + horizontalesOrdenados.get(2).get(8));

        //Sin generalizar
        p.getV1().setText(entrante);
        p.getV2().setText(noSaliente_1);
        p.getV3().setText(noSaliente_2);


    }


            //------------------------------------------ Frame stuff
            private void initComponentes () {
                add(jt);
                // jt.add(new PanelSimplexSolution(), 0);
            }
            private void initFrame () {
                setBackground(new Color(39, 156, 207));
                setSize(1190 / 2, 1226 / 2 + 70);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setVisible(true);
                setLocation(100, 20);
                setResizable(false);
                setTitle("Simplex - Solucion");
            }
}