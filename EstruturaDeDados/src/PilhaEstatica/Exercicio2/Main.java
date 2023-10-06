package PilhaEstatica.Exercicio2;

import java.util.Scanner;

public class Main {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite a expressao");
        String expressao = ler.nextLine();

        Pilha pilha = new Pilha(100);
        boolean erro = false;
        for (int i = 0; i < expressao.length(); i++) {
            char char1, char2;
            char1 = expressao.charAt(i);
            switch (char1) {
                case '(':
                case '[':
                case '{':
                    pilha.push(char1);
                    break;

                case ')':
                case ']':
                case '}':
                    if (!pilha.isEmpty()) {
                        char2 = pilha.pop();
                        if (char1 == ')' && char2 == '(' || char1 == ']' && char2 == '['
                                || char1 == '}' && char2 == '{') {

                        } else {
                            System.out.println("Expressao esta incorreta na posicao: "+i);
                            erro = true;
                        }
                    } else {
                        System.out.println("A expressao esta incorreta na posicao: "+i);
                        erro = true;
                    }
                    break;

            }
            if (erro)
                break;

        }
        if(!erro) {
            System.out.println("A expressão esta Correta");
        }

    }

}
