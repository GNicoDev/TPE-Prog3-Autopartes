package src.modelo;

import java.util.List;

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
