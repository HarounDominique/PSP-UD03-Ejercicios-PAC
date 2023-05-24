package Boletines.Boletin2.MayusculasDomiUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class MayusServidorUDP {
    /* Crea un programa cliente usando sockets UDP que envíe el texto escrito desde la entrada estándar al servidor.
     * El servidor le devolverá la cadena en mayúsculas.
     * El proceso de entrada de datos finalizará cuando el cliente introduzca un asterisco.
     * Crea un programa servidor que reciba cadenas de caracteres,
     * las muestre en pantalla y se las envíe al emisor en mayúscula.
     * El proceso servidor finalizará cuando reciba un asterisco.
     * Establece un tiempo de espera de 5000ms con el método setSoTimeout para hacer que el método receive()
     * del programa cliente se bloquee.
     * Pasado ese tiempo, controlar si no se reciben datos lanzando la excepción InterruptedIOException,
     * en cuyo caso visualiza un mensaje indicando que el paquete se ha perdido.
     */

    public static void main(String[] args) {
        int serverPort = 6000;

        try(DatagramSocket serverSocket = new DatagramSocket(serverPort)){

            String line;

            do{
                System.out.println("A la espera de datagramas...");

                byte[] inputBuffer = new byte[1024];
                DatagramPacket inputDatagram = new DatagramPacket(inputBuffer, inputBuffer.length);

                serverSocket.receive(inputDatagram);

                line = new String(inputDatagram.getData()).trim();

                if(!line.equals("*")){
                    System.out.println("Datagrama recibido: "+line);
                }

            }while(line.equals("*"));

        }catch (SocketException e){
            e.getStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
