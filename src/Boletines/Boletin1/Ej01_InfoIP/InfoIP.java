package Boletines.Boletin1.Ej01_InfoIP;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class InfoIP {
    /*
     * Realiza un programa Java que admita desde consola nombres de máquinas o direcciones IP y
     * vaya mostrando por pantalla información sobre ellas, haciendo uso de la clase InetAddress.
     */
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca una IP o nombre de equipo para obtener su información");

        String host;

        while(!(host = sc.nextLine()).equals("*")) {
            InetAddress dir = InetAddress.getByName(host);
            System.out.println("Host name: " + dir.getHostName());
            System.out.println("Host address: " + dir.getHostAddress());
            System.out.println("Canonical hostname: " + dir.getCanonicalHostName());
            System.out.println("Introduzca otro nombre o dirección, * para salir");
        }
    }
}
