package PilhaDinamica;

public class Main {
    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Pilha:");
        pilha.display();

        while(!pilha.isEmpty()) {
            System.out.println("Desempilhando: "+pilha.pop());
        }

    }
}
