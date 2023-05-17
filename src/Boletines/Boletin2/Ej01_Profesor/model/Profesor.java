package Boletines.Boletin2.Ej01_Profesor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Profesor implements Serializable {
    private int idProfesor;
    private String nombre;
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private Especialidad especialidad;

    public Profesor() {
    }

    public Profesor(int idProfesor, String nombre) {
        this.idProfesor = idProfesor;
        this.nombre = nombre;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
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
                "idProfesor=" + idProfesor +
                ", nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad.getNombreEspecialidad() +
                '}';
    }
}
