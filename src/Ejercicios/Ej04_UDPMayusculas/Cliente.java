package Ejercicios.Ej04_UDPMayusculas;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        int port = 12345; //puerto remoto

        try {
            InetAddress destino = InetAddress.getLocalHost();

            System.out.println("Introduzca una cadena para enviar mediante UDP:");
            String cadena = new Scanner(System.in).nextLine(); //TODO bucle repetir hasta asterisco

            byte[] mensaje = new byte[1024];
            mensaje = cadena.getBytes();

            //Construyo el datagrama a enviar
            DatagramPacket datagramSend = new DatagramPacket(mensaje, mensaje.length, destino, port);
            DatagramSocket socketSend = new DatagramSocket(34567); //Local port
            socketSend.send(datagramSend);
            socketSend.close(); //Cerrar socket

            /*
            byte[] buffer = new byte[1024];
            DatagramSocket socketReceive = new DatagramSocket(port);
            DatagramPacket datagramReceive = new DatagramPacket(buffer, buffer.length);

            socketReceive.receive(datagramReceive);

            String cadenaRecibida = new String(datagramReceive.getData());

            System.out.println("Recibido: " + cadenaRecibida);

            //Cerrar recursos
            socketReceive.close();
            */

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
