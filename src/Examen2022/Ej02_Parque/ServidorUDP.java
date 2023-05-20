package Examen2022.Ej02_Parque;

import Examen2022.Ej02_Parque.model.Ticket;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
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
