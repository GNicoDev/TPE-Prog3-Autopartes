package src.vista;

import src.modelo.DatosMaquina;
import src.modelo.Maquina;

import java.util.List;

public class Vista {
    public void presentar(DatosMaquina datos) {
        System.out.println("\n===== RESULTADOS =====");
        System.out.println("Piezas Totales a producir: " + datos.getPiezasTotales());
        System.out.println("\nMáquinas disponibles:");

        List<Maquina> maquinas = datos.getMaquinas();
        for (Maquina maquina : maquinas) {
            System.out.println("*" + maquina.getNombre() + " → " + maquina.getProduccion() + " piezas");
        }

        System.out.println("======================\n");
    }
    public void mostrarSolucion(List<Maquina> datos, String titulo, int costoComputacional) {
        System.out.println("\n===== SOLUCIÓN " + titulo + " =====");

        if (datos.isEmpty()) {
            System.out.println(" No se encontró una solución con el algoritmo " + titulo.toLowerCase() + ".");
        } else {
            System.out.println("*** Máquinas seleccionadas:");
            int totalProduccion = 0;

            for (Maquina maquina : datos) {
                System.out.println("* " + maquina.getNombre() + " → " + maquina.getProduccion() + " piezas");
                totalProduccion += maquina.getProduccion();
            }

            System.out.println("\n*** Total de piezas producidas: " + totalProduccion);
            System.out.println("*** Máquinas puestas en funcionamiento: " + datos.size());
        }

        System.out.println("*** Métrica (Costo computacional): " + costoComputacional);
        System.out.println("==============================\n");
    }

}
