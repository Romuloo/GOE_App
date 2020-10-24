package domain.simplex.programLoop.recurring.plantillas;

import java.util.Objects;

public class ProcesoHorizontal implements IProceso{

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

    @Override
    public Double getWj() {
        return null;
    }

    @Override
    public Double getZj() {
        return null;
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

    public ProcesoHorizontal(String nombreProceso, Double cj, Double x1, Double  x2, Double x3, Double x4,
                             Double x5, Double x6, Double x7, Double cantidad) {
        this.nombreProceso = nombreProceso;
        this.cj = cj;
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        this.x5 = x5;
        this.x6 = x6;
        this.x7 = x7;
        this.cantidad = cantidad;
    }
    public ProcesoHorizontal(){

    }

    public ProcesoHorizontal(String nombreProceso){
    this.nombreProceso = nombreProceso;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcesoHorizontal proceso = (ProcesoHorizontal) o;
        return Objects.equals(nombreProceso, proceso.nombreProceso);
    }

}
