package modelo;

public class Casa extends Financiamento{
    // Método construtor da superclase
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    //Sobscrita do método
    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + ((getTaxaJurosAnual() / 100) / 12));
        return pagamentoMensal + 80;
    }
}
