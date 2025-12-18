package es.etg.psp.servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Conexion {

    private Socket cliente;

    public String leer() throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        return entrada.readLine();
    }

    public void escribir(String mensaje) throws IOException{
        BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(cliente.getOutputStream()));
        salida.write(mensaje);
        salida.flush();
    }

}
