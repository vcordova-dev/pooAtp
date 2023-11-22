package util;

import java.util.Scanner;

public class InterfaceUsuario {
    //Interface da classe com métodos públicos
    public static double entradaValorImovel(){
        Scanner scanner = new Scanner(System.in);
        double valorImovel;
        do {
            System.out.print("Digite o valor do imóvel: ");
            valorImovel = scanner.nextDouble();
        } while (valorImovel <= 0);
        return valorImovel;
    }

    public static int entradaPrazoFinanciamento(){
        Scanner scanner = new Scanner(System.in);
        int prazoFinanciamento;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazoFinanciamento = scanner.nextInt();
        } while (prazoFinanciamento <= 0);
        return prazoFinanciamento;
    }

    public static double entradaTaxaJuros(){
        Scanner scanner = new Scanner(System.in);
        double taxaJurosAnual;
        do {
            System.out.print("Digite a taxa de juros anual (em %): ");
            taxaJurosAnual = scanner.nextDouble();
            if (taxaJurosAnual > 1000) {
                System.out.println("A taxa de juros não pode ser maior que 1000%.");
            }
        } while (taxaJurosAnual <= 0 || taxaJurosAnual >1000);
        return taxaJurosAnual;
    }

    public static int escolherTipoImovel() {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        do {
            System.out.println("Escolha o tipo de imóvel:");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");
            System.out.print("Digite o número correspondente ao tipo de imóvel desejado: ");
            escolha = scanner.nextInt();
        } while (escolha < 1 || escolha > 3);
        return escolha;
    }
}
