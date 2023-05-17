package Boletines.Boletin2.Ej04_Persona;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;

    public Persona(){

    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
