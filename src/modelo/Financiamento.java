package modelo;

import util.InterfaceUsuario;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Financiamento implements Serializable {

    // Atributos
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Getters
    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

    // Métodos
    public abstract double calcularPagamentoMensal();

    public abstract void imprimirDadosFinanciamento();

    public abstract String toString();

    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public static void imprimirTodosFinanciamentosDaLista(ArrayList<Financiamento> listaFinanciamentos){
        for (int i = 0; i < listaFinanciamentos.size(); i++ ){
            System.out.println("\u001B[34m---------------------------------------------\u001B[0m");
            System.out.print((i + 1) + "º Financiamento");
            listaFinanciamentos.get(i).imprimirDadosFinanciamento();
            InterfaceUsuario.sleep(500);
        }
    }

    public static void imprimirSomaTotalDosFinanciamentosDaLista(ArrayList<Financiamento> listaFinanciamentos){
        double totalTodosImoveis = 0;
        double totalTodosFinanciamentos = 0;

        // Calcula o Total de todos os imóveis e financiamentos.
        for (Financiamento financiamento : listaFinanciamentos){
            totalTodosImoveis += financiamento.getValorImovel();
            totalTodosFinanciamentos += financiamento.calcularTotalPagamento();
        }

        // Imprime o Total de todos os imóveis e financiamentos.
        System.out.println("\u001B[34m---------------------------------------------\u001B[0m");
        System.out.println("Total: ");
        System.out.println("\u001B[34m---------------------------------------------\u001B[0m");
        System.out.printf("Total dos Imóveis: R$%.2f\n", totalTodosImoveis );
        System.out.printf("Total dos Financiamentos: R$%.2f\n", totalTodosFinanciamentos );
        System.out.println("\u001B[34m---------------------------------------------\u001B[0m");
    }


}