package modelo;

public class Terreno extends Financiamento {
    // Atributos
    private String tipoDeZona;


    // Construtor
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoDeZona){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }

    // Getters
    public String getTipoDeZona(){
        return this.tipoDeZona;
    }

    // Métodos
    @Override
    public double calcularPagamentoMensal() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + ((getTaxaJurosAnual() / 100) / 12)) * 1.02;
    }

    @Override
    public void imprimirDadosFinanciamento() {
        System.out.println(" | Terreno: ");
        System.out.printf("Valor do Imóvel: R$%.2f\n", getValorImovel());
        System.out.printf("Valor Total do Financiamento: R$%.2f\n", calcularTotalPagamento());
        System.out.printf("Pagamento Mensal: R$%.2f\n", calcularPagamentoMensal());
        System.out.println("Prazo do Financiamento: " + getPrazoFinanciamento() + " anos.");
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%");
        System.out.printf("Tipo de Zona: %s\n", getTipoDeZona());
    }

    @Override
    public String toString(){
        StringBuilder terreno = new StringBuilder();
        terreno.append(" | Terreno: \n");
        terreno.append(String.format("Valor do Imóvel: R$%.2f\n", getValorImovel()));
        terreno.append(String.format("Valor Total do Financiamento: R$%.2f\n", calcularTotalPagamento()));
        terreno.append(String.format("Pagamento Mensal: R$%.2f\n", calcularPagamentoMensal()));
        terreno.append("Prazo do Financiamento: " + getPrazoFinanciamento() + " anos.\n");
        terreno.append("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%\n");
        terreno.append("Tipo de Zona: " + getTipoDeZona() + " \n");

        return terreno.toString();
    }
}
