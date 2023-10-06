package PilhaEstatica.Exercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        String nome = ler.nextLine();
        PilhaExc minPilhaExc = new PilhaExc(nome.length());
        for (int i = 0; i < minPilhaExc.size(); i++) {
            char x = nome.charAt(i);
            minPilhaExc.push(x);
        }

        while(!minPilhaExc.isEmpty()) {
            char value = minPilhaExc.pop();
            System.out.print(value + " ");
        }
        System.err.println("");
    }
}
