package Examen2022.Ej01_Calculadora.thread;

import Examen2022.Ej01_Calculadora.model.Calculo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ThreadServidor extends Thread {
    private Socket clientSocket;
    public ThreadServidor(String name, Socket clientSocket) {
        super(name);
        this.clientSocket = clientSocket;
    }

    public void run(){
        try (
                ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream())
        ){
            try {
                Calculo calculo = (Calculo) ois.readObject();
                System.out.println("Operación recibida: " + calculo.getOperacion() + ", valor1: " + calculo.getValor1() + ", valor2: " + calculo.getValor2());

                dos.writeUTF(Integer.toString(calculo.calcular()));

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
