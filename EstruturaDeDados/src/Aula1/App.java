package Aula1;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // Crie um array do tipo inteiro chamado nota com tamanho 5
        int[] nota = new int[5];

        // Crie um Scanner para ler as notas
        Scanner leitor = new Scanner(System.in);

        // Insira valores nesse array usando for
        for (int i = 0; i < nota.length; i++) {
            System.out.println("Digite a nota do aluno " + (i + 1));
            nota[i] = leitor.nextInt();
        }
        // Imprima o array usando for
        for (int i = 0; i < nota.length; i++) {
            System.out.println("A nota do aluno " + (i + 1) + " é " + nota[i]);
        }
        //feche o scanner
        leitor.close();

        // System.out.println(nota.toString());

                

    }
}
