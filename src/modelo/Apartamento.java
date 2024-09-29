package modelo;

public class Apartamento extends Financiamento{
    // Atributos
    private int numeroVagasGaragem;
    private int numeroAndar;


    // Construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem, int numeroAndar){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    // Getters
    public int getNumeroVagasGaragem(){
        return this.numeroVagasGaragem;
    }

    public int getNumeroAndar(){
        return this.numeroAndar;
    }

    // Métodos
    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100) / 12;
        int mesesFinanciamento = getPrazoFinanciamento() * 12;

        return (getValorImovel() * taxaMensal * Math.pow(1 + taxaMensal, mesesFinanciamento)) / (Math.pow(1 + taxaMensal, mesesFinanciamento) - 1);
    }

    @Override
    public void imprimirDadosFinanciamento(){
        System.out.println(" | Apartamento: ");
        System.out.printf("Valor do Imóvel: R$%.2f\n", getValorImovel());
        System.out.printf("Valor Total do Financiamento: R$%.2f\n", calcularTotalPagamento());
        System.out.printf("Pagamento Mensal: R$%.2f\n", calcularPagamentoMensal());
        System.out.println("Prazo do Financiamento: " + getPrazoFinanciamento() + " anos.");
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%");
        System.out.printf("Número de Vagas na Garagem: %d\n", getNumeroVagasGaragem());
        System.out.printf("Número do Andar: %d\n", getNumeroAndar());
    }

    @Override
    public String toString(){
        StringBuilder apartamento = new StringBuilder();
        apartamento.append(" | Apartamento: \n");
        apartamento.append(String.format("Valor do Imóvel: R$%.2f\n", getValorImovel()));
        apartamento.append(String.format("Valor Total do Financiamento: R$%.2f\n", calcularTotalPagamento()));
        apartamento.append(String.format("Pagamento Mensal: R$%.2f\n", calcularPagamentoMensal()));
        apartamento.append("Prazo do Financiamento: " + getPrazoFinanciamento() + " anos.\n");
        apartamento.append("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%\n");
        apartamento.append(String.format("Número de Vagas na Garagem: %d\n", getNumeroVagasGaragem()));
        apartamento.append(String.format("Número do Andar: %d\n", getNumeroAndar()));

        return apartamento.toString();
    }
}
