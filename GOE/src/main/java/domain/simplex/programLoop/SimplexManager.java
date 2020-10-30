package domain.simplex.programLoop;

import domain.simplex.programLoop.recurring.EntranteSaliente;
import domain.simplex.programLoop.recurring.procesos.IProceso;
import domain.simplex.programLoop.recurring.plantillas.PanelSimplexSolution;
import domain.simplex.programLoop.recurring.procesos.ProcesoHorizontal;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SimplexManager extends JFrame {

    private static final JTabbedPane jt = new JTabbedPane();

   private IProceso[][] valoresIniciales;// = FirstSimplex.matrizProcesos();

    public SimplexManager() {
         setUp();
    }

    private void setUp() {
       // initComponentes();
      //  initFrame();
        //manager();
    }

    /**
     * Método encargado de realizar el algoritmo.
     */
    public void manager() {
        boolean correcto = false;

        do {

            //Con este bloque de código compruebo que los datos originales no son Sol óptima.
            IProceso[][] solucion_1 = new IProceso[2][9];

           //Primera comprobacion de que la solucion actual no es la óptima.
            ArrayList<Double> wjsIniciales = new ArrayList<>();
            wjsIniciales.add(valoresIniciales[1][4].getX1());
            wjsIniciales.add(valoresIniciales[1][4].getX2());
            wjsIniciales.add(valoresIniciales[1][4].getX3());
            wjsIniciales.add(valoresIniciales[1][4].getX4());
            wjsIniciales.add(valoresIniciales[1][4].getX5());
            wjsIniciales.add(valoresIniciales[1][4].getX6());
            wjsIniciales.add(valoresIniciales[1][4].getX7());

            int contadorInicial = 0;
            for(Double d : wjsIniciales)
                if (d > 0) contadorInicial++;
            if(contadorInicial != 0)  correcto = true;

            //Una vez comprobado, comienzo con el bucle.


            EntranteSaliente es1 = new EntranteSaliente(valoresIniciales, 0);
            String entrante_1 = es1.getEntrante();
            String saliente_1 = es1.getSaliente(es1.getEntrante());//es1.getSaliente(FirstSimplex.salientesInicial());

            //Averiguo los procesos que se mantienen.
             String[] noSalientes_1 = es1.noSalientes(es1.getSaliente(es1.getEntrante()));
             String noSaliente_1_1 = noSalientes_1[0];
             String noSaliente_1_2 = noSalientes_1[1];


             


             //Empiezo a formar la nueva solución.

            //Con este código encuentro el proceso saliente horizontal (su índice en la matriz).
            int indexSaliente1 = 0;
            for(int i = 0; i < 3; i++)
                if(valoresIniciales[1][i].getNombreProceso().equals(saliente_1))
                    indexSaliente1 = i;








/*


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
            correcto = true;
        }while(!correcto);


    }

            //-------------------------------- Metodos a los que recurro durante la resolución del Simplex --------------------------------\\


    /**
     * Método encargado de calcular la fila del proceso entrante.
     * @param matriz
     * @param entrante
     * @param saliente
     * @return un proceso con los valores de la fila horizontal.
     */
    public IProceso calcularFilaEntrante(IProceso[][] matriz, String entrante, String saliente){

      IProceso solucion = new ProcesoHorizontal();
      IProceso procesoSaliente = null;
      IProceso procesoEntrante = null;

      //Consigo el proceso vertical entrante.
        for(int i = 0; i < 7; i++)
            if(matriz[0][i].getNombreProceso().equals(entrante))
                procesoEntrante = matriz[0][i];


      //inicializo todo el proceso saliente con este código.
      for(int i = 0; i < 3; i++){
          if(matriz[1][i].getNombreProceso().equals(saliente)){
              procesoSaliente = matriz[1][i];
          }

      }

      Double pivote = 0.0;
      //Calculo en qué posicion de la matriz[][] está el proceso entrante vertical.
      int indiceEntrante = 0;
      for(int i = 0; i < 7; i++) {
          if (matriz[0][i].getNombreProceso().equals(entrante)) {
              indiceEntrante = i;
          }
      }

        //calculo en qué indice de la matriz está el proceso saliente horizontal.
      int indiceSaliente = 0;
      for(int i = 0; i < 3; i++) {
          if (matriz[1][i].getNombreProceso().equals(saliente)) {
              indiceSaliente = i;
          }
      }

        //Con este código averiguo cuál será el pivote.
      if(indiceSaliente == 0) {
          pivote = matriz[1][indiceSaliente].getX1();
      }
      if(indiceSaliente == 1){
          pivote = matriz[1][indiceSaliente].getX2();
      }
      if(indiceSaliente == 2){
          pivote = matriz[1][indiceSaliente].getX3();
      }
      //doy valores al nuevo proceso horizontal.
     if(pivote != 0.0) {
         solucion.setNombreProceso(entrante);
         solucion.setX1(procesoSaliente.getX1() / pivote);
         solucion.setX2(procesoSaliente.getX2() / pivote);
         solucion.setX3(procesoSaliente.getX3() / pivote);
         solucion.setX4(procesoSaliente.getX4() / pivote);
         solucion.setX5(procesoSaliente.getX5() / pivote);
         solucion.setX6(procesoSaliente.getX6() / pivote);
         solucion.setX7(procesoSaliente.getX7() / pivote);
         solucion.setCantidad(procesoSaliente.getCantidad() / pivote);
         solucion.setCj(procesoEntrante.getCj());
     }
        return solucion;
    }

    /**
     * Método encargado de calcular un procesos no entrantes de la nueva solución
     * @param entranteCalculadoHorizontal proceso horizontal ya calculado
     * @param matriz donde almaceno los IProcesos.
     * @param nombreProcesoEntrante nombre del proceso que ha entrado (para coger el pivote Xi).
     * @param procesoNoSaliente para calcular la solución dividiento && para saber qué Xi del proceso vertical tomar como pivote.
     * @return proceso del programa base modificado.
     */
    public IProceso calcularProcesoProgramaBase(IProceso entranteCalculadoHorizontal, IProceso[][] matriz, String nombreProcesoEntrante, String procesoNoSaliente){

       IProceso entranteVertical = null;
       IProceso noSaliente = null;
       IProceso solucion = new ProcesoHorizontal();
       Double pivote = 0.0;

       //Creo un proceso vertical igual que el entrante.
        for(int i = 0; i < 7; i++){
            if(matriz[0][i].getNombreProceso().equals(nombreProcesoEntrante)) {
                entranteVertical = matriz[0][i];
            }
        }
       //Busco el proceso horizontal anterior sobre el que voy a realizar los cálculos.
        for(int i = 0; i < 3; i++) {

            if (matriz[1][i].getNombreProceso().equals(procesoNoSaliente)) {
                noSaliente = matriz[1][i];
            }
        }
        //calculo en qué indice de la matriz está el proceso que ha salido horizontal.
        int indice = 0;
        for(int i = 0; i < 3; i++) {
            if (matriz[1][i].getNombreProceso().equals(procesoNoSaliente)) {
                indice = i;
            }
        }
        //Si el indice es 0, el pivote es el elemento X1.
        if(indice == 0) {
            pivote = entranteVertical.getX1();
        }
        if(indice == 1) {
            pivote = entranteVertical.getX2();
        }

        if(indice == 2) {
            pivote = entranteVertical.getX3();
        }

       solucion.setNombreProceso(procesoNoSaliente);
       solucion.setX1(noSaliente.getX1() - (pivote * entranteCalculadoHorizontal.getX1()));
       solucion.setX2(noSaliente.getX2() - (pivote * entranteCalculadoHorizontal.getX2()));
       solucion.setX3(noSaliente.getX3() - (pivote * entranteCalculadoHorizontal.getX3()));
       solucion.setX4(noSaliente.getX4() - (pivote * entranteCalculadoHorizontal.getX4()));
       solucion.setX5(noSaliente.getX5() - (pivote * entranteCalculadoHorizontal.getX5()));
       solucion.setX6(noSaliente.getX6() - (pivote * entranteCalculadoHorizontal.getX6()));
       solucion.setX7(noSaliente.getX7() - (pivote * entranteCalculadoHorizontal.getX7()));
       solucion.setCantidad(noSaliente.getCantidad() - (pivote * entranteCalculadoHorizontal.getCantidad()));
       solucion.setCj(noSaliente.getCj());

       return solucion;
    }

    /**
     * Utilizo este método para calcular la fila Zj.
     *
     * @param matriz matriz con los procesos horizontales ya solucionados.
     * @return un ProcesoHorizontal inicializado con los valores de Zj.
     */
    public IProceso calcularZj(IProceso[][] matriz) {

        IProceso zj = new ProcesoHorizontal();
        zj.setNombreProceso("zj");

        //Obtengo el valor CJ por el cual voy a multiplicar los elementos. Calculo los valores de Zj.
        Double x1 = matriz[1][0].getCj() * matriz[1][0].getX1() + matriz[1][1].getCj() * matriz[1][1].getX1() + matriz[1][2].getCj() * matriz[1][2].getX1();
        Double x2 = matriz[1][0].getCj() * matriz[1][0].getX2() + matriz[1][1].getCj() * matriz[1][1].getX2() + matriz[1][2].getCj() * matriz[1][2].getX2();
        Double x3 = matriz[1][0].getCj() * matriz[1][0].getX3() + matriz[1][1].getCj() * matriz[1][1].getX3() + matriz[1][2].getCj() * matriz[1][2].getX3();
        Double x4 = matriz[1][0].getCj() * matriz[1][0].getX4() + matriz[1][1].getCj() * matriz[1][1].getX4() + matriz[1][2].getCj() * matriz[1][2].getX4();
        Double x5 = matriz[1][0].getCj() * matriz[1][0].getX5() + matriz[1][1].getCj() * matriz[1][1].getX5() + matriz[1][2].getCj() * matriz[1][2].getX5();
        Double x6 = matriz[1][0].getCj() * matriz[1][0].getX6() + matriz[1][1].getCj() * matriz[1][1].getX6() + matriz[1][2].getCj() * matriz[1][2].getX6();
        Double x7 = matriz[1][0].getCj() * matriz[1][0].getX7() + matriz[1][1].getCj() * matriz[1][1].getX7() + matriz[1][2].getCj() * matriz[1][2].getX7();

        //Con este bloque de código, añado los valores de Zj calculados a la matriz.
        zj.setX1(x1);
        zj.setX2(x2);
        zj.setX3(x3);
        zj.setX4(x4);
        zj.setX5(x5);
        zj.setX6(x6);
        zj.setX7(x7);

        return zj;
    }

    /**
     * Con este método calculo los valores de wj. La solución al simplex.
     * @param matriz matriz con los procesos necesarios.
     * @param zj proceso zj ya calculado.
     * @return un proceso horizontal con todos los valores de wj.
     */
    public IProceso calcularWj(IProceso[][] matriz, IProceso zj){
        IProceso wj = new ProcesoHorizontal();
        wj.setNombreProceso("wj");

        wj.setX1(matriz[0][0].getCj() - zj.getX1());
        wj.setX2(matriz[0][1].getCj() - zj.getX2());
        wj.setX3(matriz[0][2].getCj() - zj.getX3());
        wj.setX4(matriz[0][3].getCj() - zj.getX4());
        wj.setX5(matriz[0][4].getCj() - zj.getX5());
        wj.setX6(matriz[0][5].getCj() - zj.getX6());
        wj.setX7(matriz[0][6].getCj() - zj.getX7());

        return wj;
    }


    /**
     * Utilizo este método para hallar el orden en el que los xs horizontales van situados.
     * @param hm hace referencia a un HashMap con los Xs originales y su orden.
     * @param saliente hace referencia a los nombres del proceso saliente y los que no.
     * @param noSaliente_1
     * @param noSaliente_2
     * @return
     */
   private HashMap<String, Double> setPosiciones(HashMap<Double, String> hm, String saliente, String noSaliente_1, String noSaliente_2)
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
    private void asignarPosicion(HashMap<String, ArrayList<Double>> valores, HashMap<Double, String> hm, String saliente, String noSaliente_1,
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