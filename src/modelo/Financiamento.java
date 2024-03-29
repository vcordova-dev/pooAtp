package modelo;

public abstract class Financiamento {
    //Atributos da classe
    private final double valorImovel;
    private final int prazoFinanciamento;
    private final double taxaJurosAnual;

    //Método construto da classe
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    //Método abstrato
    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento(){
        double mesesPagamento = prazoFinanciamento * 12;
        return calcularPagamentoMensal() * mesesPagamento;
    }
    //Getters
    public double getValorImovel(){
        return this.valorImovel;
    }
    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

}
