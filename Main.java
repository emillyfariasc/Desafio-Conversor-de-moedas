import java.util.Scanner;
import pacotesjava.ConversorDeMoedas;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        var menu ="| Código | País            | Nome da Moeda          |\n| ------ | --------------- | ---------------------- |\n| BRL    | Brasil          | Real                   |\n| AOA    | Angola          | Kwanza                 |\n| USD    | Estados Unidos  | Dólar Americano        |\n| EUR    | Alemanha        | Euro                   |\n| ERN    | Eritreia        | Nakfa                  |\n| MNT    | Mongólia        | Tugrik                 |\n| KPW    | Coreia do Norte | Won Norte-Coreano      |\n| BTN    | Butão           | Ngultrum               |\n| RON    | Romênia         | Leu Romeno             |\n| ILS    | Israel          | Novo Shekel Israelense |\n";
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== CONVERSOR DE MOEDAS ===");

        System.out.print("Digite o valor que deseja converter: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpa buffer

        System.out.print(menu);
        System.out.print("Digite o código da moeda de origem (ex: USD): ");
        String moedaOrigem = scanner.nextLine().toUpperCase();

        System.out.print("Digite o código da moeda de destino (ex: BRL): ");
        String moedaDestino = scanner.nextLine().toUpperCase();

        ConversorDeMoedas conversor = new ConversorDeMoedas();
        double resultado = conversor.converter(valor, moedaOrigem, moedaDestino);
        System.out.printf("Resultado: %.2f %s = %.2f %s\n", valor, moedaOrigem, resultado, moedaDestino);
    }
}

