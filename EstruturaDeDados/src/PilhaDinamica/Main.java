package PilhaDinamica;

public class Main {
    public static void main(String[] args) {
        PilhaDinamica<Character> pilha = new PilhaDinamica();

        pilha.push('g');
        pilha.push('a');
        pilha.push('b');

        System.out.println("Pilha:");
        pilha.display();

        while(!pilha.isEmpty()) {
            System.out.println("Desempilhando: "+pilha.pop());
        }

    }
}
