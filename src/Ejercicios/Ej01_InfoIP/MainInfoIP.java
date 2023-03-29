package Ejercicios.Ej01_InfoIP;

import java.util.ArrayList;
import java.util.Scanner;

public class MainInfoIP {
    public static void main(String[] args) {
        /*
         * Pedir IP por teclado y mostrar info de la misma
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Introducza una url para mostrar su información:");
        String entrada = sc.nextLine();


        ArrayList<Integer> enteros = new ArrayList<>();

        enteros.add(1);
        enteros.add(2);

        for (Integer i : enteros){
            enteros.remove(i);
        }

        enteros.removeIf(enteros::remove);


    }
}
