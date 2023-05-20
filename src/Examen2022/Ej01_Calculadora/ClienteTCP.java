package Examen2022.Ej01_Calculadora;

import Examen2022.Ej01_Calculadora.model.Operaciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteTCP {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "localhost";
        int serverPort = 6000;

        try (
                Socket clientSocket = new Socket(host, serverPort)
        ){
            String operation = menu();
            double valor1 = seleccionValor(1);
            double valor2 = seleccionValor(2);


            System.out.println("Enviando: " + operation + ", valor1: " + valor1 + ", valor2: " + valor2);
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            dos.writeUTF(operation);
            dos.writeDouble(valor1);
            dos.writeDouble(valor2);

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            System.out.println("El resultado de la operación es: " + dis.readDouble());

            dos.close();
            dis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String menu(){
        System.out.println("Seleccione una operación:");
        System.out.println("1 -- Sumar");
        System.out.println("2 -- Restar");
        System.out.println("3 -- Multiplicar");
        System.out.println("4 -- Dividir");
        System.out.println("5 -- Salir");


        return switch (Integer.parseInt(sc.nextLine())) {
            case 1 -> Operaciones.SUMA;
            case 2 -> Operaciones.RESTA;
            case 3 -> Operaciones.MULTIPLICACION;
            case 4 -> Operaciones.DIVISION;
            default -> "";
        };
    }

    private static double seleccionValor(int index){
        System.out.printf("Introduzca el valor %d:\n", index);
        return Double.parseDouble(sc.nextLine());
    }
}
