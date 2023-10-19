package Exercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String saida = "";

        System.out.println("Escreva uma expressão");
        String expressao = ler.nextLine();
        Pilha<Character> minhaPilha = new Pilha<>(expressao.length());

        for (int i = 0; i < expressao.length(); i++) {
            Character aux = expressao.charAt(i);
            if (aux == '+' || aux == '*' || aux == '-' || aux == '/') {
                while (!minhaPilha.isEmpty() && precedencia(aux) <= precedencia(minhaPilha.peek())) {
                    saida += minhaPilha.pop();
                }
                minhaPilha.push(aux);
            } else if (aux == '(') {
                minhaPilha.push(aux);
            } else if (aux == ')') {
                while (!minhaPilha.isEmpty() && minhaPilha.peek() != '(') {
                    saida += minhaPilha.pop();
                }
                if (!minhaPilha.isEmpty() && minhaPilha.peek() == '(') {
                    minhaPilha.pop();
                }
            } else {
                saida += aux;
            }
        }

        while (!minhaPilha.isEmpty()) {
            saida += minhaPilha.pop();
        }
        System.out.println(saida);
    }

    public static int precedencia(char aux) {
        if (aux == '+' || aux == '-') {
            return 2;
        } else if (aux == '*' || aux == '/') {
            return 1;
        } else {
            return 0;
        }
    }
}
