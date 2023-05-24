package Boletines.Boletin2.EjProfesorDomi;

import java.io.Serializable;
import java.util.Arrays;

public class Profesor implements Serializable {
    private int id;
    private String name;
    private Asignatura[] asignaturas;
    private Especialidad especialidad;

    public Profesor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Profesor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(Asignatura[] asignaturas) {
        if(asignaturas.length<2){
            this.asignaturas = asignaturas;
        }
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", asignaturas=" + Arrays.toString(asignaturas) +
                ", especialidad=" + especialidad +
                '}';
    }
}
