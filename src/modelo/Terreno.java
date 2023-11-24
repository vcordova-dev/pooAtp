package modelo;

public class Terreno extends Financiamento{
    ///Atributos específicos da subclasse
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    //Sobscrita do método
    @Override
    public double calcularPagamentoMensal() {

        double pagamentoMensal = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + ((getTaxaJurosAnual() / 100) / 12));

        return pagamentoMensal * 1.02;
    }

    public String getTipoZona() {
        return tipoZona;
    }
}
