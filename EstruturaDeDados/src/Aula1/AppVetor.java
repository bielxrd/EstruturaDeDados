package Aula1;

import java.util.Scanner;

/**
 * @(#)AppVetor.java
 *
 */
public class AppVetor {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        int tamanho = 100;
        Vetor arr = new Vetor(tamanho);
        int opcao = 0;
        do {
             opcao = menu();

            if (opcao == 1) {
                System.out.println("Qual valor deseja inserir?");
                int valor = ler.nextInt();
                arr.add(valor);
            } else if (opcao == 2) {
                System.out.println("Qual valor deseja remover?");
                int valor = ler.nextInt();
                arr.remover(valor);
            } else if (opcao == 3) {
                System.out.println("Qual valor deseja procurar?");
                int valor = ler.nextInt();
                if (arr.procurar(valor)) {
                    System.out.println("O valor existe no vetor");
                } else {
                    System.out.println("O valor não existe no vetor");
                }
            } else if (opcao == 4) {
                arr.display();
            }
            else if (opcao == 5) {
                System.out.println("Qual valor deseja alterar?");
                int valor = ler.nextInt();
                System.out.println("Qual valor deseja colocar?");	
                int novo = ler.nextInt();

                arr.alterar(valor, novo);
            }
            else if (opcao == 6) {
                System.out.println("Qual valor deseja procurar?");	
                int valor = ler.nextInt();
                System.out.println("O valor "+valor+" esta na posicao "+arr.getPosicao(valor));

            }
        } while (opcao != 0);

    }

    public static int menu() {
        System.out.println("1 - Inserir");
        System.out.println("2 - Remover");
        System.out.println("3 - Procurar");
        System.out.println("4 - Imprimir");
        System.out.println("5 - Alterar");
        System.out.println("6 - Pegar posicao do valor.");
        System.out.println("0 - Sair");
        return ler.nextInt();
    }
}