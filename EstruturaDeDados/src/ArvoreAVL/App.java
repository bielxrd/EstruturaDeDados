package ArvoreAVL;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o valor da raiz da árvore AVL: ");
        ArvoreAVL arvoreAVL = new ArvoreAVL(new Elemento(ler.nextInt()));

        System.out.println(arvoreAVL.printArvore(0));

        while (true) {
            System.out.print("Digite o valor a ser inserido na árvore (ou digite 'sair' para encerrar): ");
            String input = ler.next();

            if (input.equalsIgnoreCase("sair")) {
                System.out.println("Encerrando o programa.");
                break;
            }

            int valor = Integer.parseInt(input);
            arvoreAVL = arvoreAVL.inserir(new Elemento(valor));
            System.out.println(arvoreAVL.printArvore(0));
        }

        ler.close();
    }
}
