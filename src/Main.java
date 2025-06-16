package src;

import src.algoritmo.Backtraking;
import src.algoritmo.Greedy;
import src.modelo.DatosMaquina;
import src.util.LectorArchivo;
import src.vista.Vista;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Leemos el archivo con la informacion
        String rutaArchivo = "data/configuracion.txt";
        Vista vista = new Vista();
        Greedy greedy = new Greedy();
        Backtraking backTraking = new Backtraking();
        String tituloG = "GREEDY", tituloB = "BACKTRAKING";

        try {
            // obtenemos los datos del txt
            DatosMaquina datos = LectorArchivo.leerArchivo(rutaArchivo);
            vista.presentar(datos); // mostramos los datos obtenidos por consola

            // mostramos el resultado obtenido por el algoritmo greedy
            vista.mostrarSolucion(greedy.getSeleccion(datos.getPiezasTotales(), datos.getMaquinas()),tituloG,greedy.getCandidatosEvaluados());

            //mostramos el resultado obtenido por el algoritmo backtracking
            vista.mostrarSolucion(backTraking.getSeleccion(datos.getPiezasTotales(), datos.getMaquinas()), tituloB, backTraking.getEstadosGenerados());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
