package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    public double pedirValorImovel() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o valor do imóvel (R$): ");
                double valor = scanner.nextDouble();

                if (valor > 10000) {
                    return valor;
                }

                System.out.println("\u001B[31mVALOR INFORMADO ABAIXO DO MÍNIMO! TENTE NOVAMENTE!\u001B[0m");
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mVALOR INFORMADO INVÁLIDO! TENTE NOVAMENTE!\u001B[0m");
                scanner.next();
            }
        }
    }

    public int pedirPrazoFinancimento() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                int prazo = scanner.nextInt();

                if (prazo >= 5 && prazo <= 45) {
                    return prazo;
                }

                System.out.println("\u001B[31mPRAZO INFORMADO ABAIXO DO MÍNIMO OU ACIMA DO MÁXIMO! TENTE NOVAMENTE!\u001B[0m");
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mPRAZO INFORMADO INVÁLIDO! TENTE NOVAMENTE!\u001B[0m");
                scanner.next();
            }
        }
    }

    public double pedirTaxaJuros() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o valor da taxa de juros anual (%): ");
                double taxaJuros = scanner.nextDouble();

                if (taxaJuros > 0 && taxaJuros < 100) {
                    return taxaJuros;
                }

                System.out.println("\u001B[31mTAXA INFORMADA MUITA ALTA OU NEGATIVA! TENTE NOVAMENTE!\u001B[0m");
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mTAXA INFORMADA INVÁLIDA! TENTE NOVAMENTE!\u001B[0m");
                scanner.next();
            }
        }
    }

    public double pedirAreaTerreno(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o valor da área do TERRENO (m²): ");
                double areaTerreno = scanner.nextDouble();

                if (areaTerreno > 0) {
                    return areaTerreno;
                }

                System.out.println("\u001B[31mÁREA INFORMADA NEGATIVA! TENTE NOVAMENTE!\u001B[0m");
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mÁREA INFORMADA INVÁLIDA! TENTE NOVAMENTE!\u001B[0m");
                scanner.next();
            }
        }
    }

    public double pedirAreaConstruida(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o valor da área CONSTRUÍDA (m²): ");
                double areaConstruida = scanner.nextDouble();

                if (areaConstruida > 0) {
                    return areaConstruida;
                }

                System.out.println("\u001B[31mÁREA INFORMADA NEGATIVA! TENTE NOVAMENTE!\u001B[0m");
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mÁREA INFORMADA INVÁLIDA! TENTE NOVAMENTE!\u001B[0m");
                scanner.next();
            }
        }
    }

    public int pedirNumeroVagasGaragem(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o número de vagas na garagem: ");
                int numeroVagasGaragem = scanner.nextInt();

                if (numeroVagasGaragem >= 0) {
                    return numeroVagasGaragem;
                }

                System.out.println("\u001B[31mNÚMERO DE VAGAS NEGATIVO! TENTE NOVAMENTE!\u001B[0m");
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mNÚMERO DE VAGAS INVÁLIDO! TENTE NOVAMENTE!\u001B[0m");
                scanner.next();
            }
        }
    }

    public int pedirNumeroAndar(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o número do andar do apartamento: ");
                int numeroAndar = scanner.nextInt();

                if (numeroAndar >= 0 && numeroAndar <= 163) {
                    return numeroAndar;
                }

                System.out.println("\u001B[31mNÚMERO DO ANDAR NEGATIVO OU ACIMA DO MÁXIMO! TENTE NOVAMENTE!\u001B[0m");
            } catch (InputMismatchException e) {
                System.out.println("\u001B[31mNÚMERO DO ANDAR INVÁLIDO! TENTE NOVAMENTE!\u001B[0m");
                scanner.next();
            }
        }
    }

    /* O método lança uma exceção sempre que o usuário deixa a entrada em branco, ou com algum número, dados estes que
       não correspondem com a natureza das solicitações. */
    public String pedirTipoDeZona(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.print("Digite o tipo de zona do imóvel (ex: residencial): ");
                String tipoDeZona = scanner.nextLine().strip();

                if (tipoDeZona.isEmpty() || !tipoDeZona.matches("[\\p{L}]+")) {
                    throw new EntradaDeZonaInvalidaException("\u001B[31mTIPO DE ZONA INVÁLIDA! TENTE NOVAMENTE!\u001B[0m");
                }

                return tipoDeZona;

            } catch (EntradaDeZonaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /* Método criado para tornar o programa visualmente agradável, adicionando pausas entre as impressões de informações
       na tela.  */
    public static void sleep(int milissegundos){
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}