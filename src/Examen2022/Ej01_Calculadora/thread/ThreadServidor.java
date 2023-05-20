package Examen2022.Ej01_Calculadora.thread;

import Examen2022.Ej01_Calculadora.model.Operaciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadServidor extends Thread {
    private Socket clientSocket;
    public ThreadServidor(String name, Socket clientSocket) {
        super(name);
        this.clientSocket = clientSocket;
    }

    public void run(){
        try (
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())
        ){
            String operation = dis.readUTF();
            double value1 = dis.readDouble();
            double value2 = dis.readDouble();

            System.out.println("Operación recibida: " + operation + ", valor1: " + value1 + ", valor2: " + value2);

            dos.writeDouble(calcular(operation, value1, value2));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private double calcular(String operation, double value1, double value2){
        double result = 0;

        switch (operation){
            case Operaciones.SUMA -> result = value1 + value2;
            case Operaciones.RESTA -> result = value1 - value2;
            case Operaciones.MULTIPLICACION -> result = value1 * value2;
            case Operaciones.DIVISION -> result = value1 / value2;
        }

        return result;
    }


}
