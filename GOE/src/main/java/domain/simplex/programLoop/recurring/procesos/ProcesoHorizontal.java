/**
 Copyright [2020] [Javier Linares Castrillón]
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */
package domain.simplex.programLoop.recurring.procesos;

/**
 * @author Javier Linares Castrillón
 */

/**
 * Clase encargada de definir un proceso horizontal.
 */
public class ProcesoHorizontal implements IProceso {

    private String nombreProceso;

    private Double cj, x1, x2, x3, x4, x5, x6, x7, cantidad;

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public Double getCj() {
        return cj;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    public Double getX3() {
        return x3;
    }

    public Double getX4() {
        return x4;
    }

    public Double getX5() {
        return x5;
    }

    public Double getX6() {
        return x6;
    }

    public Double getX7() {
        return x7;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCj(Double cj) {
        this.cj = cj;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public void setX3(Double x3) {
        this.x3 = x3;
    }

    public void setX4(Double x4) {
        this.x4 = x4;
    }

    public void setX5(Double x5) {
        this.x5 = x5;
    }

    public void setX6(Double x6) {
        this.x6 = x6;
    }

    public void setX7(Double x7) {
        this.x7 = x7;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Constructor de la clase ProcesoHorizontal.
     */
    public ProcesoHorizontal(){

    }

    /**
     * Con este método defino cuándo un proceso es igaul a otro. En este caso,
     * un proceso es igual a otro cuando tienen el mismo nombre.
     * @param o
     * @return un boolean que dice si son o no iguales.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcesoHorizontal proceso = (ProcesoHorizontal) o;
        return this.nombreProceso.equals(proceso.getNombreProceso());
    }

    /**
     * Utilizo este método para comparar dos procesos respecto al hashCode del nombre.
     * @param o
     * @return un integer que dice si son o no iguales.
     */

    @Override
    public int compareTo(IProceso o) {
        return this.nombreProceso.hashCode() - o.getNombreProceso().hashCode();

    }
    @Override
    public void setWj(Double d) {
    }

    @Override
    public void setZj(Double d) {
    }

    @Override
    public Double getWj() {
        return null;
    }

    @Override
    public Double getZj() {
        return null;
    }

}
