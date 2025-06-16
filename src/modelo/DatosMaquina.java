package src.modelo;

import java.util.List;
// Esta clase es la encargada de almacenar los datos obtenidos desde la clase LectorArchivo.java
public class DatosMaquina {
    private int piezasTotales;
    private List<Maquina> maquinas;

    public DatosMaquina(int piezasTotales, List<Maquina> maquinas) {
        this.piezasTotales = piezasTotales;
        this.maquinas = maquinas;
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

}
