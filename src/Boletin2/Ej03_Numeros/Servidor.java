package Boletin2.Ej03_Numeros;

import Boletin2.Ej01_Profesor.model.Profesor;
import Boletin2.Ej03_Numeros.model.Numero;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int puerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en " + servidor.getLocalPort());

        System.out.println("Esperando cliente...");
        Socket cliente = servidor.accept();//esperando a un cliente
        System.out.println("Puerto del cliente, getLocalPort(): " + cliente.getLocalPort());
        System.out.println("Puerto del cliente, getPort(): " + cliente.getPort());
        ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

        while (true) {

            Numero numero = (Numero) ois.readObject();
            System.out.println("Recibido objeto: " + numero);
            System.out.println("Realizando cálculos...");

            numero.calcularCuadrado();
            numero.calcularCubo();

            oos.writeObject(numero);

            System.out.println("Enviando objeto: " + numero);
        }
    }
}