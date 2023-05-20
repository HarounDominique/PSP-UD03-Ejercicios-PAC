package Examen2022.Ej01_Calculadora.model;

import java.io.Serializable;

public class Calculo implements Serializable {

    private TipoOperacion operacion;
    private int valor1;
    private int valor2;

    public Calculo() {
    }

    public Calculo(TipoOperacion operacion, int valor1, int valor2) {
        this.operacion = operacion;
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public TipoOperacion getOperacion() {
        return operacion;
    }

    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }

    public int calcular(){
        int result = 0;
        switch (operacion){
            case SUMA -> result = valor1 + valor2;
            case RESTA -> result = valor1 - valor2;
            case MULTIPLICACIÓN -> result = valor1 * valor2;
            case DIVISIÓN -> result = valor1 / valor2;
        }

        return result;
    }
}
