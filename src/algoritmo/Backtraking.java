package src.algoritmo;

import src.modelo.Maquina;

import java.util.ArrayList;
import java.util.List;

public class Backtraking {
    private static int estadosGenerados; // Contador de estados explorados

    public List<Maquina> getSeleccion(int piezasTotales, List<Maquina> maquinas) {
        List<Maquina> seleccionActual = new ArrayList<>();
        List<Maquina> mejorSolucion = new ArrayList<>();

        estadosGenerados = 0;

        // Ordenar máquinas de mayor a menor producción
        maquinas.sort((m1, m2) -> Integer.compare(m2.getProduccion(), m1.getProduccion()));

        backtracking(seleccionActual, mejorSolucion, maquinas, piezasTotales);

        return mejorSolucion;
    }

    private void backtracking(List<Maquina> seleccionActual, List<Maquina> mejorSolucion, List<Maquina> maquinas, int piezasTotales) {
        estadosGenerados++;

        if (piezasTotales == 0) {
            mejorSolucion.clear();
            mejorSolucion.addAll(seleccionActual);
        }
        else {
            for (Maquina maquina : maquinas) {

                if (piezasTotales - maquina.getProduccion() >= 0) {
                    seleccionActual.add(maquina);
                    piezasTotales -= maquina.getProduccion();

                    if (esMejorSeleccion(seleccionActual, mejorSolucion)) {
                        backtracking(seleccionActual, mejorSolucion, maquinas, piezasTotales);
                    }

                    seleccionActual.remove(maquina);
                    piezasTotales += maquina.getProduccion();
                }
            }
        }
    }

    private boolean esMejorSeleccion(List<Maquina> seleccionActual, List<Maquina> mejorSolucion) {
        if (mejorSolucion.size() == 0) {
            return true;
        }
        if (seleccionActual.size() < mejorSolucion.size()){
            return true;
        }
        return false;
    }

    public int getEstadosGenerados(){
        return estadosGenerados;
    }
}
