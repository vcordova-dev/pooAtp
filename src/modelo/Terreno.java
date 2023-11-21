package modelo;

public class Terreno extends Financiamento{
    //Método construtor da superclasse
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    //Sobscrita do método
    @Override
    public double calcularPagamentoMensal() {

        double pagamentoMensal = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + ((getTaxaJurosAnual() / 100) / 12));

        return pagamentoMensal * 1.02;
    }
}
