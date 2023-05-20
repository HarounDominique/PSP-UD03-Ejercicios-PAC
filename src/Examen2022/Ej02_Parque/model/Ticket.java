package Examen2022.Ej02_Parque.model;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String visitante;
    private TipoTicket tipoTicket;
    private String tipoEntrada;
    private int precio;

    public Ticket() {
    }

    public Ticket(String visitante, TipoTicket tipoTicket) {
        this.visitante = visitante;
        this.tipoTicket = tipoTicket;
    }

    public String getVisitante() {
        return visitante;
    }


    public String getTipoEntrada() {
        return tipoEntrada;
    }


    public int getPrecio() {
        return precio;
    }

    public void calcularPrecio(){
        switch (tipoTicket){
            case NORMAL -> {
                this.tipoEntrada = "Normal";
                precio = 10;
            }
            case NINHOS -> {
                this.tipoEntrada = "Niños";
                precio = 3;
            }
            case CARNET_JOVEN -> {
                this.tipoEntrada = "Carnet Joven";
                precio = 5;
            }
            case PENSIONISTA -> {
                this.tipoEntrada = "Pensionisa";
                precio = 4;
            }
        }
    }

    @Override
    public String toString() {
        return  "Visitante: " + visitante + "\n"
                + "Tipo de entrada: " + tipoEntrada + "\n"
                + "Precio: " + precio + "€";
    }
}
