package Examen2022.Ej02_Parque;

import Examen2022.Ej02_Parque.model.Ticket;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
    /* Empleando datagram sockets, un cliente envía al servidor el nombre del usuario y el tipo de entrada al parque de atracciones.
     * El servidor le devolverá un ticket en el que figuren los datos del usuario y el importe.
     * Cliente:
     * - Se pide al usuario el nombre completo
     * - Se le muestran los tipos de entradas, para que indique la que le interesa.
     * ▪ Normal: 10 €▪ Niños: 3 €
     * ▪ Carnet joven: 5 €
     * ▪ Pensionista: 4 €
     * Servidor:
     * Una vez que tiene todos los datos, mostrará por su consola una entrada:
     * VISITANTE: Pepe Pérez
     * TIPO DE ENTRADA: Carnet joven
     * A PAGAR: 5 € El paso de datos entre procesos se hará a través de un objeto de la clase Ticket
     */
    public static void main(String[] args) {
        int serverPort = 6000;
        try (
                DatagramSocket serverSocket = new DatagramSocket(serverPort)
        ){
            byte[] incomingBuffer = new byte[1024];

            System.out.println("Esperando recepción...");
            DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
            serverSocket.receive(incomingPacket);

            ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bis);

            try {
                Ticket ticket = (Ticket) ois.readObject();
                ticket.calcularPrecio();
                System.out.println("Calculando precio...");
                System.out.println(ticket);

                System.out.println("Enviando a cliente...");

                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(ticket);
                byte[] outgoingBuffer = bos.toByteArray();

                DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, incomingPacket.getAddress(), incomingPacket.getPort());
                serverSocket.send(outgoingPacket);


            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
