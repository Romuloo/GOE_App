package domain.simplex.programLoop.recurring;
import java.util.ArrayList;
import java.util.HashMap;

public class MatrixCalculator {

    //Programa de ejemplo para calcular la inversa de una matriz


    /**
     * Calcula la matriz inversa.
     * @param hm HashMap con los datos proporcionados
     * @param x variable 1 (columna).
     * @param y variable 2 (columna).
     * @param z variable 3 (columna).
     * @return Un HashMap con las nuevas soluciones.
     */


        public static HashMap<String, ArrayList<Double>> getMatrixInversa(HashMap<String, ArrayList<Double>> hm, String x, String y, String z){

            /*
            El codigo de error tiene que estar por aqui. El método en si me halla la correcta inversa pero al pasarlo al arraylist(creo) da otros resultados.
             */
            double[][] matriz = new double[3][3];
            ArrayList<Double> a1 = hm.get(x);
            ArrayList<Double> a2 = hm.get(y);
            ArrayList<Double> a3 = hm.get(z);
            int a = 0, b = 0, c = 0;

            for(int i = 1; i<4; i++){
                matriz[0][a] = a1.get(i);
                a++;
            }

            for(int i = 0; i<3; i++){
                matriz[1][b] = a2.get(i);
                b++;
            }

            for(int i = 0; i<3; i++){
                matriz[2][c] = a3.get(i);
                c++;
            }


            double[][] matrizInversa = invert(matriz);

            HashMap<String, ArrayList<Double>> finalhm = new HashMap<>();

            ArrayList<Double> sol1 = new ArrayList<>();
            for(int i = 0; i<3; i++)
                sol1.add(matrizInversa[0][i]);

            ArrayList<Double> sol2 = new ArrayList<>();
            for(int i = 0; i<3; i++)
                sol2.add(matrizInversa[1][i]);

            ArrayList<Double> sol3 = new ArrayList<>();
            for(int i = 0; i<3; i++)
                sol3.add(matrizInversa[2][i]);

            finalhm.put(x, sol1);
            finalhm.put(y, sol2);
            finalhm.put(z, sol2);


            return finalhm;

        }


        public static double[][] invert(double a[][])         {

            int n = a.length;
            double x[][] = new double[n][n];
            double b[][] = new double[n][n];
            int index[] = new int[n];
            for (int i=0; i<n; ++i)
                b[i][i] = 1;

            // Transform the matrix into an upper triangle

            gaussian(a, index);

            // Update the matrix b[i][j] with the ratios stored
            for (int i=0; i<n-1; ++i)
                for (int j=i+1; j<n; ++j)
                    for (int k=0; k<n; ++k)
                        b[index[j]][k]
                                -= a[index[j]][i]*b[index[i]][k];


            // Perform backward substitutions
            for (int i=0; i<n; ++i)             {
                x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
                for (int j=n-2; j>=0; --j)                 {
                    x[j][i] = b[index[j]][i];
                    for (int k=j+1; k<n; ++k)
                    {
                        x[j][i] -= a[index[j]][k]*x[k][i];
                    }

                    x[j][i] /= a[index[j]][j];
                }
            }
            for(int i = 0; i <3; i++)
                for(int j = 0; j < 3; j++)
                    System.out.println(x[i][j] + " Matriz buena " + i );
            return x;
        }

        // Method to carry out the partial-pivoting Gaussian
        // elimination.  Here index[] stores pivoting order.

        private static void gaussian(double a[][], int index[])  {

            int n = index.length;
            double c[] = new double[n];

            // Initialize the index
            for (int i=0; i<n; ++i)
                index[i] = i;

            // Find the rescaling factors, one from each row
            for (int i=0; i<n; ++i) {
                double c1 = 0;
                for (int j=0; j<n; ++j) {
                    double c0 = Math.abs(a[i][j]);
                    if (c0 > c1) c1 = c0;
                }
                c[i] = c1;
            }

            // Search the pivoting element from each column
            int k = 0;
            for (int j=0; j<n-1; ++j) {
                double pi1 = 0;
                for (int i=j; i<n; ++i)  {

                    double pi0 = Math.abs(a[index[i]][j]);
                    pi0 /= c[index[i]];
                    if (pi0 > pi1) {
                        pi1 = pi0;
                        k = i;
                    }
                }


                // Interchange rows according to the pivoting order
                int itmp = index[j];
                index[j] = index[k];
                index[k] = itmp;
                for (int i=j+1; i<n; ++i) {
                    double pj = a[index[i]][j]/a[index[j]][j];

                    // Record pivoting ratios below the diagonal
                    a[index[i]][j] = pj;

                    // Modify other elements accordingly
                    for (int l=j+1; l<n; ++l)
                        a[index[i]][l] -= pj*a[index[j]][l];
                }
            }
        }
}
