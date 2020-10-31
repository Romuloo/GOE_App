package domain.simplex.programLoop;

import domain.simplex.programLoop.firstStep.FirstSimplex;
import domain.simplex.programLoop.recurring.EntranteSaliente;
import domain.simplex.programLoop.recurring.procesos.IProceso;
import domain.simplex.programLoop.recurring.plantillas.PanelSimplexSolution;
import domain.simplex.programLoop.recurring.procesos.ProcesoHorizontal;
import domain.simplex.programLoop.recurring.procesos.ProcesoVertical;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

/**
 * Clase encargada de resolver el algoritmo del simplex.
 */

public class SimplexManager extends JFrame {

    private JTabbedPane jt = new JTabbedPane();

    public SimplexManager() {
         setUp();
    }

    private void setUp() {
       initComponentes();
        initFrame();
        jt.add(new PanelSimplexSolution());
       try {
           manager();
       }catch(Exception e){
           System.out.println();
           System.out.println("--------> Debes rellenar todos los campos, o si no deben estar a 0. <--------");
           System.out.println();
       }
    }

    /**
     * Método encargado de resolver el simplex
     */
    public void manager(){

       IProceso[][] matriz = FirstSimplex.matrizProcesos();
       int contador = 0;
       IProceso[][] copiaAux = null;
       do {

           IProceso[][] solucion = calcularIteracion(matriz, contador++);
           //En este bloque de codigo averiguo el saliente y entrante.
           String saliente = "";
           String entrante = "";
           for(int i = 0; i < 3; i++)
           {
               if(!solucion[1][i].getNombreProceso().equals(matriz[1][i].getNombreProceso())){
                   entrante = solucion[1][i].getNombreProceso();
                   saliente = matriz[1][i].getNombreProceso();
           }

           }
           jt.add(addIteracionJPanel(solucion, entrante, saliente));
           copiaAux = solucion;
           matriz = solucion;


       }while(!esSolucionOptima(copiaAux));




    }

    //-------------------------------- Metodos a los que recurro durante la resolución del Simplex --------------------------------\\


    /**
     * Este método calcula si la iteración actual es la solucón óptima.
     * @param matriz
     * @return si es o no la solución óptima.
     */
    public boolean esSolucionOptima(IProceso[][] matriz){

        boolean correcto = true;

        ArrayList<Double> wjsIniciales = new ArrayList<>();
        wjsIniciales.add(matriz[1][4].getX1());
        wjsIniciales.add(matriz[1][4].getX2());
        wjsIniciales.add(matriz[1][4].getX3());
        wjsIniciales.add(matriz[1][4].getX4());
        wjsIniciales.add(matriz[1][4].getX5());
        wjsIniciales.add(matriz[1][4].getX6());
        wjsIniciales.add(matriz[1][4].getX7());

        int contadorInicial = 0;
        for (Double d : wjsIniciales)
            if (d > 0) contadorInicial++;

        return (contadorInicial == 0) ? correcto : !correcto;
    }

