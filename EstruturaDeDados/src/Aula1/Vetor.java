package Aula1;

public class Vetor {

    private int vetor[];
    private int quantidade;

    public Vetor(int tamanho) {
        this.vetor = new int[tamanho];
        this.quantidade = 0;
    }

    public boolean isEmpty() {
        if (quantidade == 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isFull() {
        if (quantidade == vetor.length) {
            return true;
        } else {
            return false;
        }
    }

    public void add(int valor) {
        if (isFull()) {
            System.out.println("Vetor cheio");
        } else {
            vetor[quantidade] = valor;
            quantidade++;
        }
    }

    public boolean procurar(int valor) {
        int i;
        for (i = 0; i < quantidade; i++)
            if (vetor[i] == valor)
                break;

        if (i == quantidade)
            return false;
        else
            return true;
    }

    public void display() {
        for (int i = 0; i < quantidade; i++) {
            System.out.print(vetor[i] + " ");

            System.out.println("");
        }
    }

    public boolean remover(int valor) {
        int i;
        for (i = 0; i < quantidade; i++) {
            if (valor == vetor[i])
                break;
        }
        if (i == quantidade) {
            return false;
        } else {
            for (int j = i; j < quantidade - 1; j++) {
                vetor[j] = vetor[j + 1];
            }
            quantidade--;
            return true;
        }
    }

}
