package domain.simplex.programLoop.recurring.plantillas;

import java.util.Objects;

public class ProcesoVertical implements IProceso{

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

    public ProcesoVertical(String nombreProceso, Double cj, Double x1, Double x2, Double x3, Double zj, Double wj) {
        this.nombreProceso = nombreProceso;
        this.cj = cj;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.zj = zj;
        this.wj = wj;
    }
    public ProcesoVertical(){

    }

    public ProcesoVertical(String nombreProceso){
        this.nombreProceso = nombreProceso;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcesoVertical proceso = (ProcesoVertical) o;
        return this.nombreProceso.equals(proceso.getNombreProceso());
    }

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

