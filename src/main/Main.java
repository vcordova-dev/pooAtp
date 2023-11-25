//Aluno: Vanderlei Sutil de Cordova
//Curso: Ads 2023
package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Array list para armazenamento dos objetos tipo Financiamento.
        ArrayList<Financiamento> financiamentos = new ArrayList<>();
        // Variável que armazena o retorno do método para obter o tipo do Financiamento.
        int escolhaTipoImovel = InterfaceUsuario.escolherTipoImovel();
        // Atributos comuns ente as subclasses
        double valorImovel;
        int prazoFinanciamento;
        double taxaJurosanual;
        // Atributos específicos de cada subclasse
        int numVagas;
        int numAndar;
        double tamAreaConstruida;
        double tamTerreno;
        String tipoZona;

        //Validação try catch da entrada de dados dos atributos comuns
        try {
            valorImovel = InterfaceUsuario.entradaValorImovel();
            prazoFinanciamento = InterfaceUsuario.entradaPrazoFinanciamento();
            taxaJurosanual = InterfaceUsuario.entradaTaxaJuros();
        } catch (Exception e) {
            System.out.println("Erro ao processar entrada de dados. Certifique-se de inserir valores válidos.");
            return; // Termina o programa em caso de erro
        }

        // Declara uma variável do tipo Financiamento
        Financiamento financiamento;

        try {
            switch (escolhaTipoImovel) {
                case 1:
                    tamAreaConstruida = InterfaceUsuario.entradaAreaConstruida();
                    tamTerreno = InterfaceUsuario.entradaTamanhoTerreno();
                    financiamento = new Casa(valorImovel, prazoFinanciamento, taxaJurosanual,tamAreaConstruida,tamTerreno);
                    break;
                case 2:
                    numVagas = InterfaceUsuario.entradaNumeroVagas();
                    numAndar = InterfaceUsuario.entradaNumeroAndar();
                    financiamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosanual,numVagas,numAndar);
                    break;
                case 3:
                    tipoZona = InterfaceUsuario.entradaTipoZonaConstruida();
                    financiamento = new Terreno(valorImovel, prazoFinanciamento, taxaJurosanual,tipoZona);
                    break;
                default:
                    throw new IllegalArgumentException("Opção de imóvel inválida");
            }
        } catch (Exception e) {
            System.out.println("Erro ao criar instância do tipo de imóvel. Certifique-se de fornecer valores válidos.");
            return; // Termina o programa em caso de erro
        }

        // Adiciona o financiamento à lista
        financiamentos.add(financiamento);

        // Instanciação hard code de outras classes
        Casa casa2 = new Casa(500000, 10, 10,40,50);
        financiamentos.add(casa2);
        Apartamento ap1 = new Apartamento(500000, 10, 10,2,20);
        financiamentos.add(ap1);
        Apartamento ap2 = new Apartamento(500000, 10, 10,2,20);
        financiamentos.add(ap2);
        Terreno terreno1 = new Terreno(500000, 10, 10,"Residencial");
        financiamentos.add(terreno1);


        // Calcule o valor total de todos os imóveis e financiamentos.
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        //Comando for que percorre a lista de financiamnetos e calcula o total.
        for (Financiamento fin : financiamentos) {
            totalImoveis += fin.getValorImovel();
            totalFinanciamentos += fin.calcularTotalPagamento();
        }


        // Percorre a lista de financiamentos e imprime o atributo de cada objeto dentro da lista
        System.out.println("Resumo dos Financiamentos:");
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento fin = financiamentos.get(i);
            System.out.println("Financiamento " + (i + 1) + " - Tipo: " + InterfaceUsuario.getTipoFinanciamento(financiamentos.get(i)) +
                    "\nValor do Imóvel: R$" + String.format("%.2f", financiamentos.get(i).getValorImovel()) +
                    "\nParcelas Mensais de: R$:" + String.format("%.2f", financiamentos.get(i).calcularPagamentoMensal()) +
                    "\nValor do Financiamento: R$" + String.format("%.2f", financiamentos.get(i).calcularTotalPagamento()));

            if (fin instanceof Casa) {
                Casa casa = (Casa) fin;
                System.out.println("Área Construída: " + casa.getTamAreaConstruida() +
                        "\nTamanho do Terreno: " + casa.getTamTerreno());
            } else if (fin instanceof Apartamento) {
                Apartamento ap = (Apartamento) fin;
                System.out.println("Número de Vagas: " + ap.getNumVagas() +
                        "\nNúmero de Andares: " + ap.getNumAndar());
            } else if (fin instanceof Terreno) {
                Terreno terreno = (Terreno) fin;
                System.out.println("Tipo de Zona: " + terreno.getTipoZona());
            }

        }

        StringBuilder resumo = new StringBuilder("Resumo dos Financiamentos:\n");

        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento fin = financiamentos.get(i);

            resumo.append("Financiamento ").append(i + 1).append(" - Tipo: ").append(InterfaceUsuario.getTipoFinanciamento(fin))
                    .append("\nValor do Imóvel: R$").append(String.format("%.2f", fin.getValorImovel()))
                    .append("\nParcelas Mensais de: R$:").append(String.format("%.2f", fin.calcularPagamentoMensal()))
                    .append("\nValor do Financiamento: R$").append(String.format("%.2f", fin.calcularTotalPagamento()));

            if (fin instanceof Casa) {
                Casa casa = (Casa) fin;
                resumo.append("\nÁrea Construída: ").append(casa.getTamAreaConstruida())
                        .append("\nTamanho do Terreno: ").append(casa.getTamTerreno());
            } else if (fin instanceof Apartamento) {
                Apartamento ap = (Apartamento) fin;
                resumo.append("\nNúmero de Vagas: ").append(ap.getNumVagas())
                        .append("\nNúmero de Andares: ").append(ap.getNumAndar());
            } else if (fin instanceof Terreno) {
                Terreno terreno = (Terreno) fin;
                resumo.append("\nTipo de Zona: ").append(terreno.getTipoZona());
            }

            resumo.append("\n\n");
        }
        //Soma de todos os imóveis e financiamentos.
        System.out.println("Total de todos os imóveis: R$" + String.format("%.2f", totalImoveis));
        System.out.println("Total de todos os financiamentos: R$" + String.format("%.2f", totalFinanciamentos));

        gravarResumoEmArquivo(resumo.toString(), "resumo.txt");
        LerCaracteres();
        salvarFinanciamentos(financiamentos,"financiamentos.dat");
        // Não vou implementar a leitura do objeto pois não consegui resolver o erro "Erro ao ler financiamentos: modelo.Apartamento; no valid constructor"
        // ArrayList<Financiamento> financiamentosLidos = lerFinanciamentos("financiamentos.dat");

    }
    //Método para gravar arquivo .txt
    private static void gravarResumoEmArquivo(String resumo, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(resumo);
            System.out.println("Resumo gravado com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao gravar o resumo: " + e.getMessage());
        }
    }
    //Lê o arquivo .txt
    public static void LerCaracteres() {
        FileReader in = null;
        try {
            in = new FileReader("resumo.txt");
            int c;
            while ((c = in.read()) != -1) // escreve caractere a caractere; -1 = EOF
                System.out.print((char)c);// imprime como caractere
            in.close(); // fecha arquivo de entrada
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Método Grava os objetos da lista no arquivo.dat
    private static void salvarFinanciamentos(ArrayList<Financiamento> financiamentos, String nomeArquivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(financiamentos);
            System.out.println("Financiamentos salvos com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar financiamentos: " + e.getMessage());
        }
    }
    //Lê os os objetos .dat
    private static ArrayList<Financiamento> lerFinanciamentos(String nomeArquivo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (ArrayList<Financiamento>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler financiamentos: " + e.getMessage());
            return new ArrayList<>(); // Retorna uma lista vazia em caso de erro
        }
    }


}