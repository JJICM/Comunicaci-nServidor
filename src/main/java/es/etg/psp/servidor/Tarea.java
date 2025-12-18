package es.etg.psp.servidor;

import java.io.IOException;
import java.net.Socket;

import javax.management.RuntimeErrorException;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tarea implements Runnable {

    private Socket cliente;

    @Override
    public void run() {
        try {
            Conexion conexion = new Conexion(cliente);
            String operador = conexion.leer();
            String n1 = conexion.leer();
            String n2 = conexion.leer();
            int resultado = Calculadora.calcular(operador, n1, n2);
            conexion.escribir(String.valueOf(resultado));
            cliente.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe.getMessage());
        }
    }

}
