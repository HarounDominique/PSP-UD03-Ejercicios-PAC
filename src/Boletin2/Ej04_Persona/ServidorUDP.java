package Boletin2.Ej04_Persona;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServidorUDP {
    public static void main(String[] args) throws IOException {
        byte[] buffer;// para recibir el datagrama

        // Asocio el socket al puerto 12345
        DatagramSocket socket = new DatagramSocket(12345);

        System.out.println("Servidor Esperando Datagrama .......... ");
        DatagramPacket recibo;

        String paquete = "";
        buffer = new byte[1024];
        recibo = new DatagramPacket(buffer, buffer.length);

        socket.receive(recibo);// recibo datagrama

        //paquete = new String(recibo.getData());// obtengo String
        //paquete = paquete.trim();


        Persona personaRecibida;

        try(ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = new ObjectInputStream(bis)
        ) {
            personaRecibida = (Persona) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Recibido: " + personaRecibida);

        personaRecibida.setNombre("John Doe");

        // DIRECCION ORIGEN DEL MENSAJE
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();

        byte[] bufferEnvio;

        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos)
        ) {
            oos.writeObject(personaRecibida);

            bufferEnvio = bos.toByteArray();

            DatagramPacket envio = new DatagramPacket(bufferEnvio, bufferEnvio.length, IPOrigen, puerto);
            socket.send(envio);

            System.out.println("Enviando: " + personaRecibida);
        }

        // CERRAR STREAMS Y SOCKETS
        System.out.println("Cerrando conexion...");
        socket.close();
    }
}
