package Boletin2.Ej01_Profesor;

import Boletin2.Ej01_Profesor.model.Asignatura;
import Boletin2.Ej01_Profesor.model.Especialidad;
import Boletin2.Ej01_Profesor.model.Profesor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorTCP {
    /*
     * Un profesor podrá impartir hasta 3 asignaturas.
     * Utilizando sockets TCP, implementar un programa servidor que inicialice un array de 5 objetosde tipo Profesor.
     * El servidor aceptará conexiones de clientes en un bucle infinito.
     * Cada vez que se conecte un cliente, el servidor le asignará un id,
     * que empezará en 1 e irá incrementándose cada vez que se conecta un nuevo cliente.
     * El servidor recibirá del cliente un idProfesor y le devolverá el objeto Profesor asociado.
     * Crea un programa cliente en el que se introduzca por teclado el idProfesor que se desea consultar.
     * Dicho programa recogerá datos hasta recibir un * por parte del usuario.
     * Si el idProfesor no se encuentra registrado, el servidor le devolverá un objeto Profesor con datos vacíos.
     */
    public static void main(String[] args) throws IOException {

        ArrayList<Profesor> profesores = generarProfesores();

        while (true) {
            int puerto = 6000;// Puerto
            ServerSocket servidor = new ServerSocket(puerto);
            System.out.println("Escuchando en " + servidor.getLocalPort());

            System.out.println("Esperando cliente...");
            Socket cliente = servidor.accept();//esperando a un cliente
            System.out.println("Puerto del cliente, getLocalPort(): " + cliente.getLocalPort());
            System.out.println("Puerto del cliente, getPort(): " + cliente.getPort());

            DataInputStream isr = new DataInputStream(cliente.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            String cadena = isr.readUTF();
            try {
                if (!cadena.equals("*")) {
                    long idProfesor = Long.parseLong(cadena);
                    System.out.println("Recibido id: " + idProfesor);

                    Profesor profesor;

                    for (Profesor p : profesores) {
                        if (p.getIdProfesor() == idProfesor) {
                            profesor = p;
                            oos.writeObject(profesor);
                            oos.flush();
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }

            servidor.close(); //Cerrar socket servidor
        }
    }

    private static ArrayList<Profesor> generarProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        profesores.add(new Profesor(0, "Profesor 1"));
        profesores.add(new Profesor(1, "Profesor 2"));
        profesores.add(new Profesor(2, "Profesor 3"));
        profesores.add(new Profesor(3, "Profesor 4"));
        profesores.add(new Profesor(4, "Profesor 5"));

        Asignatura matematicas = new Asignatura(0, "Matemáticas");
        Asignatura lengua = new Asignatura(1, "Lengua castellana");
        Asignatura ingles = new Asignatura(2, "Inglés");
        Asignatura educacionFisica = new Asignatura(3, "Educación física");
        Asignatura filosofia = new Asignatura(4, "Filosofía");

        profesores.get(0).getAsignaturas().add(matematicas);
        profesores.get(0).getAsignaturas().add(ingles);
        profesores.get(0).getAsignaturas().add(lengua);

        profesores.get(1).getAsignaturas().add(filosofia);
        profesores.get(1).getAsignaturas().add(educacionFisica);


        profesores.get(2).getAsignaturas().add(ingles);

        profesores.get(3).getAsignaturas().add(matematicas);

        profesores.get(4).getAsignaturas().add(filosofia);

        Especialidad especialidad1 = new Especialidad(0, "Especialidad 1");
        Especialidad especialidad2 = new Especialidad(1, "Especialidad 2");
        Especialidad especialidad3 = new Especialidad(2, "Especialidad 3");
        Especialidad especialidad4 = new Especialidad(3, "Especialidad 4");
        Especialidad especialidad5 = new Especialidad(4, "Especialidad 5");

        profesores.get(0).setEspecialidad(especialidad1);
        profesores.get(1).setEspecialidad(especialidad2);
        profesores.get(2).setEspecialidad(especialidad3);
        profesores.get(3).setEspecialidad(especialidad4);
        profesores.get(4).setEspecialidad(especialidad5);

        return profesores;
    }
}
