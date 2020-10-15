package domain.simplex.programLoop;

import domain.simplex.programLoop.firstStep.FirstSimplex;
import domain.simplex.programLoop.recurring.EntranteSaliente;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SimplexManager extends JFrame {

    private static final JTabbedPane jt = new JTabbedPane();

    private HashMap<String, ArrayList<Double>>  valoresIniciales = FirstSimplex.getValoresStack();

    public SimplexManager(){

        initComponentes();
        initFrame();
        manager();
    }

    /**
     * Método encargado de realizar el algoritmo.
     */
    public void manager(){
        boolean correcto = false;


        do{
            //Con este bloque de código compruebo que los datos originales no son Sol óptima.
            HashMap<String, ArrayList<Double>> solucion_1 = new HashMap<>();
            ArrayList<Double> wjsIniciales =  valoresIniciales.get("wjs");
            int contadorInicial = 0;
            for(Double d : wjsIniciales)
                if (d > 0) contadorInicial++;
            if(contadorInicial != 0)  correcto = true;

            EntranteSaliente es1 = new EntranteSaliente(valoresIniciales, 0);
            String entrante_1 = es1.getEntrante();
            String saliente_1 = es1.getSaliente(FirstSimplex.salientesInicial());

            ArrayList<Double> hx1s = new ArrayList<>();
            ArrayList<Double> hx2s = new ArrayList<>();
            ArrayList<Double> hx3s = new ArrayList<>();

            String constante_1 = "", constante_2 = "";

            HashMap<String, Integer> indexProceso = new HashMap<>();
           //en este bloque de codigo annado los procesos con su supuesto indice
            if(saliente_1 == "x5"){
                constante_1 = "x6";
                constante_2 = "x7";
                indexProceso.put(saliente_1, 0);
                indexProceso.put(constante_1, 1);
                indexProceso.put(constante_2, 2);
            }

            if(saliente_1 == "x6"){
                constante_1 = "x5";
                constante_2 = "x7";
                indexProceso.put(constante_1, 0);
                indexProceso.put(saliente_1, 1);
                indexProceso.put(constante_2, 2);
            }

            if(saliente_1 == "x7"){
                constante_1 = "x6";
                constante_2 = "x5";
                indexProceso.put(constante_2, 0);
                indexProceso.put(constante_1, 1);
                indexProceso.put(saliente_1, 2);
            }

            HashMap<String, Integer> sortedIndexProceso = ordenarPorValor(indexProceso);


            /*
            Annado los valores de la primera itearion.
             */

         /*   for(int i = 0; i < 7; i++)
                hx1s.add(valoresIniciales.get("h"+saliente_1).get(i)/valoresIniciales.get(entrante_1).get(1));
            solucion_1.put("h"+entrante_1, hx1s);

            //Tengo que ver cómo ordenar los datos una vez obtenidos. no es lo mismo x1 x6 x7
            // que x6 x1 x7
            //DA IGUAL, AUNQUE SE GUARDEN DESORDENADOS, YO ME LAS APAÑO PARA ORDENARLOS.
            //YA PERO PARA ESTE ALGORITMO DE AQUI ABAJO NECESITO SABER LADIBhanxjovgb n
            //CLASE QUE RESUELVA ESTO?
            if(indexProceso.get(constante_1) < indexProceso.get(constante_2)) {
                for(int i = 0; i < 7; i++)
                    hx2s.add(valoresIniciales.get(constante_1).get);
            }
*/


            
            correcto = true;




        }while(!correcto);



    }


    /**
     * Ordena un hashMap por su valor.
     * @param hm hashMap que quiero ordenar
     * @return hashMap ordenador.
     */
    private HashMap<String, Integer> ordenarPorValor(HashMap<String, Integer> hm)
    {
        LinkedList<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    private void initComponentes(){
        add(jt);
        // jt.add(new PanelSimplexSolution(), 0);
    }
    private void initFrame(){
        setBackground(new Color(39, 156, 207));
        setSize(1190/2,1226/2+70);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation(100, 20);
        setResizable(false);
        setTitle("Simplex - Solucion");
    }
}