package es.etg.psp.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static final int PUERTO = 8888;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en " + PUERTO);

            while (true) {
                Socket cliente = server.accept();
                new Thread(new Tarea(cliente)).start();
            }
        } catch (IOException ioe) {
            System.err.println("Error de entrada y salida: %s".formatted(ioe.getMessage()));
        }

    }
}