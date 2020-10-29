package domain.simplex.programLoop.recurring.plantillas;

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

    String getNombreProceso();


}
