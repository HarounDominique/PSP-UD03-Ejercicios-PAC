package Boletin2.Ej04_Persona;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) throws IOException {
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345; //puerto remoto al que envío
        byte[] mensaje;
        DatagramPacket envio;
        DatagramPacket recibo;
        DatagramSocket socket = new DatagramSocket();

        socket.setSoTimeout(5000);

        try {

            Persona persona = new Persona();

            System.out.println("Introduzca el nombre de la persona:");
            persona.setNombre(new Scanner(System.in).nextLine());

            System.out.println("Enviando objeto: " + persona);

            try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(bos);
                 DatagramSocket socketSend = new DatagramSocket(34567); //Local port
            ) {
                oos.writeObject(persona);

                mensaje = bos.toByteArray();
                //Construyo el datagrama a enviar
                envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
                socketSend.send(envio);
            }



            // recibo cadena del servidor
            byte[] buffer = new byte[1024];
            recibo = new DatagramPacket(buffer, buffer.length);

            socket.receive(recibo);

            //String cadenaRecibida = new String(recibo.getData());

            Persona personaRecibida;

            try(ByteArrayInputStream bis = new ByteArrayInputStream(buffer);
            ObjectInputStream ois = new ObjectInputStream(bis)
            ) {
                personaRecibida = (Persona) ois.readObject();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Recibido: " + personaRecibida);

            //Cerrar recursos
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
