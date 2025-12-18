package es.etg.psp.cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

    static final int PUERTO = 8888;
    static final String IP = "localhost";

    public static void main(String[] args) {

        try {
            Socket cliente = new Socket(IP, PUERTO);
            String operador = "+";
            String n1 = "1";
            String n2 = "2";
            OutputStream aux = cliente.getOutputStream();
            DataOutputStream output = new DataOutputStream(aux);
            output.writeUTF(operador);
            output.writeUTF(n1);
            output.writeUTF(n2);
            cliente.close();
        } catch (IOException ioe) {
            System.err.println("Error de entrada y salida: %s".formatted(ioe.getMessage()));
        }

    }
}
