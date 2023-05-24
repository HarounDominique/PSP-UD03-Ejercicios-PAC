package Boletines.Boletin2.MayusculasDomiUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class MayusClientDomi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int serverPort = 6000;
        int localPort = 1234;
        String host = "localhost";

        try(DatagramSocket clientSocket = new DatagramSocket(localPort)){
            String line;
            do {
                System.out.println("Introduce una cadena de texto o '*' para salir:");
                line = scan.nextLine();

                byte[] outputBuffer = new byte[1024];
                //se emplea este constructor de datagram dado que se pretende ENVIAR el paquete, no recibirlo.
                DatagramPacket outputDatagram = new DatagramPacket(outputBuffer, outputBuffer.length, InetAddress.getByName(host), serverPort);
                clientSocket.send(outputDatagram);

                if(!line.equals("*")){

                    byte[] inputBuffer = new byte[1024];
                    DatagramPacket inputDatagram = new DatagramPacket(inputBuffer, inputBuffer.length);
                    clientSocket.receive(inputDatagram);
                    System.out.println("Recibido: "+inputDatagram.getData());

                }

            }while(!line.equals("*"));


        }catch (IOException e){
            e.getMessage();
        }


    }
}
