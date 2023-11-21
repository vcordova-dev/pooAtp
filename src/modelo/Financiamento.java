package modelo;

public class Financiamento {
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
    public double calcularPagamentoMensal() {
        double pagamentoMensal = (valorImovel / (prazoFinanciamento * 12)) * (1 + ((taxaJurosAnual / 100) / 12));
        return pagamentoMensal;
    }
    public double calcularTotalPagamento(){
        double mesesPagamento = prazoFinanciamento * 12;
        double totalPagamento = calcularPagamentoMensal() * mesesPagamento;
        return totalPagamento;
    }
    //Getters
    public double getValorImovel(){
        return valorImovel;
    }
    public int getPrazoFinanciamento(){
        return prazoFinanciamento;
    }
    public double getTaxaJurosAnual(){
        return taxaJurosAnual;
    }

}
