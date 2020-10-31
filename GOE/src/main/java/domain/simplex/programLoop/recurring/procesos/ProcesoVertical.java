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
 * Clase encargada de definir un proceso vertical.
 */
public class ProcesoVertical implements IProceso {

    private String nombreProceso;

    private Double cj, x1, x2, x3, zj, wj;

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

    @Override
    public void setX4(Double d) {

    }

    @Override
    public void setX5(Double d) {

    }

    @Override
    public void setX6(Double d) {

    }

    @Override
    public void setX7(Double d) {

    }

    public void setZj(Double zj) {
        this.zj = zj;
    }

    @Override
    public void setCantidad(Double d) {

    }

    public void setWj(Double wj) {
        this.wj = wj;
    }

    /**
     * Constructor de la clase ProcesoVertical.
     */
    public ProcesoVertical(){
    }

    /**
     * Con este método defino cuándo un proceso es igual a otro. En este caso,
     * un proceso es igual a otro cuando tienen el mismo nombre.
     * @param o
     * @return un boolean que dice si son o no iguales.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcesoVertical proceso = (ProcesoVertical) o;
        return this.nombreProceso.equals(proceso.getNombreProceso());
    }

    /**
     * Utilizo este método para comparar dos procesos respecto al hashCode de su nombre.
     * @param o
     * @return un integer que dice si son o no iguales.
     */
    @Override
    public int compareTo(IProceso o) {
        return this.nombreProceso.hashCode() - o.getNombreProceso().hashCode();
    }



    @Override
    public Double getWj() {
        return null;
    }

    @Override
    public Double getZj() {
        return null;
    }

    @Override
    public Double getCantidad() {
        return null;
    }

    @Override
    public Double getX4() {
        return null;
    }

    @Override
    public Double getX5() {
        return null;
    }

    @Override
    public Double getX6() {
        return null;
    }

    @Override
    public Double getX7() {
        return null;
    }
}

