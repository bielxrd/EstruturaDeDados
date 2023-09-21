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
        if(quantidade == vetor.length) {
            return true;
        }
        else {
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

    public int acharValor(int valor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                return i;
            }
        }
        return -1;
    }



    



}