    /**
     * Método encargado de realizar una iteración del simplex.
     * @param matriz matriz con los IProcesos.
     * @return una matriz de IProceso con la solución de la iteración.
     */
    public IProceso[][] calcularIteracion(IProceso[][] matriz, int contador) {
      //  boolean correcto = false;

            //Con este bloque de código compruebo que los datos originales no son Sol óptima.
            IProceso[][] solucion = new IProceso[2][9];

            //Una vez comprobado, comienzo con el bucle.


            EntranteSaliente es1 = new EntranteSaliente(matriz, contador);
            String entrante_1 = es1.getEntrante();
            String saliente_1 = es1.getSaliente(es1.getEntrante());//es1.getSaliente(FirstSimplex.salientesInicial());

            //Averiguo los procesos que se mantienen.
             String[] noSalientes_1 = es1.noSalientes(es1.getSaliente(es1.getEntrante()));
             String noSaliente_1_1 = noSalientes_1[0];
             String noSaliente_1_2 = noSalientes_1[1];

             //Aquí uso los métodos para calcular las filas del programa entrante y las que se mantienen.
             IProceso filaEntrante_1 = calcularFilaEntrante(matriz, entrante_1, saliente_1);
             IProceso filaProgramaBase_1_1 = calcularProcesoProgramaBase(filaEntrante_1, matriz, entrante_1, noSaliente_1_1);
             IProceso filaProgramaBase_1_2 = calcularProcesoProgramaBase(filaEntrante_1, matriz, entrante_1, noSaliente_1_2);

             //Con este bloque de código organizo las soluciones obtenidas en la nueva matriz solución.
            for(int i = 0; i < 3; i++){
                if(matriz[1][i].getNombreProceso().equals(saliente_1)){
                    solucion[1][i] = filaEntrante_1;
                }
                if(matriz[1][i].getNombreProceso().equals(filaProgramaBase_1_1.getNombreProceso())){
                    solucion[1][i] = filaProgramaBase_1_1;
                }
                if(matriz[1][i].getNombreProceso().equals(filaProgramaBase_1_2.getNombreProceso())){
                    solucion[1][i] = filaProgramaBase_1_2;
                }
            }
            //Calculo zj y lo añado a la solución.
            IProceso zj = calcularZj(solucion);
            solucion[1][3] = zj;

            //Calculo wj y lo añado a la solución.
            IProceso wj = calcularWj(matriz, zj);
            solucion[1][4] = wj;

            IProceso x1 = new ProcesoVertical(), x2 = new ProcesoVertical(), x3 = new ProcesoVertical(), x4 = new ProcesoVertical(),
                    x5 = new ProcesoVertical(), x6 = new ProcesoVertical(), x7 = new ProcesoVertical();

        x1.setCj(matriz[0][0].getCj()); x1.setNombreProceso("x1"); x1.setX1(solucion[1][0].getX1()); x1.setX2(solucion[1][1].getX1()); x1.setX3(solucion[1][2].getX1());
        x2.setCj(matriz[0][1].getCj()); x2.setNombreProceso("x2"); x2.setX1(solucion[1][0].getX2()); x2.setX2(solucion[1][1].getX2()); x2.setX3(solucion[1][2].getX2());
        x3.setCj(matriz[0][2].getCj()); x3.setNombreProceso("x3"); x3.setX1(solucion[1][0].getX3()); x3.setX2(solucion[1][1].getX3()); x3.setX3(solucion[1][2].getX3());
        x4.setCj(matriz[0][3].getCj()); x4.setNombreProceso("x4"); x4.setX1(solucion[1][0].getX4()); x4.setX2(solucion[1][1].getX4()); x4.setX3(solucion[1][2].getX4());
        x5.setCj(matriz[0][4].getCj()); x5.setNombreProceso("x5"); x5.setX1(solucion[1][0].getX5()); x5.setX2(solucion[1][1].getX5()); x5.setX3(solucion[1][2].getX5());
        x6.setCj(matriz[0][5].getCj()); x6.setNombreProceso("x6"); x6.setX1(solucion[1][0].getX6()); x6.setX2(solucion[1][1].getX6()); x6.setX3(solucion[1][2].getX6());
        x7.setCj(matriz[0][6].getCj()); x7.setNombreProceso("x7"); x7.setX1(solucion[1][0].getX7()); x7.setX2(solucion[1][1].getX7()); x7.setX3(solucion[1][2].getX7());

        IProceso cantidades = new ProcesoVertical();
        cantidades.setNombreProceso("cantidades");
        cantidades.setX1(solucion[1][0].getCantidad());
        cantidades.setX2(solucion[1][1].getCantidad());
        cantidades.setX3(solucion[1][2].getCantidad());

        solucion[0][8] = cantidades;


        solucion[0][0] = x1; solucion[0][1] = x2; solucion[0][2] = x3; solucion[0][3] = x4; solucion[0][4] = x5; solucion[0][5] = x6; solucion[0][6] =x7;

        return solucion;
    }

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


