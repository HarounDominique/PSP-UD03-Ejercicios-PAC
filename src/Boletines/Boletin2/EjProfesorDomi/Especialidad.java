package Boletines.Boletin2.EjProfesorDomi;

import java.io.Serializable;

public class Especialidad implements Serializable {
    int especialId;
    String name;

    public Especialidad(int especialId, String name) {
        this.especialId = especialId;
        this.name = name;
    }

    public Especialidad() {
    }

    public int getEspecialId() {
        return especialId;
    }

    public void setEspecialId(int especialId) {
        this.especialId = especialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
