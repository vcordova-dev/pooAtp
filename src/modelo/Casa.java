package modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;
    ///Atributos específicos da subclasse
    private double tamAreaConstruida;
    private double tamTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double tamAreaConstruida, double tamTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tamAreaConstruida = tamAreaConstruida;
        this.tamTerreno = tamTerreno;
    }

    //Sobscrita do método
    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensal = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + ((getTaxaJurosAnual() / 100) / 12));
        return pagamentoMensal + 80;
    }

    public double getTamAreaConstruida() {
        return tamAreaConstruida;
    }

    public double getTamTerreno() {
        return tamTerreno;
    }
}
