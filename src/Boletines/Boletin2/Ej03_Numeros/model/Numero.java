package Boletines.Boletin2.Ej03_Numeros.model;

import java.io.Serializable;

public class Numero implements Serializable {
    private int numero;
    private long cuadrado;
    private long cubo;

    public Numero() {
    }

    public Numero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void calcularCuadrado(){
        this.cubo = (long) Math.pow(numero, 2);
    }

    public void calcularCubo(){
        this.cubo = (long) Math.pow(numero, 3);
    }

    @Override
    public String toString() {
        return "Numero{" +
                "numero=" + numero +
                ", cuadrado=" + cuadrado +
                ", cubo=" + cubo +
                '}';
    }
}
