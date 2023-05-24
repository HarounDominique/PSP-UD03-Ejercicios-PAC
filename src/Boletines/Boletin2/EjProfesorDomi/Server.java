package Boletines.Boletin2.EjProfesorDomi;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
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
    public static void main(String[] args) {

        ArrayList<Profesor> profesores = poblarProfesores();
        int port = 6000;
        int clientCounter=0;

        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true){
                System.out.println("Escuchando en el puerto 6000...");
                Socket clientSocket = serverSocket.accept();
                clientCounter++;
                System.out.println("Conectado cliente nº"+clientCounter);

                //abrimos un flujo de entrada de tipo data y un flujo de salida tipo object
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream()); //recibiremos un int id de cliente
                ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream()); //enviaremos un objeto Profesor

                int id = Integer.parseInt(dis.readUTF());
                System.out.println("Enviado datos de profesor con id: " + id + ".");
                Profesor profe = new Profesor();

                for(Profesor p : profesores){
                    if(p.getId() == id){
                        profe = p;
                    }
                }
                oos.writeObject(profe);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Profesor> poblarProfesores(){
        ArrayList<Profesor>profesores = new ArrayList<>();

        Asignatura matematicas = new Asignatura(1, "Matemáticas");
        Asignatura lengua = new Asignatura(2, "Lengua castellana");
        Asignatura historia = new Asignatura(3, "Historia");
        Asignatura filosofia = new Asignatura(4, "Filosofía");
        Asignatura educaciónFísica = new Asignatura(5, "Educación física");

        Especialidad ciencias = new Especialidad(1, "Ciencias");
        Especialidad letras = new Especialidad(2, "Letras");
        Especialidad sociales = new Especialidad(3, "Sociales");

        Profesor profesor1 = new Profesor(1, "Profesor 1");
        profesor1.setEspecialidad(letras);
        profesor1.setAsignaturas(new Asignatura[]{lengua, filosofia, historia});

        Profesor profesor2 = new Profesor(2, "Profesor 2");
        profesor2.setEspecialidad(ciencias);
        profesor2.setAsignaturas(new Asignatura[]{matematicas});

        Profesor profesor3 = new Profesor(3, "Profesor 3");
        profesor3.setEspecialidad(sociales);
        profesor3.setAsignaturas(new Asignatura[]{matematicas, historia});

        Profesor profesor4 = new Profesor(4, "Profesor 4");
        profesor4.setEspecialidad(ciencias);
        profesor4.setAsignaturas(new Asignatura[]{matematicas, educaciónFísica});

        Profesor profesor5 = new Profesor(5, "Profesor 5");
        profesor5.setEspecialidad(letras);
        profesor5.setAsignaturas(new Asignatura[]{historia});

        profesores.add(profesor1);
        profesores.add(profesor2);
        profesores.add(profesor3);
        profesores.add(profesor4);

        return profesores;
    }
}
