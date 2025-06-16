package src.modelo;

public class Maquina {
    private String nombre;
    private Integer produccion;

    public Maquina(String nombre, Integer produccion) {
        this.nombre = nombre;
        this.produccion = produccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getProduccion() {
        return produccion;
    }

    public void setProduccion(Integer produccion) {
        this.produccion = produccion;
    }
}

