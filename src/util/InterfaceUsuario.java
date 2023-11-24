package util;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    //Interface da classe com métodos públicos

    public static double entradaTamanhoTerreno() {
        Scanner scanner = new Scanner(System.in);
        double tamanhoTerreno = 0;

        while (true) {
            try {
                System.out.print("Digite o tamanho do terreno: ");
                tamanhoTerreno = scanner.nextDouble();

                if (tamanhoTerreno <= 0) {
                    throw new IllegalArgumentException("O tamanho do terreno deve ser maior que zero.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return tamanhoTerreno;
    }

    public static int entradaNumeroVagas() {
        Scanner scanner = new Scanner(System.in);
        int numeroVagas = 0;

        while (true) {
            try {
                System.out.print("Digite o número de vagas: ");
                numeroVagas = scanner.nextInt();

                if (numeroVagas <= 0) {
                    throw new IllegalArgumentException("O número de vagas deve ser maior que zero.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return numeroVagas;
    }

    public static int entradaNumeroAndar() {
        Scanner scanner = new Scanner(System.in);
        int numeroAndar = 0;

        while (true) {
            try {
                System.out.print("Digite o número de andares do apartamento: ");
                numeroAndar = scanner.nextInt();

                if (numeroAndar <= 0) {
                    throw new IllegalArgumentException("O número de andares deve ser maior que zero.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return numeroAndar;
    }

    public static double entradaAreaConstruida() {
        Scanner scanner = new Scanner(System.in);
        double tamAreaConstruida = 0;

        while (true) {
            try {
                System.out.print("Digite a área construída: ");
                tamAreaConstruida = scanner.nextDouble();

                if (tamAreaConstruida <= 0) {
                    throw new IllegalArgumentException("A área construída deve ser maior que zero.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return tamAreaConstruida;
    }

    public static String entradaTipoZonaConstruida() {
        Scanner scanner = new Scanner(System.in);
        String tipoZonaConstruida = "";

        while (true) {
            try {
                System.out.print("Digite o tipo de zona construída (por exemplo, 'Residencial', 'Comercial'): ");
                tipoZonaConstruida = scanner.next();

                if (tipoZonaConstruida.trim().isEmpty()) {
                    throw new IllegalArgumentException("O tipo de zona construída não pode estar vazio.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return tipoZonaConstruida;
    }

    public static double entradaValorImovel() {
        Scanner scanner = new Scanner(System.in);
        double valorImovel = 0;

        while (true) {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valorImovel = scanner.nextDouble();

                if (valorImovel <= 0) {
                    throw new IllegalArgumentException("O valor do imóvel deve ser maior que zero.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return valorImovel;
    }

    public static int entradaPrazoFinanciamento() {
        Scanner scanner = new Scanner(System.in);
        int prazoFinanciamento = 0;

        while (true) {
            try {
                System.out.print("Digite o prazo do financiamento (em anos): ");
                prazoFinanciamento = scanner.nextInt();

                if (prazoFinanciamento <= 0) {
                    throw new IllegalArgumentException("O prazo do financiamento deve ser maior que zero.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return prazoFinanciamento;
    }

    public static double entradaTaxaJuros() {
        Scanner scanner = new Scanner(System.in);
        double taxaJurosAnual = 0;

        while (true) {
            try {
                System.out.print("Digite a taxa de juros anual (em %): ");
                taxaJurosAnual = scanner.nextDouble();

                if (taxaJurosAnual <= 0 || taxaJurosAnual > 1000) {
                    throw new IllegalArgumentException("A taxa de juros deve estar entre 0% e 1000%.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return taxaJurosAnual;
    }

    public static int escolherTipoImovel() {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while (true) {
            try {
                System.out.println("Escolha o tipo de imóvel:");
                System.out.println("1 - Casa");
                System.out.println("2 - Apartamento");
                System.out.println("3 - Terreno");
                System.out.print("Digite o número correspondente ao tipo de imóvel desejado: ");
                escolha = scanner.nextInt();

                if (escolha < 1 || escolha > 3) {
                    throw new IllegalArgumentException("Escolha inválida. Digite um número entre 1 e 3.");
                }

                break; // Sair do loop se a entrada for válida
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número válido.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return escolha;
    }

    public static String getTipoFinanciamento(Financiamento financiamento) {
        if (financiamento instanceof Casa) {
            return "Casa";
        } else if (financiamento instanceof Apartamento) {
            return "Apartamento";
        } else if (financiamento instanceof Terreno) {
            return "Terreno";
        } else {
            return "Desconhecido";
        }
    }
}
