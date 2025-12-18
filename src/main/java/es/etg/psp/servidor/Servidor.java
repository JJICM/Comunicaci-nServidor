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
                Conexion conexion = new Conexion(cliente);
                String operador = conexion.leer();
                String n1 = conexion.leer();
                String n2 = conexion.leer();
                int resultado = Calculadora.calcular(operador, n1, n2);
                conexion.escribir(String.valueOf(resultado));
                cliente.close();
            }
        } catch (IOException e) {
            System.err.println("Error de entrada y salida: %s".formatted(e.getMessage()));
        }

    }
}