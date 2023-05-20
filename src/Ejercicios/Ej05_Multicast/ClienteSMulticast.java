package Ejercicios.Ej05_Multicast;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteSMulticast {
    public static void main(String[] args) throws IOException {
        int puerto = 12345;
        MulticastSocket mcs = new MulticastSocket(puerto);
        InetAddress grupo = InetAddress.getByName("225.0.0.1");
        SocketAddress socket = new InetSocketAddress(grupo, puerto);
        mcs.joinGroup(socket, NetworkInterface.getByInetAddress(grupo));

        String msg = "";
        byte[] buffer = new byte[1024];

        System.out.println("Cómo es tu nombre?");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        DatagramPacket packetNombre = new DatagramPacket(buffer, buffer.length);
        mcs.send(packetNombre);

        buffer = new byte[1024];

        while (!msg.trim().equals("*")){
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            mcs.receive(packet);
            msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Recbido: " + msg.trim());
        }

        mcs.leaveGroup(socket, NetworkInterface.getByInetAddress(grupo));
        mcs.close();
        System.out.println("Cerrando socket");

    }
}
