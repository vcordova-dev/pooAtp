//Aluno: Vanderlei Sutil de Cordova
//Curso: Ads 2023
package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Array list para armazenamento dos objetos tipo Financiamento.
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Chama o método para escolher o tipo de imóvel
        int escolhaTipoImovel = InterfaceUsuario.escolherTipoImovel();

        // Chama os métodos de entrada de dados específicos para o tipo de imóvel escolhido
        double valorImovel = 0;
        int prazoFinanciamento = 0;
        double taxaJurosanual = 0;
        //Validação try catch da entrada de dados
        try {
            valorImovel = InterfaceUsuario.entradaValorImovel();
            prazoFinanciamento = InterfaceUsuario.entradaPrazoFinanciamento();
            taxaJurosanual = InterfaceUsuario.entradaTaxaJuros();
        } catch (Exception e) {
            System.out.println("Erro ao processar entrada de dados. Certifique-se de inserir valores válidos.");
            return; // Termina o programa em caso de erro
        }

        // Instancia o tipo de imóvel escolhido
        Financiamento financiamento;

        try {
            switch (escolhaTipoImovel) {
                case 1:
                    financiamento = new Casa(valorImovel, prazoFinanciamento, taxaJurosanual);
                    break;
                case 2:
                    financiamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosanual);
                    break;
                case 3:
                    financiamento = new Terreno(valorImovel, prazoFinanciamento, taxaJurosanual);
                    break;
                default:
                    throw new IllegalArgumentException("Opção de imóvel inválida");
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar instância do tipo de imóvel. Certifique-se de fornecer valores válidos.");
            return; // Termina o programa em caso de erro
        }


        // Adiciona o financiamento à lista
        financiamentos.add(financiamento);

        // Instanciação hard code de outras classes
        Casa casa2 = new Casa(500000, 10, 10);
        financiamentos.add(casa2);
        Apartamento ap1 = new Apartamento(500000, 10, 10);
        financiamentos.add(ap1);
        Apartamento ap2 = new Apartamento(500000, 10, 10);
        financiamentos.add(ap2);
        Terreno terreno1 = new Terreno(500000, 10, 10);
        financiamentos.add(terreno1);



        // Calcule o valor total de todos os imóveis e financiamentos.
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        //Comando for que percorre a lista de financiamnetos e calcula o total.
        for (Financiamento fin : financiamentos) {
            totalImoveis += fin.getValorImovel();
            totalFinanciamentos += fin.calcularTotalPagamento();
        }


        // Percorre a lista de financiamentos e imprime o atributo de cada objeto dentro da lista
        System.out.println("Resumo dos Financiamentos:");
        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("Financiamento " + (i + 1) + " - Valor do Imóvel: R$" + String.format("%.2f", financiamentos.get(i).getValorImovel()) +
                    "\nParcelas Mensais de: R$:" + String.format("%.2f", financiamentos.get(i).calcularPagamentoMensal()) + "\nValor do Financiamento: R$" + String.format("%.2f", financiamentos.get(i).calcularTotalPagamento()));
        }

        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("Financiamento " + (i + 1) + " - Tipo: " + InterfaceUsuario.getTipoFinanciamento(financiamentos.get(i)) +
                    "\nValor do Imóvel: R$" + String.format("%.2f", financiamentos.get(i).getValorImovel()) +
                    "\nParcelas Mensais de: R$:" + String.format("%.2f", financiamentos.get(i).calcularPagamentoMensal()) +
                    "\nValor do Financiamento: R$" + String.format("%.2f", financiamentos.get(i).calcularTotalPagamento()));
        }

        //Soma de todos os imóveis e financiamentos.
        System.out.println("Total de todos os imóveis: R$" + String.format("%.2f", totalImoveis));
        System.out.println("Total de todos os financiamentos: R$" + String.format("%.2f", totalFinanciamentos));


    }
}