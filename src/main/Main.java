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
        //Chamada aos métodos de entrada de dados.
        double valorImovel = InterfaceUsuario.entradaValorImovel();
        int prazoFinanciamento = InterfaceUsuario.entradaPrazoFinanciamento();
        double taxaJurosanual = InterfaceUsuario.entradaTaxaJuros();
        //Instanciação do classe Casa com o retorno dos métodos de entrada.
        Casa casa1 = new Casa(valorImovel,prazoFinanciamento,taxaJurosanual);
        financiamentos.add(casa1);
        //Instanciação hard code das classes
        Casa casa2 = new Casa(500000,10,10);
        financiamentos.add(casa2);
        Apartamento ap1 = new Apartamento(500000,10,10);
        financiamentos.add(ap1);
        Apartamento ap2 = new Apartamento(500000,10,10);
        financiamentos.add(ap2);
        Terreno terreno1 = new Terreno(500000,10,10);
        financiamentos.add(terreno1);
        // Calcule o valor total de todos os imóveis e financiamentos.
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        //Comando for que percorre a lista de financiamnetos e calcula o total.
        for (Financiamento financiamento : financiamentos) {
            totalImoveis += financiamento.getValorImovel();
            totalFinanciamentos += financiamento.calcularTotalPagamento();
        }
        // Percorre a lista de financiamentos e imprime o atributo de cada objeto dentro da lista
        System.out.println("Resumo dos Financiamentos:");
        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("Financiamento " + (i + 1) + " - Valor do Imóvel: R$" + String.format("%.2f", financiamentos.get(i).getValorImovel()) +
                    "\nParcelas Mensais de: R$:" + String.format("%.2f", financiamentos.get(i).calcularPagamentoMensal()) + "\nValor do Financiamento: R$" + String.format("%.2f", financiamentos.get(i).calcularTotalPagamento()));
        }
        //Soma de todos os imóveis e financiamentos.
        System.out.println("Total de todos os imóveis: R$" + String.format("%.2f", totalImoveis));
        System.out.println("Total de todos os financiamentos: R$" + String.format("%.2f", totalFinanciamentos));


    }
}