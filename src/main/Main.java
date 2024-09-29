package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;
import modelo.Financiamento;

import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        // Instancia um novo objeto da Classe Interface Usuario e cria um ArrayList de Financiamentos.
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();

        // Define o número de financiamentos que serão instanciados.
        int numeroCasas = 2;
        int numeroApartamentos = 2;
        int numeroTerrenos = 1;

        // Instancia novos financiamentos da subclasse Casa e armazena-os em um ArrayList.
        for (int i = 0; i < numeroCasas; i++) {
            System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
            System.out.println("\u001B[36m" + (listaDeFinanciamentos.size() + 1) + "º Financiamento | Casa: \u001B[0m");
            System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
            listaDeFinanciamentos.add(new Casa(interfaceUsuario.pedirValorImovel(), interfaceUsuario.pedirPrazoFinancimento(), interfaceUsuario.pedirTaxaJuros(), interfaceUsuario.pedirAreaTerreno(), interfaceUsuario.pedirAreaConstruida()));
        }

        // Instancia novos financiamentos da subclasse Apartamento e armazena-os em um ArrayList.
        for (int i = 0; i < numeroApartamentos; i++) {
            System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
            System.out.println("\u001B[36m" + (listaDeFinanciamentos.size() + 1) + "º Financiamento | Apartamento: \u001B[0m");
            System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
            listaDeFinanciamentos.add(new Apartamento(interfaceUsuario.pedirValorImovel(), interfaceUsuario.pedirPrazoFinancimento(), interfaceUsuario.pedirTaxaJuros(), interfaceUsuario.pedirNumeroVagasGaragem(), interfaceUsuario.pedirNumeroAndar()));
        }

        // Instancia novos financiamentos da subclasse Terreno e armazena-os em um ArrayList.
        for (int i = 0; i < numeroTerrenos; i++) {
            System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
            System.out.println("\u001B[36m" + (listaDeFinanciamentos.size() + 1) + "º Financiamento | Terreno: \u001B[0m");
            System.out.println("\u001B[32m---------------------------------------------\u001B[0m");
            listaDeFinanciamentos.add(new Terreno(interfaceUsuario.pedirValorImovel(), interfaceUsuario.pedirPrazoFinancimento(), interfaceUsuario.pedirTaxaJuros(), interfaceUsuario.pedirTipoDeZona()));
        }
        System.out.println();

         // Imprime os dados de todos os financiamentos contidos na lista.
        Financiamento.imprimirTodosFinanciamentosDaLista(listaDeFinanciamentos);

        // Imprime a soma total dos financiamentos
        Financiamento.imprimirSomaTotalDosFinanciamentosDaLista(listaDeFinanciamentos);

        // Escreve os dados dos financiamento em um arquivo de texto.
        FileWriter escritorArquivosTexto;
        try {
            escritorArquivosTexto = new FileWriter("dadosFinanciamentos.txt");
            for (Financiamento financiamento : listaDeFinanciamentos) {
                escritorArquivosTexto.write(financiamento.toString());
                escritorArquivosTexto.write("\n");
            }
            escritorArquivosTexto.flush();
            escritorArquivosTexto.close();
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Lê os dados em arquivo de texto para demonstrar a sua integridade.
        FileReader leitorArquivoTexto;
        try {
            leitorArquivoTexto = new FileReader("dadosFinanciamentos.txt");
            StringBuilder arquivoLido = new StringBuilder();
            int caractereLido;
            while ((caractereLido = leitorArquivoTexto.read()) != - 1){
                arquivoLido.append((char)caractereLido);
            }

            System.out.println("\n\u001B[33mImpressão dos dados lidos no arquivo de texto: \u001B[0m\n");
            InterfaceUsuario.sleep(2000);
            System.out.println(arquivoLido);

            leitorArquivoTexto.close();
        } catch (FileNotFoundException e) {
            System.out.println("O arquivo não foi encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Serialização dos financiamentos.
        ObjectOutputStream serializador = null;

        try {
            serializador = new ObjectOutputStream(new FileOutputStream("arquivo.arqv"));

            for (Financiamento financiamento : listaDeFinanciamentos) {
                serializador.writeObject(financiamento);
            }

            serializador.close();
            serializador.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Desserialização dos financiamentos.
        ObjectInputStream desserializador = null;
        ArrayList<Financiamento> listaDesserializada = new ArrayList<Financiamento>();

        try {
            desserializador = new ObjectInputStream(new FileInputStream("arquivo.arqv"));

            Object objeto = null;
            while ((objeto = desserializador.readObject()) != null){
                if (objeto instanceof Financiamento) {
                    Financiamento financiamentoDesserializado = ((Financiamento)objeto);
                    listaDesserializada.add(financiamentoDesserializado);
                }
            }

            desserializador.close();
        } catch (EOFException e ) {
            System.out.println("Fim da leitura dos arquivos serializados...");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Impressão dos dados desserializados.
        InterfaceUsuario.sleep(1000);
        System.out.println("\n\u001B[33mImpressão dos dados lidos no arquivo desserializado: \u001B[0m\n");
        InterfaceUsuario.sleep(2000);

            for (Financiamento financiamento : listaDesserializada){
                System.out.println(financiamento.toString());
            }
    }
}