package Boletines.Boletin2.EjProfesorDomi;

import java.io.Serializable;

public class Asignatura implements Serializable {
    int asignId;
    String name;

    public Asignatura(int asignId, String name) {
        this.asignId = asignId;
        this.name = name;
    }

    public Asignatura() {

    }

    public int getAsignId() {
        return asignId;
    }

    public void setAsignId(int asignId) {
        this.asignId = asignId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