      //inicializo el proceso saliente con este código.
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
          pivote = matriz[0][indiceEntrante].getX1();
      }
      if(indiceSaliente == 1){
          pivote = matriz[0][indiceEntrante].getX2();
      }
      if(indiceSaliente == 2){
          pivote = matriz[0][indiceEntrante].getX3();
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
    public IProceso calcularWj(IProceso[][] matriz, IProceso zj) {
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
     * Metodo encargado de generarme un JPanel con la iteración.
     * @param matriz
     * @return el panel completo.
     */
    public PanelSimplexSolution addIteracionJPanel(IProceso[][] matriz, String entrante, String saliente){
        PanelSimplexSolution p = new PanelSimplexSolution();
        jt.add(p);

        p.getEnt().setText(entrante);
        p.getSal().setText(saliente);
        p.getSol().setText("" + (matriz[1][0].getCj() * matriz[1][0].getCantidad() + matriz[1][1].getCj() * matriz[1][1].getCantidad()
                + matriz[1][2].getCj() * matriz[1][2].getCantidad()));
        p.getCj1().setText("" + matriz[0][0].getCj());
        p.getCj2().setText("" + matriz[0][1].getCj());
        p.getCj3().setText("" + matriz[0][2].getCj());
        p.getCj4().setText("" + matriz[0][3].getCj());
        p.getCj5().setText("" + matriz[0][4].getCj());
        p.getCj6().setText("" + matriz[0][5].getCj());
        p.getCj7().setText("" + matriz[0][6].getCj());

        p.getZj1().setText("" + matriz[1][3].getX1());
        p.getZj2().setText("" + matriz[1][3].getX2());
        p.getZj3().setText("" + matriz[1][3].getX3());
        p.getZj4().setText("" + matriz[1][3].getX4());
        p.getZj5().setText("" + matriz[1][3].getX5());
        p.getZj6().setText("" + matriz[1][3].getX6());
        p.getZj7().setText("" + matriz[1][3].getX7());

        p.getWj1().setText("" + matriz[1][4].getX1());
        p.getWj2().setText("" + matriz[1][4].getX2());
        p.getWj3().setText("" + matriz[1][4].getX3());
        p.getWj4().setText("" + matriz[1][4].getX4());
        p.getWj5().setText("" + matriz[1][4].getX5());
        p.getWj6().setText("" + matriz[1][4].getX6());
        p.getWj7().setText("" + matriz[1][4].getX7());

        p.getX11().setText("" + matriz[1][0].getX1());
        p.getX21().setText("" + matriz[1][0].getX2());
        p.getX31().setText("" + matriz[1][0].getX3());
        p.getX41().setText("" + matriz[1][0].getX4());
        p.getX51().setText("" + matriz[1][0].getX5());
        p.getX61().setText("" + matriz[1][0].getX6());
        p.getX71().setText("" + matriz[1][0].getX7());
        p.getC1().setText("" + matriz[1][0].getCantidad());
        p.getCj8().setText("" + matriz[1][0].getCj());

        p.getX12().setText("" + matriz[1][1].getX1());
        p.getX22().setText("" + matriz[1][1].getX2());
        p.getX32().setText("" + matriz[1][1].getX3());
        p.getX42().setText("" + matriz[1][1].getX4());
        p.getX52().setText("" + matriz[1][1].getX5());
        p.getX62().setText("" + matriz[1][1].getX6());
        p.getX72().setText("" + matriz[1][1].getX7());
        p.getC2().setText("" + matriz[1][1].getCantidad());
        p.getCj9().setText("" + matriz[1][1].getCj());


        p.getX13().setText("" + matriz[1][2].getX1());
        p.getX23().setText("" + matriz[1][2].getX2());
        p.getX33().setText("" + matriz[1][2].getX3());
        p.getX43().setText("" + matriz[1][2].getX4());
        p.getX53().setText("" + matriz[1][2].getX5());
        p.getX63().setText("" + matriz[1][2].getX6());
        p.getX73().setText("" + matriz[1][2].getX7());
        p.getC3().setText("" + matriz[1][2].getCantidad());
        p.getCj10().setText("" + matriz[1][2].getCj());


        p.getV1().setText(matriz[1][0].getNombreProceso());
        p.getV2().setText(matriz[1][1].getNombreProceso());
        p.getV3().setText(matriz[1][2].getNombreProceso());

        return p;
    }

            //------------------------------------------ Frame stuff ------------------------------------------\\

    private void initComponentes () {
    add(jt);
    }

    private void initFrame () {

        setBackground(new Color(10, 200, 207));
        setSize(2324, 1298);// + 70);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation(100, 20);
        setResizable(false);
        setTitle("Simplex - Solucion");
    }
}