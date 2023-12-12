package ArvoreAVL;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        
        ArvoreAVL arvoreAVL = new ArvoreAVL(new Elemento(ler.nextInt()));
        System.out.println(arvoreAVL.printArvore(0));

        while (true) {
            arvoreAVL = arvoreAVL.inserir(new Elemento(ler.nextInt()));
            System.out.println(arvoreAVL.printArvore(0));
        }
    }
}
