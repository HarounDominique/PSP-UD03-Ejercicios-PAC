package Examen2022.Ej02_Parque;

import Examen2022.Ej02_Parque.model.Ticket;
import Examen2022.Ej02_Parque.model.TipoTicket;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "localhost";
        int clientPort = 12345;
        int serverPort = 6000;

        try (
                DatagramSocket clientSocket = new DatagramSocket(clientPort))
        {
            Ticket ticket = generarTicket();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            try (
                    ObjectOutputStream oos = new ObjectOutputStream(bos)
            ){
                oos.writeObject(ticket);
                byte[] outgoingBuffer = bos.toByteArray();

                DatagramPacket outgoingPacket = new DatagramPacket(outgoingBuffer, outgoingBuffer.length, InetAddress.getByName(host), serverPort);
                System.out.println("Enviando datos...");
                clientSocket.send(outgoingPacket);


                byte[] incomingBuffer = new byte[1024];
                DatagramPacket incomingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
                clientSocket.receive(incomingPacket);
                System.out.println("Recibiendo tarifa...");

                ByteArrayInputStream bis = new ByteArrayInputStream(incomingPacket.getData());
                ObjectInputStream ois = new ObjectInputStream(bis);

                try {
                    ticket = (Ticket) ois.readObject();
                    System.out.println(ticket.toString());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            bos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Ticket generarTicket(){
        System.out.println("Introduzca su nombre completo:");
        String name = sc.nextLine();
        System.out.println("Seleccióne su tipo de entrada:");
        System.out.println("1 -- Entrada normal");
        System.out.println("2 -- Entrada infantil");
        System.out.println("3 -- Entrada Carnet Joven");
        System.out.println("4 -- Entrada pensionista");
        int option = Integer.parseInt(sc.nextLine());

        Ticket ticket = new Ticket();

        switch (option){
            case 1 -> ticket = new Ticket(name, TipoTicket.NORMAL);
            case 2 -> ticket = new Ticket(name, TipoTicket.NINHOS);
            case 3 -> ticket = new Ticket(name, TipoTicket.CARNET_JOVEN);
            case 4 -> ticket = new Ticket(name, TipoTicket.PENSIONISTA);
        }

        return ticket;
    }
}
