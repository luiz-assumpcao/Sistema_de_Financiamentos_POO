package modelo;

import util.AcrescimoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    // Atributos
    private double areaTerreno;
    private double areaConstruida;


    // Construtor
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaTerreno, double areaConstruida){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaTerreno = areaTerreno;
        this.areaConstruida = areaConstruida;
    }

    // Getters
    public double getAreaTerreno(){
        return this.areaTerreno;
    }

    public double getAreaConstruida(){
        return this.areaConstruida;
    }

    // Métodos
    private void validarAcrescimoMaiorDoQueJuros(double valorAcrescimo, double valorJuros) throws AcrescimoMaiorDoQueJurosException{
        if (valorAcrescimo > valorJuros){
            throw new AcrescimoMaiorDoQueJurosException("O acréscimo do financiamento é maior do que o juros.");
        }
    }

    @Override
    public double calcularPagamentoMensal() {
        double valorJuros = (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + ((getTaxaJurosAnual() / 100) / 12)) - (getValorImovel() / (getPrazoFinanciamento() * 12));
        double valorAcrescimo = 80;

        try {
            validarAcrescimoMaiorDoQueJuros(valorAcrescimo, valorJuros);
        } catch (AcrescimoMaiorDoQueJurosException e) {
            valorAcrescimo = valorJuros;
        }

        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + ((getTaxaJurosAnual() / 100) / 12)) + valorAcrescimo;
    }


    @Override
    public void imprimirDadosFinanciamento(){
        System.out.println(" | Casa: ");
        System.out.printf("Valor do Imóvel: R$%.2f\n", getValorImovel());
        System.out.printf("Valor Total do Financiamento: R$%.2f\n", calcularTotalPagamento());
        System.out.printf("Pagamento Mensal: R$%.2f\n", calcularPagamentoMensal());
        System.out.println("Prazo do Financiamento: " + getPrazoFinanciamento() + " anos.");
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%");
        System.out.printf("Aréa do Terreno: %.1fm²\n", getAreaTerreno());
        System.out.printf("Aréa Construída: %.1fm²\n", getAreaConstruida());
    }

    @Override
    public String toString(){
        StringBuilder casa = new StringBuilder();
        casa.append(" | Casa: \n");
        casa.append(String.format("Valor do Imóvel: R$%.2f\n", getValorImovel()));
        casa.append(String.format("Valor Total do Financiamento: R$%.2f\n", calcularTotalPagamento()));
        casa.append(String.format("Pagamento Mensal: R$%.2f\n", calcularPagamentoMensal()));
        casa.append(String.format("Prazo do Financiamento: " + getPrazoFinanciamento() + " anos.\n"));
        casa.append("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%\n");
        casa.append(String.format("Aréa do Terreno: %.1fm²\n", getAreaTerreno()));
        casa.append(String.format("Aréa Construída: %.1fm²\n", getAreaConstruida()));

        return casa.toString();
    }
}
