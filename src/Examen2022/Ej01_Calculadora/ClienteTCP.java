package Examen2022.Ej01_Calculadora;

import Examen2022.Ej01_Calculadora.model.Calculo;
import Examen2022.Ej01_Calculadora.model.TipoOperacion;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
            int option = menu();
            int valor1 = seleccionValor(1);
            int valor2 = seleccionValor(2);

            Calculo calculation = new Calculo();
            switch (option) {
                case 1 -> calculation = new Calculo(TipoOperacion.SUMA, valor1, valor2);
                case 2 -> calculation = new Calculo(TipoOperacion.RESTA, valor1, valor2);
                case 3 -> calculation = new Calculo(TipoOperacion.MULTIPLICACIÓN, valor1, valor2);
                case 4 -> calculation = new Calculo(TipoOperacion.DIVISIÓN, valor1, valor2);
                case 5 -> {}
            }

            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(calculation);

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            System.out.println("El resultado de la operación es: " + Integer.parseInt(dis.readUTF()));

            oos.close();
            dis.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int menu(){
        System.out.println("Seleccione una operación:");
        System.out.println("1 -- Sumar");
        System.out.println("2 -- Restar");
        System.out.println("3 -- Multiplicar");
        System.out.println("4 -- Dividir");
        System.out.println("5 -- Salir");
        return Integer.parseInt(sc.nextLine());
    }

    private static int seleccionValor(int index){
        System.out.printf("Introduzca el valor %d:\n", index);
        return Integer.parseInt(sc.nextLine());
    }
}
