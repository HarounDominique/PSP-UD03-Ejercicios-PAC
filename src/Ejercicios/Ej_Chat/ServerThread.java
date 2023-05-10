package Ejercicios.Ej_Chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {
    private DataInputStream dis;
    private Socket socket = null;
    public ServerThread(Socket socket){
        super();
        this.socket = socket;

        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.err.println("I/O Error");
            e.printStackTrace();
        }
    }

    public void run() {
        while(true) {
            String string = "";
            try {
                string = dis.readUTF();

                if (string.trim().equals("*")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
