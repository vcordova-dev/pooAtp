package modelo;

public class Apartamento extends Financiamento{
    //Atributos específicos da subclasse
    private int numVagas = 0;
    private int numAndar;
    private double aptTaxaMensal = (getTaxaJurosAnual() / 12) / 100;
    private double aptMeses = getPrazoFinanciamento() * 12;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numVagas, int numAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numVagas = numVagas;
        this.numAndar = numAndar;
    }

    //Sobscrita do método
    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = ((getValorImovel() * aptTaxaMensal) * (Math.pow((1 + aptTaxaMensal), (aptMeses)))) / (Math.pow((1 + aptTaxaMensal), aptMeses) - 1);
        return pagamentoMensal;

    }
}
