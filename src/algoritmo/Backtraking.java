package src.algoritmo;

import src.modelo.Maquina;

import java.util.ArrayList;
import java.util.List;
/*
 * Algoritmo de Backtracking para la selección óptima de máquinas.
 *
 El estado final se alcanza cuando la producción total cumple con la cantidad requerida, priorizando
 la combinación con menos máquinas activadas (metodo esMejorSolucion es quien define esto). Para mejorar
 la eficiencia, se aplican podas estratégicas, evitando explorar combinaciones que excedan la producción
 necesaria o aquellas que ya usan más máquinas que una solución previa. Además, ordenar las máquinas de
 mayor a menor producción reduce la profundidad del árbol y optimiza la búsqueda

 */

/*PseudoCodigo:
Backtrack (solucionActual, mejorSolucion,listMaquinas, cantidaPiezas)
if solucionActual es solucion -> cubre la cantidad de piesas a producir
    if cantidadPiezas == 0
        mejorSolucion = solucionActual
    else
        foreach(maquina: ListMaquinas)
            if cantPiezas - maquina.getProduccion >= 0
                solucionActual.add(maquina)
                cantPiezas-=maquina.getProduccion()
                if esMejorselecion(solucionActual)
                    backTracking (solucionActual, mejorSolucion, listMaquinas, cantPiezas)
                canPiezas+= maquina.getProduccion()
                solucionActual.remove(maquina)

 */

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
