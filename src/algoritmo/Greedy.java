package src.algoritmo;

import src.modelo.Maquina;

import java.util.ArrayList;
import java.util.List;
/*
 * La estrategia greedy que utilizare, es seleccionar la máquina que maximiza la producción sin
 * exceder la cantidad total requerida. Para ello se deberan tener las maquinas ordenadas segun
 * produccion,y en cada paso, ir eligiendo la que más piezas produzca sin sobrepasar el objetivo e ir
 * decontando del total para la siguiente eleccion
 * */
public class Greedy {
    private static int candidatosEvaluados; // Contador de candidatos considerados


    public List<Maquina> getSeleccion(int piezasTotales, List<Maquina> maquinas) {

        List<Maquina> seleccion = new ArrayList<>();

        candidatosEvaluados=0;

        // Ordenar máquinas de mayor a menor producción
        maquinas.sort((m1, m2) -> Integer.compare(m2.getProduccion(), m1.getProduccion()));

        while (piezasTotales > 0) {
            Maquina maquina = seleccionar(maquinas, piezasTotales);

            if (maquina == null) {
                return null; // No se encontró solución
            }

            seleccion.add(maquina);
            piezasTotales -= maquina.getProduccion();
            candidatosEvaluados++;
        }
        return seleccion;
    }

    private Maquina seleccionar(List<Maquina> maquinas, int piezasTotales) {
        for (Maquina maquina : maquinas) {
            if (maquina.getProduccion() <= piezasTotales) {
                return maquina;
            }
        }
        return null;
    }

    public int getCandidatosEvaluados(){
        return candidatosEvaluados;
    }
}
