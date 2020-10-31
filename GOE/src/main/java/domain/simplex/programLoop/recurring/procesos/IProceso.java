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
 * Esta interfaz es la encargada de definir el conjunto de requisitos que deben de cumplir los procesos.
 */
public interface IProceso extends Comparable<IProceso> {
    Double getX1();
    Double getX2();
    Double getX3();
    Double getX4();
    Double getX5();
    Double getX6();
    Double getX7();
    Double getCj();
    Double getWj();
    Double getZj();
    Double getCantidad();
    String getNombreProceso();

    void setX1(Double d);
    void setX2(Double d);
    void setX3(Double d);
    void setX4(Double d);
    void setX5(Double d);
    void setX6(Double d);
    void setX7(Double d);
    void setCj(Double d);
    void setWj(Double d);
    void setZj(Double d);
    void setCantidad(Double d);
    void setNombreProceso(String s);

}
