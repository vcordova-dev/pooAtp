package modelo;

public class Apartamento extends Financiamento{
    //Método construtor da superclasse
    private double aptTaxaMensal = (getTaxaJurosAnual() / 12) / 100;
    private double aptMeses = getPrazoFinanciamento() * 12;
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    //Sobscrita do método
    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = ((getValorImovel() * aptTaxaMensal) * (Math.pow((1 + aptTaxaMensal), (aptMeses)))) / (Math.pow((1 + aptTaxaMensal), aptMeses) - 1);
        return pagamentoMensal;

    }
}
