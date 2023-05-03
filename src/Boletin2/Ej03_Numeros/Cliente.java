package Boletin2.Ej03_Numeros;

import Boletin2.Ej01_Profesor.model.Profesor;
import Boletin2.Ej03_Numeros.model.Numero;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {

        String Host = "localhost";
        int puerto = 6000; //puerto remoto
        Socket cliente = null; //conecta

        Numero numero;

        do {
            System.out.println("Introduzca un número, -1 para terminar");

            numero = new Numero(new Scanner(System.in).nextInt());

            //ABRIR SOCKET
            cliente = new Socket(Host, puerto);

            ObjectInputStream dis = new ObjectInputStream(cliente.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            System.out.println("Enviando objeto: " + numero);
            oos.writeObject(numero);

            try {
                numero = (Numero) dis.readObject();
                System.out.println("Recibido objeto: " + numero);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            //Cerrar recursos
            cliente.close(); //Cierra el socket
            dis.close();
            oos.close();

        } while (numero.getNumero() > 0);

    }
}
