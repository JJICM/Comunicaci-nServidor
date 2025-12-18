package es.etg.psp.servidor;

public class Calculadora {

    public static int calcular(String operador, int n1, int n2) {
        int resultado = switch (operador) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            case "!" -> calcularFactorial(n1);
            default -> 0;
        };
        return resultado;
    }

    public static int calcular(String operador, String n1, String n2) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        return calcular(operador, num1, num2);
    }

    public static int calcularFactorial(int n) {
        int resultado = n;
        for (int i = n - 1; i > 0; i--) {
            resultado = resultado * i;
        }
        return resultado;
    }

}
