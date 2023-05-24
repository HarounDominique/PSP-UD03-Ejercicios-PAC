package Boletines.Boletin2.EjProfesorDomi;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int port = 6000;
        String host = "localhost";

        try(Socket clientSocket = new Socket(host, port)){

            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Introduce el id del profesor que quieres recuperar:");
            String profeId = scan.nextLine();
            dos.writeUTF(profeId);
            Profesor profe = (Profesor) ois.readObject();
            System.out.println(profe.toString());
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
