package Ejercicios.Ej_Multicast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServidorMulticast {
    /*
     * Implementar un program que actúe como servidor multicast empleado sockets UDP.
     * Dicho servidor recogerá de teclado cadenas de texto qeu introducira el usuario por teclado y
     * las irá enviando a todos los clientes conectados al grupo multicast.
     *
     * El programa cliente solicitará al usuario su nombre y lo enviará al grupo, que indicará al resto de
     * usuarios quién se ha conectado. Cada cliente además recibirá todos los mensajes asignados al grupo.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MulticastSocket mcs = new MulticastSocket();
        int puerto = 12345;
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        String cadena = "";

        while (!cadena.trim().equals("*")){
            System.out.println("Datos a enviar al grupo");
            cadena = br.readLine();

            // Enviar al grupo
            DatagramPacket packet = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);

            mcs.send(packet);

            String msg = new String(packet.getData());
            System.out.println("Envío: " + msg.trim());

        }

        mcs.close();
        System.out.println("Socket cerrado.");
    }
}
