package Exercicio;

import Exercicio.Pilha;

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

            if (aux == '+' || aux == '*') {
                minhaPilha.push(aux);
            } else if (aux == '(') {
                minhaPilha.push(aux);
            } else if (aux == ')') {
                while (!minhaPilha.isEmpty() && minhaPilha.peek() != '(') {
                    saida += minhaPilha.pop();
                }
                if (!minhaPilha.isEmpty() && minhaPilha.peek() == '(') {
                    minhaPilha.pop(); // Remova o '(' da pilha

                }
            } else {
                saida += aux.toString();
            }
        }
        while (!minhaPilha.isEmpty()) {
            saida += minhaPilha.pop();
        }
        System.out.println(saida);
    }
}
