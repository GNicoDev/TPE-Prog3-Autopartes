package src.util;

import src.modelo.DatosMaquina;
import src.modelo.Maquina;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
    public static DatosMaquina leerArchivo(String rutaArchivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        List<Maquina> maquinas = new ArrayList<>();

        // Leer la primera línea (cantidad total de piezas a producir)
        int piezasTotales = Integer.parseInt(br.readLine().trim());

        // Leer las líneas restantes (máquinas y producción)
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 2) {
                String nombre = partes[0].trim();
                int produccion = Integer.parseInt(partes[1].trim());
                maquinas.add(new Maquina(nombre, produccion));
            }
        }
        br.close();
        return new DatosMaquina(piezasTotales, maquinas);
    }
}

