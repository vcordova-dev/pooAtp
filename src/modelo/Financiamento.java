package modelo;

public abstract class Financiamento {
    //Atributos da classe
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //Método construto da classe
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    //Interface da classe com métodos públicos
    public abstract double calcularPagamentoMensal();
    public double calcularTotalPagamento(){
        double mesesPagamento = prazoFinanciamento * 12;
        double totalPagamento = calcularPagamentoMensal() * mesesPagamento;
        return totalPagamento;
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
