package Examen2022.Ej01_Calculadora;

import Examen2022.Ej01_Calculadora.thread.ThreadServidor;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorTCP {
    /* Realiza un programa cliente-servidor que implemente una calculadora (suma, resta, multiplicación y división).
     * El servidor ha de poder atender a múltiples clientes simultáneamente.
     * El programa servidor creará un stream socket y aguardará conexiones.
     * El programa cliente recogerá de teclado la operación a realizar y los operandos,
     * y se los enviará al servidor para que la resuelva.
     * A continuación, leerá la respuesta del servidor y la mostrará por pantalla.
     */
    public static void main(String[] args) {
        int connectionCount = 0;
        int serverPort = 6000;
        try (
                ServerSocket serverSocket = new ServerSocket(serverPort)
        ) {
            while(true) {
                System.out.println("Esperando conexiones...");

                ThreadServidor serverThread = new ThreadServidor("Hilo " + ++connectionCount, serverSocket.accept());
                serverThread.run();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
